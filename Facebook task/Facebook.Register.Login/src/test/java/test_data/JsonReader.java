package test_data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;






public class JsonReader {
	
	public String email,password;
	public void JsonFileReader(String JsonFileName) throws IOException, ParseException {
		String filepath =System.getProperty("user.dir")+"/TestData/"+JsonFileName;
		
		File srcFile = new File(filepath);
		JSONParser parser = new JSONParser();
		
			 JSONArray jarray =(JSONArray)parser.parse(new FileReader(srcFile));
		
		for(Object jsonobj:jarray)
		{
			JSONObject account =(JSONObject) jsonobj;
			
			email = (String) account.get("email");
			password = (String) account.get("password");
			
		}
		}
		
	}


