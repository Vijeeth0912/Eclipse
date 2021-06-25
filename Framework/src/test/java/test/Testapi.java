package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Project.ACCESSTOKENCreator;
import Project.ValAssertionStatusCode;
import Project.RestCalls;
import Utility.TestUtil;
import Utility.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Testapi {

	public String accessToken;
	public String DeleteID;
	Response response;
	
	@BeforeTest
	public void setup() throws IOException
	{
		accessToken=ACCESSTOKENCreator.Login();
	}
	
	@Test(priority=0)
	public void testcase1()
	{
		String formedURL = URL.getEndPoint("/user");
		response = RestCalls.getRequestWithHeader(formedURL, accessToken);
		
		String res = TestUtil.getResponseString(response);
		
		JsonPath jsonres = TestUtil.getJsonResponse(res);
		
		DeleteID = jsonres.getString("users[2]._id");
		System.out.println(DeleteID);	
		
		ValAssertionStatusCode.verifyStatusCode(response, 200);
	}
	
	@Test(dependsOnMethods="testcase1")
	public void testcase2()
	{
		String formedURL = URL.getEndPoint("/user/"+DeleteID);
		response = RestCalls.deleteRequestWithHeader(formedURL, accessToken);
		
		String res = TestUtil.getResponseString(response);
		
		System.out.println(res);
		
		//JsonPath jsonres = TestUtil.getJsonResponse(res);
		
		//DeleteID = jsonres.getString("users[2]._id");
		//System.out.println(DeleteID);	
		
		ValAssertionStatusCode.verifyStatusCode(response, 200);
	}
	

	
}
