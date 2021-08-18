package org.generated.project.domain.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.seedstack.business.domain.BaseAggregateRoot;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@NamedQuery(name="getEmployee", query ="select username, password From Employee where username=:username and password=:password ")
public class Employee extends BaseAggregateRoot<EmployeeId> {
	
	
	@EmbeddedId
	private EmployeeId id;
	private String username;
	private String email;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
	public  Date doj;
	private String password;
	
	private String projectId;
	private String projectName;
	private String jobRole;
	private String gender;
	
	@OneToMany(mappedBy="employee")
	private Collection<LeaveData> leaveData = new ArrayList<>();
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(EmployeeId id, String username, String email, Date doj, String password, String projectId,
			String projectname, String jobrole, String gender) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.doj = doj;
		this.password = password;
		this.projectId = projectId;
		this.projectName = projectName;
		this.jobRole = jobRole;
		this.gender = gender;
	}
	public EmployeeId getId() {
		return id;
	}
	public void setId(EmployeeId id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	
}
    
    
    
    
    
    
      
   
   
   
   
   
   
   
   
   
   
   
   
  
	   
   
   
