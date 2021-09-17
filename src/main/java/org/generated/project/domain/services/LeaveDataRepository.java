package org.generated.project.domain.services;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.generated.project.domain.model.Employee;
import org.generated.project.domain.model.EmployeeId;
import org.generated.project.domain.model.LeaveData;
import org.generated.project.domain.model.LeaveDataId;
import org.seedstack.jpa.BaseJpaRepository;
import org.seedstack.seed.Bind;

import com.sun.istack.logging.Logger;

@Bind
public class LeaveDataRepository extends BaseJpaRepository<LeaveData,LeaveDataId>{


	@Inject
	EntityManager entityManager;
	
	private static final Logger logger = Logger.getLogger(LeaveDataRepository.class);  
	
	  public String  saveEmployeeLeave(LeaveData leaveObj) {
		  
		  logger.info("Inside saveEmployeeLeave"+leaveObj);
	         EntityManager entityManager = getEntityManager();
	      	
	         try {
	       		 			 		
	 		  entityManager.persist(leaveObj);		
	 		  return "Success";
	         }catch(Exception ex) {
	        	  
	   		  logger.info("Exception occured in saveEmployeeLeave"+leaveObj);
	        	 return ex.getMessage();
	         }
	 		
			 
	     }
	  
	  public List<Object>  getLeaveData(Long id) {
	         EntityManager entityManager = getEntityManager();
	         
		     List<Object> obj = null;
				try {
					Query query = entityManager.createNamedQuery("getEmployeeLeave");
					Employee em =new Employee();
					EmployeeId emObj =new EmployeeId(id.toString());
					em.setId(emObj);	
					query.setParameter("employeeId", emObj);
					obj = query.getResultList();
				} catch (Exception ex) {
					

				}
			
			return obj;
						
	     }
	  
	 
	
   
	     
}
