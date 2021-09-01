package org.generated.project.domain.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.seedstack.business.domain.BaseAggregateRoot;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@NamedQuery(name = "getEmployeeAttendance", query = "select ad.date, ad.justification From AttendanceData ad where ad.employee.id=:employeeId "
		+ "order by ad.date ASC ")
public class AttendanceData extends BaseAggregateRoot<AttendanceDataId> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int AttendanceDataId;


	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "local")
	private Date date;

	private String justification;

	public AttendanceData() {
		super();
	}

	public AttendanceData(int AttendanceDataId) {

		this.AttendanceDataId = AttendanceDataId;

	}

	public AttendanceData(Employee employee, int AttendanceDataId, Date date, String justification) {

		this.employee = employee;
		this.AttendanceDataId = AttendanceDataId;
		this.date = date;
		this.justification = justification;

	}

	@Override
	public String toString() {
		return "Employee [employeeId= " + employee + ", date= " + date + 
				 ", justification= " + justification;
	}

	public Date getDate() {

		return date;
	}

	public void setDate(Date date) {

		this.date = date;
	}


	public String getJustification() {
		return justification;
	}

	public void setTypeOfLeave(String justification) {
		this.justification = justification;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getAttendanceDataId() {
		return AttendanceDataId;
	}

	public void setAttendanceDataId(int AttendanceDataId) {
		this.AttendanceDataId = AttendanceDataId;
	}



}

