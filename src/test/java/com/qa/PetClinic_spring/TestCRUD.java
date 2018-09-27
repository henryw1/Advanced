package com.qa.PetClinic_spring;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

public class TestCRUD {
	private Response response; 
	private ValidatableResponse json; 
	private RequestLogSpecification request;
	
	Constants constant = new Constants(); 
	
	
	@Test
	public void getUseres() {
		RestAssured.baseURI = constant.BaseURI + "/api/owners/8";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		json = response.then().statusCode(200);
		System.out.println(response.getStatusCode());

	}
	
	
	public void postoswer() throws JSONException {
		RestAssured.baseURI = constant.BaseURI + "/api/owners/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("ownerId", "8");
		JSONObject requestParams = new JSONObject();	
		JSONObject pet = new JSONObject();
		JSONArray pets = new JSONArray();	
		JSONObject type = new JSONObject();
		
		type.put("id", 15);
		type.put("name", "dog");
		
		pet.put("id", 7);
		pet.put("name", "value");
		pet.put("birthDate", "07/01/1975");
		pet.put("owner", 7);		
		requestParams.put("id", 7);
		requestParams.put("firstName", "sam");
		requestParams.put("lastName", "Smith");
		requestParams.put("city", "media");
		requestParams.put("telephone", "023156156");
		requestParams.put("pets", pets);
		System.out.println(request.given().body(requestParams.toString()));
		Response response = request.post("/");	
		System.out.println(response.getStatusCode() + " STATUS" );
		System.out.println(response.asString());
	}
	
	
	private void putOswner() throws JSONException {
		RestAssured.baseURI = constant.BaseURI + "/api/owners/";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("ownerId", "8");
		JSONObject requestParams = new JSONObject();	
		JSONObject pet = new JSONObject();
		JSONArray pets = new JSONArray();	
		JSONObject type = new JSONObject();
		
		type.put("id", 15);
		type.put("name", "dog");
		
		pet.put("id", 7);
		pet.put("name", "value");
		pet.put("birthDate", "07/01/1975");
		pet.put("owner", 7);		
		requestParams.put("id", 7);
		requestParams.put("firstName", "sam");
		requestParams.put("lastName", "Smith");
		requestParams.put("city", "media");
		requestParams.put("telephone", "023156156");
		requestParams.put("pets", pets);
		System.out.println(request.given().body(requestParams.toString()));
		Response response = request.post("/");	
		System.out.println(response.getStatusCode() + " STATUS" );
		System.out.println(response.asString());

	}
	
	
	
	
}
