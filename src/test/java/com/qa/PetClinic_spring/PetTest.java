package com.qa.PetClinic_spring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;
import cucumber.api.PendingException;
import io.restassured.http.ContentType;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

public class PetTest {
	
	private Response response; 
	private ValidatableResponse json; 
	private RequestLogSpecification request;
	
	Constants constant = new Constants(); 
	WebDriver driver; 
	
	
@Before
public void setup() {
	RestAssured.baseURI = constant.BaseURI;	
	System.setProperty("webdriver.chrome.driver", constant.CHROMEPATH);
	driver = new ChromeDriver();
//	driver.manage().window().maximize();

}


@Given("^a vet$")
public void a_vet() throws Throwable {
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "application/json");
//	driver.get(constant.HOMEPAGE);
}

@When("^I click on some records$")
public void i_click_on_some_records() throws Throwable {
	
	Response response1 = given().contentType(ContentType.JSON).when().get(constant.BaseURI + "/api/owners/*/lastname/Escobito");
//	response = request.body().when().get(constant.BaseURI); 
//   System.out.println(response1.toString()); 
   System.out.println(response1.statusCode() + "get url");
   System.out.println(response1.asString());
//   json = response1.then().statusCode(200);
   
}

@Then("^I can see the care available for animals$")
public void i_can_see_the_care_available_for_animals() throws Throwable {
	Response response1 = given().contentType(ContentType.JSON).when().get(constant.BaseURI);
//	json = response1.then().statusCode(200);
}

@Given("^an admin$")
public void an_admin() throws Throwable {
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "application/json");	
//	driver.get(constant.HOMEPAGE);
}

@When("^I update a record$")
public void i_update_a_record() throws Throwable {		
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
	Response response = request.put("/");	
	System.out.println(response.getStatusCode() + " STATUS" );
	System.out.println(response.asString());
	
}

@Then("^the correct details are now shown$")
public void the_correct_details_are_now_shown() throws Throwable {
	RestAssured.baseURI = constant.BaseURI + "/api/owners/8";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "application/json");
	
	json = response.then().statusCode(200);
	System.out.println(response.getStatusCode());
 
	
}

@When("^I delete a animal$")
public void i_delete_a_animal() throws Throwable {
	Response response = given().contentType(ContentType.JSON).when().delete(constant.BaseURI + "/api/pettypes/1");
	System.out.println(response.getStatusCode());
	System.out.println(response.asString());
	
}

@Then("^emails arent sent to deceased annimals$")
public void emails_arent_sent_to_deceased_annimals() throws Throwable {
	json = response.then().statusCode(200);
}

@When("^I add new records$")
public void i_add_new_records() throws Throwable {
	RestAssured.baseURI = constant.BaseURI + "/api/pettypes/";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "application/json");
	request.header("petTypeId", "111");
	JSONObject animal = new JSONObject(); 
	animal.put("id", 9);
	animal.put("name", "lion");		
	System.out.println(request.body(animal.toString()));
	Response response = given().contentType(ContentType.JSON).when().put("/1");
	System.out.println(response.getStatusCode() + " this is our status code");
	System.out.println(response.asString() + " this is our response");
		
}

@Then("^the records are correct$")
public void the_records_are_correct() throws Throwable {
	json = response.then().body("name", equalTo("lion"));
}

@When("^I add new owners to the records$")
public void i_add_new_owners_to_the_records() throws Throwable {
	
	driver.get(constant.HOMEPAGE);	
	OwnersPage onwpage = PageFactory.initElements(driver, OwnersPage.class);	
	onwpage.click(driver, "randy");
	onwpage.addOwner("john", "doe", "544jfdk", "dublin", "02313216556");	
}

@Then("^the details show the change$")
public void the_details_show_the_change() throws Throwable {
	OwnersPage onwpage = PageFactory.initElements(driver, OwnersPage.class);	
	onwpage.select(driver, "john doe");
}
@After
public void tearDown() {
	driver.close();
	driver.quit();
	

}
	

}
