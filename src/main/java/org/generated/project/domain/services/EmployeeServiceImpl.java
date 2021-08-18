package org.generated.project.domain.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.generated.project.application.LoginData;
import org.generated.project.domain.model.Employee;
import org.generated.project.domain.model.EmployeeId;
import org.seedstack.business.domain.Repository;
import org.seedstack.jpa.Jpa;
import org.seedstack.jpa.JpaUnit;
import org.seedstack.seed.Bind;
import org.seedstack.seed.transaction.Transactional;


@Bind
public class EmployeeServiceImpl implements EmployeeService {

	@Inject
	private PersonJPARepository personRepository;
	
	@Inject
	@Jpa
	private Repository<Employee,EmployeeId> emprepo;
	
	@Transactional
	@JpaUnit("myUnit")
	public String employeeService(Employee emp) {
		
		String status="";
		try {
			
			Optional<Employee> login = getservice(emp.getId());
			if(!login.isPresent()) {
				emprepo.add(emp);
				status= "success";
			}
			else {
				status="alreadyExists";
			}
			
			
		}
		catch(Exception e){
			
			e.getMessage();
			status="fail";
			
		}
		return status;
	}
	
	
    @Inject
    @Jpa
    private Repository<Employee, EmployeeId> loginRepository;
    
//    @Inject
//    private LoginRepository repo;
//    @Transactional
//    @JpaUnit("myUnit")
//    public String loginService(LoginId loginId, String password) {
//    	String resolve = "";
//    	try
//    	{
//        Optional<Login> login = loginRepository.get(getSpecificationBuilder().of(Login.class)
//                .property("username").matching(loginId).ignoringCase()
//                .or()
//                .property("password").matching(password).ignoringCase()
//                .build());
//        if(login.isPresent())
//        resolve = "Sucess";
//        else
//        	resolve = "Fail";
//    	}
//        
//    	catch(Exception e)
//    	{
//    		e.printStackTrace();
//    		resolve = "Fail";
//    	}
//    	return resolve;
//    }
    public boolean loginService(LoginData data) {
    	boolean resolve =false;
       	
        //Optional<Employee> login = getservice(new EmployeeId());
    	ArrayList<Employee> list = verifyEmployeeDetails(data);
    	if(list !=null && list.size() >0)
    	{
    		resolve =true;
    	}
    	
    	
    	return resolve;
   
    }
    
    @Transactional
    @JpaUnit("myUnit")
	@Override
	public Optional<Employee> getservice(EmployeeId id) {
		Optional<Employee> obj = loginRepository.get(id);
		return obj;
	}
    
    
    @Transactional
	@JpaUnit("myUnit")
	public ArrayList<Employee> verifyEmployeeDetails(LoginData empObj) {

    	ArrayList<Employee> login = personRepository.getEmployee(empObj);

		return login;
	}
    
    
    
}


