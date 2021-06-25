package Project;

import org.testng.Assert;

import Utility.TestUtil;
import io.restassured.response.Response;

public class ValAssertionStatusCode {

	
	public static void verifyStatusCode(Response response, int status)
	{
		Assert.assertEquals(TestUtil.getStatusCode(response), status);
	}
}
