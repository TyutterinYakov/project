package dao;

import java.util.List;

import entitiy.Address;

public interface AddressDao {
	
	Long addAddress(Address address);
	List<Address> getAllAddress();
	Address getAddress(Long adId);
	void updateAddress(Long adIdForUpdate, Address add);
	void removeAddress(Address add);
}
