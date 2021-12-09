package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import bl.Util;
import dao.ProjectDao;
import entitiy.Project;

public class ProjectService implements ProjectDao{

	private static final String INSERT = "insert into project(title) values"
			+ " (?);";
	private static final String SELECT_ALL = "select * from project";
	private static final String SELECT_ONE = "select * from project where pr_id=?";
	private static final String UPDATE = "update project set title=? where pr_id=?";
	private static final String DELETE = "delete from project where pr_id=?";
	
	private Connection getCon() {
		return Util.getConnection();
	}
	
	@Override
	public void addProject(Project project) {
		try(PreparedStatement pst = getCon().prepareStatement(INSERT)) {
			Project pr = new Project();
			pst.setString(1, pr.getTitle());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<Project> getAllProject() {
		List<Project> result = new LinkedList<>();
		try(PreparedStatement pst = getCon().prepareStatement(SELECT_ALL);
				ResultSet rs = pst.executeQuery()){
			while(rs.next()) {
				Project pr = new Project();
				pr.setPrId(rs.getLong("pr_id"));
				pr.setTitle(rs.getString("title"));
				result.add(pr);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public Project getProject(Long prId) {
		Project pr = new Project();
		try(PreparedStatement pst = getCon().prepareStatement(SELECT_ONE)){
			ResultSet rs = pst.executeQuery();
			pst.setLong(1, prId);
			if(rs.next()) {
				pr.setPrId(rs.getLong("pr_id"));
				pr.setTitle(rs.getString("title"));
			}
			rs.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return pr;
	}

	@Override
	public void updateProject(Long prIdForUpdate, Project pr) {
		try(PreparedStatement pst = getCon().prepareStatement(UPDATE)){
			pst.setLong(2, prIdForUpdate);
			pst.setString(1, pr.getTitle());
			pst.executeUpdate();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void removeProject(Project pr) {
		try(PreparedStatement prt = getCon().prepareStatement(DELETE)){
			prt.setLong(1, pr.getPrId());
			prt.executeUpdate();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
