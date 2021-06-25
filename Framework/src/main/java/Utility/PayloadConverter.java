package Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayloadConverter {

	public static String generatePayloadString(String filename) throws IOException
	{
		String filepath = "C:\\Users\\SreeVijeethJayanVala\\EclipseRestAssured\\Framework\\Resources\\"+filename;
		//System.getProperty("uder.dir")+"\\resource\\"+filename;
		return new String(Files.readAllBytes(Paths.get(filepath)));
		
	}
	
}