package mannyobjects;

import java.util.UUID;

public class UserProfile {

	private String userName;
	private UUID userId;
	private Address address;
	private UserMatrix userMatrix;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public UserMatrix getUserMatrix() {
		return userMatrix;
	}

	public void setUserMatrix(UserMatrix userMatrix) {
		this.userMatrix = userMatrix;
	}
	
	

}
