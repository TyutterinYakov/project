package tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import bl.Util;
import entitiy.Address;

public class AddressServiceTest {
	
	private Connection getCon() {
		return Util.getConnection();
	}
	
	@Test
	public void addAddressTest(Address add, Long id) {
		System.out.println(id);
		try(PreparedStatement prt = getCon().prepareStatement("Select * from address where ad_id=?")){
			prt.setLong(1, id);
			ResultSet rs = prt.executeQuery();
			if(rs.next()) {
				if(add.getCountry().compareTo(rs.getString("country"))==0);
				if(add.getCity().compareTo(rs.getString("city"))==0);
				if(add.getStreet().compareTo(rs.getString("street"))==0);
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

//	@Test
//	public List<Address> getAllAddress() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Test
//	public Address getAddress(Long adId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Test
//	public void updateAddress(Long adIdForUpdate, Address add) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Test
//	public void removeAddress(Address add) {
//		// TODO Auto-generated method stub
//		
//	}
//	
	
	
	
	
}
