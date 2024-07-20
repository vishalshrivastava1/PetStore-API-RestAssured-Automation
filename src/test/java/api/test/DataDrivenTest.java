package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTest {

	
	@Test (priority =1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostUser(String UserId, String UserName, String	FirstName, String LastName, String Email, String Password, String Phone)
	{
		
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(UserId));
		userPayload.setUsername(UserName);
		userPayload.setUsername(FirstName);
		userPayload.setUsername(LastName);
		userPayload.setUsername(Email);
		userPayload.setUsername(Password);
		userPayload.setUsername(Phone);
		
		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	
	
	
	@Test (priority =2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testGetUserByName(String userName)
	{
		
	//	System.out.println(userName);
		Response response = UserEndPoints.readUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
//	@Test (priority =3, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String userName)
	{
		
	//	System.out.println(userName);
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}
