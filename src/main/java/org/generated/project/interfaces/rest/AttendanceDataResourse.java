package org.generated.project.interfaces.rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.generated.project.domain.model.AttendanceData;
import org.generated.project.domain.model.AttendanceDataId;
import org.generated.project.domain.services.AttendanceDataService;


import com.google.inject.servlet.RequestParameters;

import java.util.stream.Collectors;

@Path("psa")
public class AttendanceDataResourse {

	
	  @Inject 
	  private AttendanceDataService attendanceDataService;
	  
	  
	  @POST	  
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  @Path("applyAttendance") 
	  public HashMap applyLeave(@RequestParameters AttendanceData	  attendanceDataObject) {
	  
	  String str = attendanceDataService.applyAttendance(attendanceDataObject);
	  
	  HashMap<String, String> response = new HashMap<String, String>();
		
		if(str.equalsIgnoreCase("success")) {
			
			response.put("statusMsg", "Attendance Marked Successfully");
			response.put("statusCode", "201");
			
		}else {
			response.put("statusMsg", "Technical Error");
			response.put("statusCode", "500");	
			
			
			
		}
		
		return response;
	  
	  
	  }
}

