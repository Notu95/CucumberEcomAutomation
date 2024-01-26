package Amazon.AmazonWebUITestProject.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	public  List<HashMap<String, String>> getJsonDataToHashMap() throws IOException{
		
		//Reading JSON to String
		String JSONContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+
				"\\src\\test\\java\\Amazon\\AmazonWebUITestProject\\data\\LoginToOrder.json"), StandardCharsets.UTF_8);
		//String To HashMap Jackson Databind --> add the dependency
		ObjectMapper mapper=new ObjectMapper();
		// List<HashMap<String, String>> data = mapper.readValue(JSONContent, new TypeReference<List<HashMap<String, String>>>() {});
		List<HashMap<String,String>> data=mapper.readValue(JSONContent,new TypeReference<List<HashMap<String,String>>>(){} );
		return data;
		
		
	}

}
