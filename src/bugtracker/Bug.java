package bugtracker;


public class Bug {
	private String title;
	private String description;
	private Severity severity;
	private Status status;
	
	
	
	
	public Bug(String title, String description, Severity severity, Status status) {
		super();
		this.title = title;
		this.description = description;
		this.severity = severity;
		this.status = status;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Severity getSeverity() {
		return severity;
	}
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	

}
