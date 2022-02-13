package webpages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutProcedure extends PageBase {

	public CheckoutProcedure(WebDriver driver) {
		super(driver);
	}
	
	/*@FindBy(xpath="//*[@id=\"2_7_0_610863\"]/i") 
	WebElement deletebtn;*/  //*[@id="cart_quantity_down_2_9_0_637055"]/span/i
	
	@FindBy(css="i.icon-minus") 
	WebElement subbtn;
	
	@FindBy(xpath="//*[@id=\"cart_title\"]/span")
	WebElement summarymsg;
	
	@FindBy(id="cart_title")
	WebElement pageheader1;
	
	@FindBy(id="total_price")
	WebElement totalprice;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]/span")   //*[@id="center_column"]/p[2]/a[1]/span
	WebElement proceedbtn1;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/form/p/button/span")  //*[@id="center_column"]/form/p/button/span  
	WebElement proceedbtn2;
	
	/*@FindBy(xpath="//*[@id=\"form\"]/p/button/span") //*[@id="form"]/p/button/span
	WebElement procbtn;*/
	
	@FindBy(xpath="//*[@id=\"uniform-cgv\"]/span") //*[@id="uniform-cgv"]/span
	WebElement checkbox;
	
	@FindBy(xpath="//*[@id=\"form\"]/p/button/span")  
	WebElement proceedbtn3;
	
	
	
	@FindBy(xpath="//*[@id=\"center_column\"]/h1")
	WebElement pageheader2;
	
	@FindBy(xpath="//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
	WebElement paymentbtn;
	
	@FindBy(xpath="//*[@id=\"cart_navigation\"]/button/span")  
	WebElement confpaybtn;
	
	@FindBy(linkText="Back to orders")
	WebElement backtoorderbtn;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/h1")
	WebElement pageheader3;
	
	@FindBy(xpath="//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/a")
	WebElement order;
	
	@FindBy(xpath="//*[@id=\"order-list\"]/tbody/tr[1]/td[6]/a")
	WebElement pdfbtn;
	
	
	public void SubtractQuantity() throws InterruptedException
	{
		System.out.println(pageheader1.getText());
		Thread.sleep(2000);
		System.out.println(summarymsg.getText() + "the price: " + totalprice.getText());
		Thread.sleep(2000);
		clickbtn(subbtn);
		Thread.sleep(2000);
	    System.out.println("Updated: " + summarymsg.getText() + "the updated price: " + totalprice.getText());
	    Thread.sleep(2000);
	}
	
	public void checkoutproceeding() throws InterruptedException, IOException
	{
		clickbtn(proceedbtn1);
		Thread.sleep(1000);
		clickbtn(proceedbtn2);
		Thread.sleep(2000);
		clickbtn(checkbox);
		Thread.sleep(3000);
		System.out.println("Terms Checkbox selection: "+ checkbox.isSelected());
		clickbtn(proceedbtn3);
		Thread.sleep(1500);
		System.out.println(pageheader2.getText() + "either by bank wire or by check");
		Thread.sleep(1500);
		clickbtn(paymentbtn);
		Thread.sleep(1500);
		clickbtn(confpaybtn);
		Thread.sleep(2000);
		
	}
	
	public void orderhistory() throws InterruptedException, IOException
	{
		clickbtn(backtoorderbtn);
		Thread.sleep(1000);
		System.out.println(pageheader3.getText()+"page");
		Thread.sleep(2000);
		System.out.println("Here's the order "+order.getText());
		Thread.sleep(2000);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File("C:\\Users\\mhela\\eclipse-workspace\\Web_Automation_Demo\\screenshot\\"+".jpg"));
		Thread.sleep(3000);
	}
}
