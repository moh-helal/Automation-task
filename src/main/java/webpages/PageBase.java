package webpages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class PageBase {
	
	
	public static  WebDriver driver;
	public static Select dropdown;
	public static  Actions actions;
	public static JavascriptExecutor scrolldown;
	//public static TakesScreenshot screenshot ;
	//public static File source;
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		scrolldown = (JavascriptExecutor) driver;
		//screenshot = (TakesScreenshot) driver;
	} 
	
	protected static void clickbtn(WebElement btn)
	{
		btn.click();
	}
	
	protected static void cleartxtbox(WebElement clear)
	{
		clear.clear();
	}
	
	protected static void cleartxtbox(WebElement clear1,WebElement clear2)
	{
		clear1.clear();
		clear2.clear();
	}
	
	
	protected static void sendtxtbox(WebElement enter , String value)
	{
		enter.clear();
		enter.sendKeys(value);
	}
	
	protected static void selectdrop(WebElement selecttype, String value)
	{
		dropdown = new Select(selecttype);
		dropdown.selectByValue(value);
	}
	
	protected static void hoveroption(WebElement hoverelement)
	{		
		actions.moveToElement(hoverelement).perform();
	}
	
	protected static void scrolloption(String scrollvalue)
	{
		scrolldown.executeScript(scrollvalue, "");
	}
	
	/*protected static void takescreenshot() throws IOException
	{
		screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File("C:\\Users\\mhela\\eclipse-workspace\\project\\screenshot"+".png"));
	}*/
	
	
}