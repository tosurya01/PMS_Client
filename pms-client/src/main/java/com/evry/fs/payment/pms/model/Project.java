package com.evry.fs.payment.pms.model;

public class Project {
	private long projectId;
	private String projectName;
	private String projectStatus;
	private int estimatedHrs;
	private int loggedHrs;
	private int remainingHrs;

	public Project() {
		super();
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public int getEstimatedHrs() {
		return estimatedHrs;
	}

	public void setEstimatedHrs(int estimatedHrs) {
		this.estimatedHrs = estimatedHrs;
	}

	public int getLoggedHrs() {
		return loggedHrs;
	}

	public void setLoggedHrs(int loggedHrs) {
		this.loggedHrs = loggedHrs;
	}

	public int getRemainingHrs() {
		return remainingHrs;
	}

	public void setRemainingHrs(int remainingHrs) {
		this.remainingHrs = remainingHrs;
	}

}
