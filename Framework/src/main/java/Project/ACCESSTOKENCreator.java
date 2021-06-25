package Project;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import Utility.PayloadConverter;
import Utility.URL;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ACCESSTOKENCreator {
		
	static Response response;
	
	@Test
	public static String Login() throws IOException
	{
		String endpoint = URL.getEndPoint("/user/login");
		String loginpayload = PayloadConverter.generatePayloadString("Login.json");
		
		response = RestCalls.postRequest(endpoint, loginpayload);
		
		String res = response.getBody().asString();
		
		JsonPath jp = new JsonPath(res);
		
		String ACCESSTOKEN = jp.getString("accessToken");
		
		return ACCESSTOKEN;
	}
	
	
}
