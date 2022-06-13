package glueCode;


import static org.hamcrest.Matchers.equalTo;


import java.util.ArrayList;
import static io.restassured.RestAssured.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.Assert.assertEquals;

import utilities.Utils;

import java.util.HashMap;
import java.util.List;

import BasePackage.Testbase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;



public class StepDef extends Testbase {


	private Response response;


	@Given("^To get user details for user with userId \"([^\"]*)\"$")
	public void to_initiate_Rest_service_to_get_user_details(String userId) throws Throwable {

		setupBaseUrl();
		path = "/todos";
		response=getRequestWithQueryParam(userId);
	}



	@Given("^To initiate Rest service to make a post in Socail Media$")
	public void to_initiate_Rest_service_to_post_user_details(DataTable arg1)  throws Throwable {

		setupBaseUrl();
		path = "/posts";

		List < List < String >> data = arg1.cells();

		String requestBody = "{\n" +
				"\""+data.get(0).get(0)+"\""+":"+"\""+data.get(1).get(0)+"\",\n" +
				"\""+data.get(0).get(1)+"\""+":"+"\""+data.get(1).get(1)+"\",\n" +
				"\""+data.get(0).get(2)+"\""+":"+"\""+data.get(1).get(2)+ "\" \n}";

		//		String requestBody = "{\n" +
		//				"  \"title\": \"amatjango\",\n" +
		//				"  \"body\": \"amatComments\",\n" +
		//				"  \"userId\": \"122\" \n}";

		response=postRequestWithRequestBody(requestBody);		
	}

	@Then("^status code response should be \"([^\"]*)\"$")
	public void response_includes_the_following(int statusCode) throws Throwable {

		validateResponseStatusCode(statusCode);
	}

	@Then("^post response should include the following$")
	public void post_response_includes_the_following(DataTable arg1) throws Throwable {

		validatepPostResponseDetails(arg1);
	}

	@Then("^To initiate Rest service to get the comment details of user with userId \"([^\"]*)\"$")
	public void to_initiate_rest_Service_to_get_comment_details_of_user(String userId) throws Throwable {

		setupBaseUrl();
		path = "/comments";

		response=getRequestWithQueryParam(userId);
	}

	@Then("^comments response should include the following$")
	public void comments_response_should_include_the_following(DataTable arg1) throws Throwable {

		validateCommentsResponseDetails(arg1);
	}

	@Then("^user details response should include the following$")
	public void response_includes_the_following(DataTable arg1) throws Throwable {

		validateuserDetailsResponse(arg1);
	}


	@Then("^Rest service to update a comment for a post in social media$")
	public void rest_service_to_update_a_comment_for_a_post_social_media(DataTable arg1) throws Throwable {

		setupBaseUrl();
		path = "/posts";

		List < List < String >> data = arg1.cells();

		String id=data.get(1).get(1);

		String requestBody = "{\n" +
				"\""+data.get(0).get(0)+"\""+":"+"\""+data.get(1).get(0)+"\",\n" +
				"\""+data.get(0).get(1)+"\""+":"+"\""+data.get(1).get(1)+"\",\n" +
				"\""+data.get(0).get(2)+"\""+":"+"\""+data.get(1).get(2)+"\",\n" +
				"\""+data.get(0).get(3)+"\""+":"+"\""+data.get(1).get(3)+ "\" \n}";

		response=putRequest(id,requestBody);	

	}

	@Then("^Rest service to update a title for a post in social media using patch request$")
	public void to_update_commet_for_a_post_using_patch_request(DataTable arg1) throws Throwable {

		setupBaseUrl();
		path = "/posts";

		List < List < String >> data = arg1.cells();
		String id=data.get(1).get(2);

		String requestBody = "{\n" +
				"\""+data.get(0).get(0)+"\""+":"+"\""+data.get(1).get(0)+"\",\n" +
				"\""+data.get(0).get(1)+"\""+":"+"\""+data.get(1).get(1)+ "\" \n}";

		response=patchRequest(id,requestBody);	

	}


	@Given("^Rest service to delete a user with id \"([^\"]*)\"$")
	public void rest_Service_delete_user_with_id(String id) throws Throwable {

		deleteRequest(id);
	}
}