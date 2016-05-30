package mannyobjects;

import java.util.Map;
import java.util.UUID;

public class UserMatrix {

	private UUID userMatrixId;
	private Map<Integer, Location> userLocations;
	private Location currentLocation;

	public Map<Integer, Location> getUserLocations() {
		return userLocations;
	}

	public void setUserLocations(Map<Integer, Location> userLocations) {
		this.userLocations = userLocations;
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	public UUID getUserMatrixId() {
		return userMatrixId;
	}

	public void setUserMatrixId(UUID userMatrixId) {
		this.userMatrixId = userMatrixId;
	}

	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	

}
