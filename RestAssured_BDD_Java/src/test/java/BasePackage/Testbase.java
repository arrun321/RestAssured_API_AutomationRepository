package BasePackage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import utilities.Utils;
import static io.restassured.RestAssured.given;

import java.util.List;



public class Testbase extends Utils{

	//URLs Used
	
	//GET 
	//GET the user details of a user with particular id
	//https://jsonplaceholder.typicode.com/todos/1

	//POST
	//POST the details of a user with details
	//https://jsonplaceholder.typicode.com/posts

	//GET  
	//GET the comments of social media post for particular user
	//https://jsonplaceholder.typicode.com/comments/5

	//PUT  
	//UPDATE the comments of social media post for particular user
	//https://jsonplaceholder.typicode.com/posts/1
	
	//PATCH  
	//PATCH the comments of social media post for particular user
	//https://jsonplaceholder.typicode.com/posts/1

	//DELETE  
	//Delete a particular post with userId 
	//https://jsonplaceholder.typicode.com/posts/5
	
	Response response ;
	
	public static void setupBaseUrl() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	}

	public Response getRequestWithQueryParam(String userId) {
		response = given()
				.contentType(ContentType.JSON)
				//.param("postId", userId)
				.when()
				.get(path+"/"+userId)
				.then()
				.extract().response();

		return response;

	}
	public Response postRequestWithRequestBody(String requestBody) {
		response = given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody)
				.when()
				.post("/posts")
				.then()
				.extract().response();

		return response;
	}
	public Response putRequest(String id,String requestBody) {
		response = given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody)
				.when()
				.put("/posts/"+id)
				.then()
				.extract().response();
		
		return response;

	}

	public Response patchRequest(String id,String requestBody) {
		response = given()
				.header("Content-type", "application/json")
				.and()
				.body(requestBody)
				.when()
				.patch("/posts/"+id)
				.then()
				.extract().response();

		return response;

	}


	public void deleteRequest(String id) {
		response = given()
				.header("Content-type", "application/json")
				.when()
				.delete("/posts/"+id)
				.then()
				.extract().response();
		
	}

	public void validateResponseStatusCode( int stausCode) {

		Assert.assertEquals(stausCode, response.statusCode());

	}

	@SuppressWarnings("deprecation")
	public void validateuserDetailsResponse(DataTable arg1) throws Throwable {

		List < List < String >> data = arg1.cells();

		String title = getJsonPath(response).get("title");
		String userId = getJsonPath(response).get("userId").toString();
		String id = getJsonPath(response).get("id").toString();
		String completed = getJsonPath(response).get("completed").toString();


		Assert.assertEquals("Correct UserId is seen in the response", data.get(1).get(0), userId);
		Assert.assertEquals("Correct ID is received in the Response", data.get(1).get(1), id );
		Assert.assertEquals("Correct title is received in the Response", data.get(1).get(2), title);
		Assert.assertEquals("Correct Completed status is received in the Response", data.get(1).get(3), completed );
	}


	@SuppressWarnings("deprecation")
	public void validateCommentsResponseDetails(DataTable arg1) {

		List < List < String >> data = arg1.cells();

		String name = getJsonPath(response).get("name").toString();
		String emailId = getJsonPath(response).get("email").toString();
		String body = getJsonPath(response).get("body").toString();


		// Validate the response
		Assert.assertEquals("Correct name is seen in the response", data.get(1).get(0), name);
		Assert.assertEquals("Correct emailId is received in the Response", data.get(1).get(1), emailId );
		Assert.assertEquals("Correct body is received in the Response", data.get(1).get(2), body );

	}


	@SuppressWarnings("deprecation")
	public void validatepPostResponseDetails( DataTable arg1) {

		List < List < String >> data = arg1.cells();

		String id = getJsonPath(response).get("id").toString();
		String userId = getJsonPath(response).get("userId").toString();
		String title = getJsonPath(response).get("title").toString();
		String body = getJsonPath(response).get("body").toString();


		// Validate the response
		Assert.assertEquals("Correct UserId is seen in the response", data.get(1).get(0), userId);

		Assert.assertEquals("Correct ID is received in the Response", data.get(1).get(1), id );
		Assert.assertEquals("Correct title is received in the Response", data.get(1).get(2), title);
		Assert.assertEquals("Correct body is received in the Response", data.get(1).get(3), body );

	}
}