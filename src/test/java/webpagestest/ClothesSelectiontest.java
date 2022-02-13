package webpagestest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import webpages.AuthNewUser;
import webpages.ClothesSelection;


public class ClothesSelectiontest extends TestBase {
	
	ClothesSelection cloth;
	AuthNewUser user;
	
	@DataProvider(name="exceldata")
	public Object[][] logindata() throws IOException
	{
		excelreader1 er = new excelreader1();
		return er.exceldata();	
	}
	
	@Test(priority=1, enabled=true,dataProvider="exceldata")
	public void ProductSelectiontest(String email,String pass) throws InterruptedException
	{
		user = new AuthNewUser(driver);
		cloth = new ClothesSelection(driver);
		user.login(email,pass);
		Thread.sleep(1000);
		cloth.ProductSelection();
	}
	@Test(priority=2, enabled=true)
	public void ProductDescriptiontest() throws InterruptedException
	{
		user = new AuthNewUser(driver);
		cloth = new ClothesSelection(driver);
		cloth.ProductDescription();
	}
	
	@Test(dependsOnMethods= {"ProductDescriptiontest"} , enabled=true)
	public void addtocarttest() throws InterruptedException
	{
		user = new AuthNewUser(driver);
		cloth = new ClothesSelection(driver);
		cloth.AddToCart();
		Thread.sleep(3000);
		
	}
	@Test(priority=3 , enabled=true)
	public void emptyentrytest() throws InterruptedException
	{
		cloth.emptyentry();
		Assert.assertTrue(cloth.prodaddedmsg.isDisplayed());
		Assert.assertTrue(cloth.prodaddedmsg.getText().contains("Product successfully added to your shopping cart"));
	}
	
	@Test(priority=4 ,enabled=true)
	public void invalidentrytest() throws InterruptedException
	{
		cloth.invalidentry();
	}

}
