package Serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Object_Repository.Pojo;

public class Deserial {

	@Test
	public void get() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper o=new ObjectMapper();
		File f=new File(".\\Serialization.json");
		o.readValue(f, Pojo.class);
	}
}
