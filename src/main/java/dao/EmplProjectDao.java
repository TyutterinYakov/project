package dao;

import java.util.List;

import entitiy.EmplProject;


public interface EmplProjectDao {
	void addProject(EmplProject empl);
	List<EmplProject> getAllProject();
	
	EmplProject getEmplProjId(Long emId, Long prId);
	
	EmplProject getProject(Long employeeId);
	void updateProject(Long emIdForUpdate, EmplProject empl);
	void removeProject(EmplProject empl);
}
