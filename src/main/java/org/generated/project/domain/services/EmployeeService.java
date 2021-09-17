package org.generated.project.domain.services;

import java.util.Optional;

import org.generated.project.application.LoginData;
import org.generated.project.domain.model.Employee;
import org.generated.project.domain.model.EmployeeId;
import org.seedstack.business.Service;
@Service
public interface EmployeeService {
	
	public boolean loginService(LoginData data);
	
	public Optional<Employee> getservice(EmployeeId id);
	
	public String employeeService(Employee emp);
	
	

}
