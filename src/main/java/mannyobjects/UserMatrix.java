package mannyobjects;

import java.util.Map;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class UserMatrix {

	@Id
	private Long Id;
	
	@Column
	private UUID userMatrixId;
	
	private Map<Integer, Location> userLocations;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    @PrimaryKeyJoinColumn
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

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
	

}
