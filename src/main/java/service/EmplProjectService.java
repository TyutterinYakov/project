package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import bl.Util;
import dao.EmplProjectDao;
import entitiy.EmplProject;
import entitiy.Project;

public class EmplProjectService implements EmplProjectDao{

	private static final String INSERT = "insert into empl_proj(employee_id, project_id) values"
			+ " (?, ?);";
	private static final String SELECT_ALL = "select * from empl_proj";
	private static final String SELECT_ONE = "select * from empl_proj where pr_id=?";
	//private static final String UPDATE = "update empl_proj set employee_id=? where project_id=?";
	private static final String DELETE = "delete from empl_proj where employee_id=? and project_id=?";
	
	private Connection getCon() {
		return Util.getConnection();
	}
	
	@Override
	public void addProject(EmplProject empl) {
		try(PreparedStatement pst = getCon().prepareStatement(INSERT)) {
			EmplProject pr = new EmplProject();
			pst.setLong(1, pr.getEmployeeId());
			pst.setLong(2, pr.getProjectId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public List<EmplProject> getAllProject() {
		List<EmplProject> result = new LinkedList<>();
		try(PreparedStatement pst = getCon().prepareStatement(SELECT_ALL);
				ResultSet rs = pst.executeQuery()){
			while(rs.next()) {
				EmplProject pr = new EmplProject();
				pr.setEmployeeId(rs.getLong("employee_id"));
				pr.setProjectId(rs.getLong("project_id"));
				result.add(pr);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public EmplProject getEmplProjId(Long emId, Long prId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmplProject getProject(Long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProject(Long emIdForUpdate, EmplProject empl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProject(EmplProject empl) {
		// TODO Auto-generated method stub
		
	}

}
