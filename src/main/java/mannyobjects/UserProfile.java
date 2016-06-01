package mannyobjects;

import java.util.UUID;

public class UserProfile {

	private String userName;
	private String email;
	private String imageUrl;
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
	
	

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/*Created on demand*/
	public Location getCurrentLocation() {
		return this.getUserMatrix().getCurrentLocation();
	}
	/*Created on demand*/
	public String getMessage() {
		return this.getUserMatrix().getCurrentLocation().getMessage();
	}
	
	

}
