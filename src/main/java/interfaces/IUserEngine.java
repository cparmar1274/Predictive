package interfaces;

import java.util.UUID;

import mannyobjects.Address;
import mannyobjects.UserProfile;

public interface IUserEngine {

	UserProfile getUser(UUID userId);
	
	boolean createUser(String userName,Address address);
	
	boolean updateUser(UserProfile user,UUID userId);
	
	boolean deleteUser(UUID userId);
	
}
