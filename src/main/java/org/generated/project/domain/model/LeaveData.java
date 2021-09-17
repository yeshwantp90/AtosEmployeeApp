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
@NamedQuery(name = "getEmployeeLeave", query = "select ld.startDate, ld.endDate , ld.typeOfLeave , ld.status From LeaveData ld where ld.employee.id=:employeeId "
        + "order by ld.startDate ASC ")
public class LeaveData extends BaseAggregateRoot<LeaveDataId> {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int leaveDataId;

 


    @ManyToOne
    @JoinColumn(name = "employeeId",referencedColumnName= "employeeid")
    private Employee employee;

 

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "local")
    private Date startDate;

 

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "local")
    private Date endDate;

 

    private String typeOfLeave;
    private String status;
 

    public LeaveData() {
        super();
    }

 

    public LeaveData(int leaveDataId) {

 

        this.leaveDataId = leaveDataId;

 

    }

 

    public LeaveData(Employee employee, int leaveDataId, Date startDate, Date endDate, String typeOfLeave,String status) {

 

        this.employee = employee;
        this.leaveDataId = leaveDataId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.typeOfLeave = typeOfLeave;
        this.status=status;

 

    }

 

    @Override
    public String toString() {
        return "Employee [employeeId= " + employee + ", startDate= " + startDate + ", endDate= " + endDate
                + ", typeOfLeave= " + typeOfLeave + ",Status="+ status +"]";
    }

 

    public Date getStartDate() {

 

        return startDate;
    }

 

    public void setStartDate(Date startDate) {

 

        this.startDate = startDate;
    }

 

    public Date getEndDate() {
        return endDate;
    }

 

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

 

    public String getTypeOfLeave() {
        return typeOfLeave;
    }

 

    public void setTypeOfLeave(String typeOfLeave) {
        this.typeOfLeave = typeOfLeave;
    }

 

    public Employee getEmployee() {
        return employee;
    }

 

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

 

    public int getLeaveDataId() {
        return leaveDataId;
    }

 

    public void setLeaveDataId(int leaveDataId) {
        this.leaveDataId = leaveDataId;
    }



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}

 

 

}
 