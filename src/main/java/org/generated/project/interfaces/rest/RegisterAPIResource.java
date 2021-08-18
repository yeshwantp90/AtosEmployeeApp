package org.generated.project.interfaces.rest;

import java.util.HashMap;

import javax.inject.Inject;
import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.generated.project.domain.model.Employee;
import org.generated.project.domain.services.EmployeeService;

import io.swagger.annotations.Api;

@Api("Registeration")
@Path("psa")
public class RegisterAPIResource {

	@Inject
	private EmployeeService service;


	@Path("registerEmployee")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> register(Employee emp) {
	
		 String result = service.employeeService(emp);
		 
		 HashMap<String, String> response = new HashMap<String, String>();
			
			if(result.equalsIgnoreCase("success")) {
				response.put("statusCode", "201");
				response.put("statusMsg", "Registration Successful");
				
			}else {
				
				response.put("statusCode", "500");
				
				if(result.equalsIgnoreCase("alreadyExists")) {
					response.put("statusMsg", "User Already Exists");
				}else {
					response.put("statusMsg", "Registration Not Successful");
				}
				
			}
			
			return response;

	}

}
