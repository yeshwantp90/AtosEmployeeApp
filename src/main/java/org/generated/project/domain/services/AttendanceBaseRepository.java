package org.generated.project.domain.services;


import org.generated.project.domain.model.AttendanceData;
import org.generated.project.domain.model.AttendanceDataId;
import org.seedstack.business.domain.Repository;


public interface AttendanceBaseRepository extends Repository<AttendanceData, AttendanceDataId> {
	         
	     
	     String  saveEmployeeAttendance(AttendanceData emp);
	     
	     String  getAttendanceData(Long id);
	     
	     
	     
	   
	     
	}
	

