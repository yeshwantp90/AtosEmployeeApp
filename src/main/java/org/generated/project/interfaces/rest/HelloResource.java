package org.generated.project.interfaces.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.swagger.annotations.Api;

/*@Api("Employee Tracker Application")*/
@Path("hello")
public class HelloResource {

	@GET
	public String hello() {
		return "Hello World";
	}

}