package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import bl.Util;
import dao.AddressDao;
import entitiy.Address;

public class AddressService implements AddressDao{
	
	
	private static final String INSERT = "insert into address(country, city, street, post_code) values"
			+ " (?, ?, ?, ?);";
	private static final String SELECT_ALL = "select * from address";
	private static final String SELECT_ONE = "select * from address where ad_id=?";
	private static final String UPDATE = "update adress set country=?, city=?, street=?, post_code=? where ad_id=?";
	private static final String DELETE = "delete from address where ad_id=?";
	
	public Long adid=-1L;
	

	
	private Connection getCon() {
		return Util.getConnection();
	}
	
	public Long addAddress(Address add) {
		try(PreparedStatement pst = getCon().prepareStatement(INSERT, new String[] {"ad_id"})) {
			pst.setString(1, add.getCountry());
			pst.setString(2,  add.getCity());
			pst.setString(3, add.getStreet());
			pst.setString(4, add.getPostCode());
			pst.executeUpdate();
			ResultSet rst = pst.getGeneratedKeys();
			if(rst.next()) {
				adid = rst.getLong(1);
				
			}
			rst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return adid;
	}

	public List<Address> getAllAddress() {
		List<Address> result = new LinkedList<>();
		try(PreparedStatement pst = getCon().prepareStatement(SELECT_ALL);
				ResultSet rs = pst.executeQuery()){
			while(rs.next()) {
				Address add = new Address();
				add.setAdId(rs.getLong("ad_id"));
				add.setCountry(rs.getString("country"));
				add.setCity(rs.getString("city"));
				add.setStreet(rs.getString("street"));
				add.setPostCode(rs.getString("post_code"));
				result.add(add);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	
	public Address getAddress(Long adId) {
		Address add = new Address();
		try(PreparedStatement pst = getCon().prepareStatement(SELECT_ONE)){
			ResultSet rs = pst.executeQuery();
			pst.setLong(1, adId);
			if(rs.next()) {
				add.setAdId(rs.getLong("ad_id"));
				add.setCountry(rs.getString("country"));
				add.setCity(rs.getString("city"));
				add.setStreet(rs.getString("street"));
				add.setPostCode(rs.getString("post_code"));
			}
			rs.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return add;
	}
	
	public void updateAddress(Long adIdForUpdate, Address add) {
		try(PreparedStatement pst = getCon().prepareStatement(UPDATE)){
			pst.setLong(5, adIdForUpdate);
			pst.setString(1, add.getCountry());
			pst.setString(2, add.getCity());
			pst.setString(3, add.getStreet());
			pst.setString(4, add.getPostCode());
			pst.executeUpdate();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void removeAddress(Address add) {
		try(PreparedStatement prt = getCon().prepareStatement(DELETE)){
			prt.setLong(1, add.getAdId());
			prt.executeUpdate();	
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
