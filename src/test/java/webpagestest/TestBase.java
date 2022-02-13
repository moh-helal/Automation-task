package webpagestest;

import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

//import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {

	public static WebDriver driver;

	@BeforeSuite
	@Parameters("browser")
	public void startdriver(@Optional String browsertype) 
	{
		/*String url= System.getProperty("user.dir")+"\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",url);*/
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		//WebDriverManager.firefoxdriver().setup();
		//driver = new FirefoxDriver();
		if(browsertype.equalsIgnoreCase("chrome"))
		{
			String url= System.getProperty("user.dir")+"\\driver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",url);
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}	
		else if(browsertype.equalsIgnoreCase("firefox"))
		{
			String url= System.getProperty("user.dir")+"\\driver\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",url);
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		Dimension res=new Dimension(1024,768);
		driver.manage().window().setSize(res);
		System.out.println("The browser resolution= "+ driver.manage().window().getSize());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
	}
	@AfterSuite
	public void stopdriver() 
	{
		try {
			Thread.sleep(4000);
			driver.close();
		} catch (InterruptedException e) {
			
			System.out.println(" ");
		}
		
		
	}


}
