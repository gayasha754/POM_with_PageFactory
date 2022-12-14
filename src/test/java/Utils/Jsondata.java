package Utils;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Jsondata {
	
	InputStream data;
	JSONObject testData;
	
	//Method of enabling using of a json file to get test data
	public JSONObject json(String dataFileName) throws Exception {
		 
		try { 

			data = getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokener = new JSONTokener(data);
			testData = new JSONObject(tokener);			
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			if(data != null) {
				data.close();
			}
		}
		return testData;
	}	
}
