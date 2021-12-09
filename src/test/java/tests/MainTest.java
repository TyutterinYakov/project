package tests;

import entitiy.Address;
import service.AddressService;

public class MainTest {

	public static void main(String[] args) {
		AddressService addService = new AddressService();
		AddressServiceValues addValue = new AddressServiceValues();
		AddressServiceTest addTest = new AddressServiceTest();
		
		Address add = addValue.getAddress();
		
		addTest.addAddressTest(add, addService.addAddress(add));
		

	}

}
