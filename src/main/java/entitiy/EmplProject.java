package entitiy;

public class EmplProject {
	private Long employeeId;
	private Long projectId;
	public EmplProject(Long employeeId, Long projectId) {
		super();
		this.employeeId = employeeId;
		this.projectId = projectId;
	}
	public EmplProject() {
		super();
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	@Override
	public String toString() {
		
		return employeeId+" "+projectId;
	}
}
