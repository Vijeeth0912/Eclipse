package Project;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification; //Interface

public class RestCalls {

	
	public static Response getRequest(String URI)
	{
		RequestSpecification rs = RestAssured.given();
		rs.contentType(ContentType.JSON);
		Response response = rs.get(URI);
		return response;
	}
	
	public static Response getRequestWithHeader(String URI, String accessToken)
	{
		RequestSpecification rs = RestAssured.given();
		rs.contentType(ContentType.JSON);
		rs.header("Authorization", "Bearer "+accessToken);
		Response response = rs.get(URI);
		return response;
	}
	
	public static Response postRequest(String URI, String strJson)
	{
		RequestSpecification rs = RestAssured.given().body(strJson);
		rs.contentType(ContentType.JSON);
		Response response = rs.post(URI);
		return response;
	}
	
	public static Response putRequest(String URI, String strJson)
	{
		RequestSpecification rs = RestAssured.given().body(strJson);
		rs.contentType(ContentType.JSON);
		Response response = rs.put(URI);
		return response;
	}
	
	public static Response deleteRequest(String URI, String strJson)
	{
		RequestSpecification rs = RestAssured.given().body(strJson);
		rs.contentType(ContentType.JSON);
		Response response = rs.delete(URI);
		return response;
	}
	
	public static Response deleteRequestWithHeader(String URI, String accessToken)
	{
		RequestSpecification rs = RestAssured.given();
		rs.contentType(ContentType.JSON);
		rs.header("Authorization", "Bearer "+accessToken);
		Response response = rs.delete(URI);
		return response;
	}
	
}
