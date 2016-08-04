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

class Node {
	
	public Heading heading;
	public List<Node> children;

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

	@Override
	public String toString() {
		return "Node [heading=" + heading + ", children=" + children + "]";
	}

}

class Heading {

	public String text;
	public Integer weight;
	public String type;
	public String startsWith;

	public Heading(String type, String value) {
		super();
		this.type = type;
		this.text = value;
		this.weight = 1;
		this.startsWith = IndexUtility.getStartsWith(type);
	}

	public Object getCurrentIndex() {

		Object currentIndex;

		switch (this.startsWith) {
		case IndexUtility.ALPHABET_KEY:
			currentIndex = IndexUtility.ALPHABET_VALUES.get(this.weight);
			break;
		case IndexUtility.ROMAN_KEY:
			currentIndex = IndexUtility.ROMAN_VALUES.get(this.weight);
			break;
		default:
			currentIndex = this.weight;
			break;
		}

		return currentIndex;
	}

	@Override
	public String toString() {
		return "[ " + this.type + " - " + this.text + " - " + this.weight
				+ " - " + this.startsWith + " - " + this.getCurrentIndex()
				+ " ]";
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
		Node node = new Node();	
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
			displayObject.weight = weightedDocs.get(key);
			readyToDisplay.add(displayObject);
			addHeadingToTree(node,displayObject);
			preKey = key;
		}
		System.out.println("Node : "+node);
		return readyToDisplay;
	}

	private void addHeadingToTree(Node node,Heading displayObject) {
		if(node.heading==null){
			node.heading = displayObject;
		}
		if(node.children==null){
			node.children = new ArrayList<Node>();
		}
		
		if(displayObject.weight-node.heading.weight == 1){
			Node nNode = new Node();
			nNode.heading = displayObject;
			node.addChildren(nNode);
		} else {
			for(Node cNode : node.getChildren()){
				addHeadingToTree(cNode, displayObject);
			}
		}
		
	}

}

public class Document {

	public static void main(String[] args) {
		try {
			Long startTime = System.currentTimeMillis();
			String filePath = "//home//chiragparmar//workspace//Predictive//src//main//java//starter//document//document.txt";
			DocumentParserEngine docEngine = new DocumentParserEngine(filePath);
			List<Heading> parsedDocument = docEngine.generateParsedDocument();
			System.out.println("Parsing took : "
					+ (System.currentTimeMillis() - startTime) + " ms");
			for (Heading docObj : parsedDocument) {
				System.out.println(IndexUtility.getTabbing(docObj.type)
						+ docObj.getCurrentIndex() + ". " + docObj.text);
			}
			System.out.println(parsedDocument);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class IndexUtility {

	public static final String ALPHABET_KEY = "ALPHABET";
	public static final List<String> ALPHABET_VALUES = Arrays
			.asList("#,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,,R,S,T,U,V,W,X,Y,Z"
					.split(","));

	public static final String ROMAN_KEY = "ROMAN";
	public static final List<String> ROMAN_VALUES = Arrays
			.asList("#,I,II,III,IV,V,VI,VII,VIII,IX,X".split(","));

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