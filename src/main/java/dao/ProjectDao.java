package dao;

import java.util.List;


import entitiy.Project;

public interface ProjectDao {
	void addProject(Project project);
	List<Project> getAllProject();
	Project getProject(Long prId);
	void updateProject(Long prIdForUpdate, Project project);
	void removeProject(Project project);
}
