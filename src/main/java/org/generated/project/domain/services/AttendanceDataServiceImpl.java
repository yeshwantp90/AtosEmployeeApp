package org.generated.project.domain.services;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.generated.project.domain.model.AttendanceData;
import org.generated.project.domain.model.AttendanceDataId;
import org.seedstack.business.domain.BaseRepository;
import org.seedstack.business.domain.Repository;
import org.seedstack.jpa.BaseJpaRepository;
import org.seedstack.jpa.Jpa;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.Bind;
import org.seedstack.seed.Logging;
import org.seedstack.seed.transaction.Transactional;
import org.slf4j.Logger;


@Bind
public class AttendanceDataServiceImpl implements AttendanceDataService {

	@Inject
	Repository<AttendanceData, AttendanceDataId> attendanceDataRepo;
	
	@Inject	
	AttendanceDataRepository attendanceDataRepository;
	
	@Logging
	private Logger logger;
	

	@Transactional
	@JpaUnit("myUnit")
	public String applyLeave(AttendanceData attendanceDataObject) {
		
		logger.info("LeaveDataServiceImpl :: applyLeave()  param { "+attendanceDataObject.getJustification(),", "+attendanceDataObject.getDate());	
		String str = attendanceDataRepository.saveEmployeeAttendance(attendanceDataObject);

		logger.info("LeaveDataServiceImpl :: applyLeave()  After saving data : return object  "+str);		 
        return str;
	}


	@Override
	public String applyAttendance(AttendanceData attendanceDataObject) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
