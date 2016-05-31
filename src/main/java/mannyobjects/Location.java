package mannyobjects;

import java.util.Date;
import java.util.UUID;

public class Location {

	private double lat;
	private double lon;
	private Date time;
	private String location;
	private UUID userId;
	private String message;

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getLocation() {
		this.location = "[" + this.getLat() + "," + this.getLat() + "]";
		return this.location;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
