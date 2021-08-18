package org.generated.project.interfaces.rest;

import java.util.HashMap;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.generated.project.application.LoginData;
import org.generated.project.domain.services.EmployeeService;

import io.swagger.annotations.Api;

@Api("Employee Tracker Application")
@Path("psa")
public class LoginAPIResource {
	@Inject
	private EmployeeService login;


	@Path("loginService")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> loginService(LoginData data) {
		
		boolean action = login.loginService(data);
		
		HashMap<String, String> response = new HashMap<String, String>();
		
		if(action) {
			response.put("statusCode", "200");
			response.put("statusMsg", "Login Successful");
			
		}else {
			response.put("statusCode", "500");
			response.put("statusMsg", "Login Not Successful");
		}
		
		return response;
	}

}