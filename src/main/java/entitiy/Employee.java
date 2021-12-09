package entitiy;

import java.sql.Date;

public class Employee {

	private Long emId;
	private String firstName;
	private String lastName;
	private Date birthday;
	private Long addressId;
	
	
	public Employee() {
		super();
	}


	public Employee(Long emId, String firstName, String lastName, Date birthday, Long addressId) {
		super();
		this.emId = emId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.addressId = addressId;
	}


	public Long getEmId() {
		return emId;
	}


	public void setEmId(Long emId) {
		this.emId = emId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public Long getAddressId() {
		return addressId;
	}


	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
	@Override
	public String toString() {
		
		return emId+" "+firstName+" "+lastName+" "+birthday+" "+addressId;
	}
	
	
}
