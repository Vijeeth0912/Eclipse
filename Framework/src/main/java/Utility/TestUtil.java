package Utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestUtil {

	
	public static String getResponseString(Response response)
	{
		String res = response.getBody().asString();
		return res;
	}
	
	public static JsonPath getJsonResponse(String response)
	{
		JsonPath jp = new JsonPath(response);
		return jp;
		
	}
	
	public static int getStatusCode(Response response)
	{
		int status = response.getStatusCode();
		return status;
	}
	
	public static String getStatusMessage(Response response)
	{
		String message = response.getStatusLine();
		return message;
	}
	
	
	
	
}
