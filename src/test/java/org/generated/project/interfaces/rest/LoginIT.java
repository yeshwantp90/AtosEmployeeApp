package org.generated.project.interfaces.rest;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.core.MediaType;
import org.json.*;  

import org.generated.project.application.LoginData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seedstack.seed.Configuration;
import org.seedstack.seed.testing.junit4.SeedITRunner;
import org.seedstack.seed.undertow.LaunchWithUndertow;

import io.restassured.response.Response;

@RunWith(SeedITRunner.class)
@LaunchWithUndertow
public class LoginIT {

	
	@Configuration("runtime.web.baseUrl")
    private String baseUrl;
	
	
	@Test
    public void testLogin() throws Exception {
        
        LoginData login = new LoginData();
        login.setUsername("yeshwant1");
        login.setPassword("pass1");
        
        Response response = given().
                contentType(MediaType.APPLICATION_JSON)
                 .body(login)
                .auth().basic("demo", "demo")
                .expect().statusCode(200)
                .when().post(baseUrl + "/psa/loginService");
        

        JSONObject json = new JSONObject(response.body().asString());  
        
        String statusMsg= (String) json.get("statusCode");
        
        assertThat(statusMsg).isEqualTo("201");
    }
	
	
	
	
}
