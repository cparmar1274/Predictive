package authentications;

import org.springframework.stereotype.Service;

@Service
public class DBConnection {

	public DBConnection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static boolean connectDatabase() {
		return true;
	}

	public static boolean getConnection() {
		return true;
	}

}
