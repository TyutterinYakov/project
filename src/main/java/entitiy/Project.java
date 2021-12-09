package entitiy;

public class Project {
	
	private Long prId;
	private String title;
	public Project(Long prId, String title) {
		super();
		this.prId = prId;
		this.title = title;
	}
	public Project() {
		super();
	}
	public Long getPrId() {
		return prId;
	}
	public void setPrId(Long prId) {
		this.prId = prId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	@Override
	public String toString() {
		
		return prId+" "+title;
	}
}
