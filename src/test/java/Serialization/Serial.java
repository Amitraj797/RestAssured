package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Object_Repository.Pojo;





public class Serial {

	
	@Test
	public void get() throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper o=new ObjectMapper();
		Pojo p=new Pojo("name","desc");
		File f=new File(".\\Serialization.json");
		o.writeValue(f,p);
	}
}
