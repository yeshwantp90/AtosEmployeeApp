package org.generated.project.domain.services;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.generated.project.domain.model.AttendanceData;
import org.generated.project.domain.model.AttendanceDataId;
import org.generated.project.domain.model.Employee;
import org.generated.project.domain.model.EmployeeId;
import org.seedstack.jpa.BaseJpaRepository;
import org.seedstack.seed.Bind;

import com.sun.istack.logging.Logger;

@Bind
public class AttendanceDataRepository extends BaseJpaRepository<AttendanceData,AttendanceDataId>{


	@Inject
	EntityManager entityManager;
	
	private static final Logger logger = Logger.getLogger(AttendanceDataRepository.class);  
	
	  public String  saveEmployeeAttendance(AttendanceData attendanceObj) {
		  
		  logger.info("Inside saveEmployeeAttendance"+attendanceObj);
	         EntityManager entityManager = getEntityManager();
	      	
	         try {
	       		 			 		
	 		  entityManager.persist(attendanceObj);		
	 		  return "Success";
	         }catch(Exception ex) {
	        	  
	   		  logger.info("Exception occured in saveEmployeeLeave"+attendanceObj);
	        	 return ex.getMessage();
	         }
	 		
			 
	     }
	  
	  public List<Object>  getAttendanceData(Long id) {
	         EntityManager entityManager = getEntityManager();
	         
		     List<Object> obj = null;
				try {
					Query query = entityManager.createNamedQuery("getEmployeeAttendance");
					Employee em =new Employee();
					EmployeeId emObj =new EmployeeId(id.toString());
					em.setId(emObj);	
					query.setParameter("employeeId", em);
					obj = query.getResultList();
				} catch (Exception ex) {
					

				}
			
			return obj;
						
	     }
	  
	 
	
   
	     
}
