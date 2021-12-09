package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import bl.Util;
import dao.EmployeeDao;
import entitiy.Employee;

public class EmployeeService implements EmployeeDao {

	private static final String INSERT = "insert into employee(first_name, last_name, birthday, empress_id) values"
			+ " (?, ?, ?, ?);";
	private static final String SELECT_ALL = "select * from employee";
	private static final String SELECT_ONE = "select * from employee where em_id=?";
	private static final String UPDATE = "update adress set first_name=?, last_name=?, birthday=?, empress_id=? where em_id=?";
	private static final String DELETE = "delete from employee where em_id=?";
	
	private Connection getCon() {
		return Util.getConnection();
	}
	
	@Override
	public void addEmployee(Employee employee) {
		try(PreparedStatement pst = getCon().prepareStatement(INSERT)) {
			Employee emp = new Employee();
			pst.setString(1, emp.getFirstName());
			pst.setString(2,  emp.getLastName());
			pst.setDate(3, emp.getBirthday());
			pst.setLong(4, emp.getAddressId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> result = new LinkedList<>();
		try(PreparedStatement pst = getCon().prepareStatement(SELECT_ALL);
				ResultSet rs = pst.executeQuery()){
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmId(rs.getLong("em_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setBirthday(rs.getDate("birthday"));
				emp.setAddressId(rs.getLong("empress_id"));
				result.add(emp);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public Employee getEmployee(Long emId) {
		Employee emp = new Employee();
		try(PreparedStatement pst = getCon().prepareStatement(SELECT_ONE)){
			ResultSet rs = pst.executeQuery();
			pst.setLong(1, emId);
			if(rs.next()) {
				
				emp.setEmId(rs.getLong("em_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setBirthday(rs.getDate("birthday"));
				emp.setAddressId(rs.getLong("empress_id"));
			}
			rs.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return emp;
	}

	@Override
	public void updateEmployee(Long emIdForUpdate, Employee emp) {
		try(PreparedStatement pst = getCon().prepareStatement(UPDATE)){
			pst.setLong(5, emIdForUpdate);
			pst.setString(1, emp.getFirstName());
			pst.setString(2, emp.getLastName());
			pst.setDate(3, emp.getBirthday());
			pst.setLong(4, emp.getAddressId());
			pst.executeUpdate();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void removeEmployee(Employee emp) {
		try(PreparedStatement prt = getCon().prepareStatement(DELETE)){
			prt.setLong(1, emp.getEmId());
			prt.executeUpdate();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

}
