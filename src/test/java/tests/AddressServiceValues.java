package tests;

import entitiy.Address;

public class AddressServiceValues {
	public Address getAddress() {
    Address add = new Address();
    add.setCountry("DC");
    add.setCity("Gotham City");
    add.setStreet("Arkham street 1");
    add.setPostCode("12345");
    return add;
	}
	
	
}