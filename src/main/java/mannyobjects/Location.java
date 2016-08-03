package mannyobjects;

import interfaces.ICRUDOperations;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location implements ICRUDOperations<Location> {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	@Column
	private double lat;
	@Column
	private double lon;
	@Column
	private Date time;
	@Column
	private String location;
	@Column
	private UUID userId;
	@Column
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

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void save(Location saveMe) {
		// TODO Auto-generated method stub
		
	}

	public void update(Location updateMe) {
		// TODO Auto-generated method stub
		
	}

	public void insert(Location insertMe) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Location deleteMe) {
		// TODO Auto-generated method stub
		
	}
	
	

}
