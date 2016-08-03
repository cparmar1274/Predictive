package authentications;

import org.springframework.stereotype.Repository;

@Repository
public class DBConnection {

	public static DBConnection dbConnection = null;

	public static boolean connectDatabase() {
		return dbConnection!=null;
	}

	public static boolean getConnection() {
		if(dbConnection==null){
			dbConnection = new DBConnection();
		}
		return true;
	}

}
