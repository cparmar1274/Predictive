package mannyobjects;

import java.util.Map;

public class UserMatrix {

	private UserProfile userName;
	private Address address;
	private Map<Integer, Location> userLocations;

	public UserProfile getUserName() {
		return userName;
	}

	public void setUserName(UserProfile userName) {
		this.userName = userName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Map<Integer, Location> getUserLocations() {
		return userLocations;
	}

	public void setUserLocations(Map<Integer, Location> userLocations) {
		this.userLocations = userLocations;
	}

}
