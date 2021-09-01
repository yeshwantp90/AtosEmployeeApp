package org.generated.project.domain.model;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.seedstack.business.domain.BaseValueObject;
@Embeddable 
public class AttendanceDataId extends BaseValueObject {
	
	
	
	private  int AttendanceDataId;
	
	
	 public AttendanceDataId() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AttendanceDataId(int id) {
		// TODO Auto-generated constructor stub
		 this.AttendanceDataId=id;
	}

	
	public int getAttendanceDataId() {
		return AttendanceDataId;
	}

}