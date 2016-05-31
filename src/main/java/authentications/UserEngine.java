package authentications;

import java.util.UUID;

import org.springframework.stereotype.Service;

import mannyobjects.Address;
import mannyobjects.UserProfile;
import interfaces.IUserEngine;

@Service
public class UserEngine implements IUserEngine {

	public UserEngine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProfile getUser(UUID userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean createUser(String userName, Address address) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUser(UserProfile user, UUID userId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUser(UUID userId) {
		// TODO Auto-generated method stub
		return false;
	}

}
