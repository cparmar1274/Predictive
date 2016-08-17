package mannyobjects;

import interfaces.ICRUDOperations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address implements ICRUDOperations<Address> {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	@Column
	private String aptNo;
	@Column
	private String streetName;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zipCode;
	@Column
	private String contactNo;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getAptNo() {
		return aptNo;
	}
	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public void save(Address saveMe) {
		// Write Save Me code
		
	}
	public void update(Address updateMe) {
		// TODO Auto-generated method stub
		
	}
	public void insert(Address insertMe) {
		// TODO Auto-generated method stub
		
	}
	public void delete(Address deleteMe) {
		// TODO Auto-generated method stub
		
	}
	
	

}
