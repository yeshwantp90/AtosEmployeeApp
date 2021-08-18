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

@Bind
public class LeaveDataRepository extends BaseJpaRepository<LeaveData,LeaveDataId>{


	@Inject
	EntityManager entityManager;
	
	  public String  saveEmployeeLeave(LeaveData leaveObj) {
	         EntityManager entityManager = getEntityManager();
	      	
	         try {
	       		 			 		
	 		  entityManager.persist(leaveObj);		
	 		  return "Success";
	         }catch(Exception ex) {
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
					query.setParameter("employeeId", "100");
					obj = query.getResultList();
				} catch (Exception ex) {
					

				}
			
			return obj;
						
	     }
	  
	 
	
   
	     
}
