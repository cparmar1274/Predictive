package starter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class IndexUtility {

	public static final String ALPHABET_KEY = "ALPHABET";
	public static final String ALPHABET_STRING = "#,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,,R,S,T,U,V,W,X,Y,Z";
	public static final List<String> ALPHABET_VALUES = Arrays.asList(ALPHABET_STRING.split(","));

	public static final String ROMAN_KEY = "ROMAN";
	public static final String ROMAN_STRING = "#,I,II,III,IV,V,VI,VII,VIII,IX,X";
	public static final List<String> ROMAN_VALUES = Arrays.asList(ROMAN_STRING.split(","));

	public static final String NUMERIC_KEY = "NUMERIC";

	public static String getStartsWith(String type) {

		if (!type.isEmpty() && type.trim().equalsIgnoreCase("HEADING 2"))
			return ALPHABET_KEY;

		if (!type.isEmpty() && type.trim().equalsIgnoreCase("HEADING 3"))
			return ROMAN_KEY;

		return NUMERIC_KEY;
	}

	public static Integer getWeight(String type) {
		if (!type.isEmpty() && type.toUpperCase().contains("HEADING"))
			return Integer.parseInt(type.toUpperCase()
					.replaceAll("HEADING", "").trim());

		return 1;
	}

	public static String getTabbing(String type) {

		if (!type.isEmpty() && type.trim().equalsIgnoreCase("HEADING 2"))
			return "\t";

		if (!type.isEmpty() && type.trim().equalsIgnoreCase("HEADING 3"))
			return "\t\t";

		return "";
	}
}

class Node {
	
	public Heading heading;
	public List<Node> children;
	
	public Node(){
	    this.heading = new Heading("", "");
	    this.children = new ArrayList<Node>();
	}
	
	public Node(Heading heading) {
		super();
		this.heading = heading;
		this.children = new ArrayList<Node>();
	}

	public Heading getHeading() {
		return heading;
	}

	public void setHeading(Heading heading) {
		this.heading = heading;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void addChildren(Node child) {
		this.children.add(child);
	}
}

class Heading {
	public String type;
	public String value;
	public Integer index;
	public String startsWith;

	public Heading(String type, String value) {
		super();
		this.type = type;
		this.value = value;
		this.index = 1;
		this.startsWith = IndexUtility.getStartsWith(type);
	}

	public Object getCurrentIndex() {

		Object currentIndex;

		switch (this.startsWith) {
		case IndexUtility.ALPHABET_KEY:
			currentIndex = IndexUtility.ALPHABET_VALUES.get(this.index);
			break;
		case IndexUtility.ROMAN_KEY:
			currentIndex = IndexUtility.ROMAN_VALUES.get(this.index);
			break;
		default:
			currentIndex = this.index;
			break;
		}

		return currentIndex;
	}

	@Override
	public String toString() {
		return "[ " + this.type + " - " + this.value + " - " + this.index+ " - " + this.startsWith + " - " + this.getCurrentIndex()+ " ]";
	}

}

class DocumentParserEngine {

	public String filePath;
	public DocumentParserEngine(String filePath) {
		this.filePath = filePath;
	}

	public List<Heading> generateParsedDocument() throws IOException {

		Path path = Paths.get(this.filePath);
		List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
		
		Map<Integer, Integer> weightedDocs = new HashMap<Integer, Integer>();
		List<Heading> readyToDisplay = new ArrayList<Heading>();
		
		Integer preKey = null;
		for (String line : lines) {
		
			if (line.isEmpty() || !line.toUpperCase().startsWith("HEADING"))
			continue;
		
			String[] lineSplit = line.split("\\t");
			Integer key = IndexUtility.getWeight(lineSplit[0].trim());
			String value = lineSplit[1].trim();
		
			if (weightedDocs.containsKey(key)) {
				Integer docIndex = weightedDocs.get(key);
				docIndex++;
				if (preKey < key)
					weightedDocs.put(key, 1);
				else
					weightedDocs.put(key, docIndex);
			} else {
				weightedDocs.put(key, 1);
			}
			
			Heading displayObject = new Heading(lineSplit[0].trim(), value);
			displayObject.index = weightedDocs.get(key);
			readyToDisplay.add(displayObject);
			preKey = key;
		}
		return readyToDisplay;
	}

}

public class Document {

	public static void main(String[] args) {
		try {
			String filePath = "//home//chiragparmar//workspace//Predictive//src//main//java//starter//document//document.txt";
			DocumentParserEngine docEngine = new DocumentParserEngine(filePath);
			List<Heading> parsedDocument = docEngine.generateParsedDocument();
			for (Heading docObj : parsedDocument) {
				System.out.println(IndexUtility.getTabbing(docObj.type)	+ docObj.getCurrentIndex() + ". " + docObj.value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
