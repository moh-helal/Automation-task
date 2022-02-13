package webpagestest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import webpages.AuthNewUser;
import webpages.CheckoutProcedure;
import webpages.ClothesSelection;

public class CheckoutProceduretest extends TestBase {
	
	AuthNewUser user;
	ClothesSelection cloth;
	CheckoutProcedure checkout;
	
	@DataProvider(name="exceldata")
	public Object[][] logindata() throws IOException
	{
		excelreader1 er = new excelreader1();
		return er.exceldata();	
	}
	
	@Test(enabled=true ,dataProvider="exceldata")
	public void checkouttest(String email,String pass) throws InterruptedException
	{
		user = new AuthNewUser(driver);
		cloth = new ClothesSelection(driver); 
		user.login(email,pass);
		Thread.sleep(2000);
		cloth.ProductSelection();
		Thread.sleep(2000);
		cloth.ProductDescription();
		Thread.sleep(2000);
		cloth.AddToCart();
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods= {"checkouttest"},enabled=true)
	public void SubtractQuantitytest() throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		checkout = new CheckoutProcedure(driver);
		Thread.sleep(2000);
		checkout.SubtractQuantity();
		Thread.sleep(2000);
		checkout.checkoutproceeding();
		
		//Assert.assertTrue(cloth.prodaddedmsg.getText().contains(""));
	}
	
	@Test(dependsOnMethods= {"SubtractQuantitytest"},enabled=true)
	public void orderhistorytest() throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		checkout.orderhistory();
		
	}
}
