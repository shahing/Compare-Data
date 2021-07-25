package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class getData {
	
	String baseURL = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=fbf6728827097c754ced72be2f9c517a";
	@Test
	
	public void getStatusCode() {
		//RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=fbf6728827097c754ced72be2f9c517a");
		Response resp = RestAssured.get(baseURL);
		
		
		int code = resp.getStatusCode();
		Assert.assertEquals(code, 200);
	


}
	@Test
	public void getString() {
		Response resp = RestAssured.get(baseURL);
		
		Integer S = (int) resp.getTime();
		//Assert.assertEquals(S, "892");
		
	}
}