package Utility;

public class URL {

	public static final String url = "https://ecommerceservice.herokuapp.com";
	
	public static String getEndPoint()
	{
		return url;
	}
	
	public static String getEndPoint(String resource)
	{
		return url+resource;
	}
	
	
}
