package webpagestest;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import webpages.AuthNewUser;

public class AuthNewUserTest extends TestBase{
	
	AuthNewUser user ;
	
	@DataProvider(name="exceldata")
	public Object[][] logindata() throws IOException
	{
		excelreader1 er = new excelreader1();
		return er.exceldata();		
	}
	
	@Test(priority=1,enabled=true,dataProvider="exceldata")
	public void logintest(String email,String pass) throws InterruptedException 
	{	
		user= new AuthNewUser(driver);
		user.login(email,pass);
		user.forgetpass(email);
		Thread.sleep(1500);
    }
	
	@Test(priority=2 ,enabled=true)
	public void emptyentrytest() throws InterruptedException
	{
		Thread.sleep(1500);
		user= new AuthNewUser(driver);
		user.emptyentries();
		Thread.sleep(1500);
	}
	
	@Test(priority=3,enabled=true)
	public void invalidentrytest() throws InterruptedException
	{
		Thread.sleep(1500);
		user= new AuthNewUser(driver);
		user.invalidentries();
	}
}

