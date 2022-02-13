package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class createnewaccount extends PageBase {

	public createnewaccount(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="email_create")
	WebElement createemail;
	
	@FindBy(id="SubmitCreate")
	WebElement submitbtn;
	
	@FindBy(css="//*[@id=\"passwd\"]")
	WebElement password;
	
	@FindBy(id="id_gender1")
	WebElement gender1 ;
	
	@FindBy(id="id_gender2")
	WebElement gender2 ;
	
	@FindBy(id="days")
	WebElement birthdaydrop;
	
	@FindBy(id="months")
	WebElement birthmonthdrop;
		
	@FindBy(id="years")
	WebElement birthyeardrop;
	
	@FindBy(id="firstname")
	WebElement fn;
	
	@FindBy(id="lastname")
	WebElement ln;
	
	@FindBy(id="address1")
	WebElement address;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement id_state;
	
	@FindBy(id="postcode")
	WebElement postcode;
	
	@FindBy(id="id_country")
	WebElement id_country;
	
	@FindBy(id="phone_mobile")
	WebElement phone_mobile;
	
	@FindBy(id="alias")
	WebElement alias;
	
	@FindBy(xpath="//*[@id=\"customer_firstname\"]")
	WebElement fname;
	
	@FindBy(xpath="//*[@id=\"customer_lastname\"]")
	WebElement lname;
	
	@FindBy(id="passwd")
	WebElement pass;
	
	@FindBy(xpath="//*[@id=\"submitAccount\"]/span")
	WebElement registerbtn;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/p") 
	WebElement registeringmsg;
	
	public void createacctxtbox() throws InterruptedException
	{
		sendtxtbox(createemail,"helal@gmail.com");
		Thread.sleep(2000);
		clickbtn(submitbtn);
	}
	
	public void dropdownrreg()
	{
		selectdrop(birthdaydrop,"26");
		selectdrop(birthmonthdrop,"4");
		selectdrop(birthyeardrop,"2004");
		selectdrop(id_state,"21");
		selectdrop(id_country,"21");
	}
	
	public void enterreg2(String firstname,String lastname, String add,String cityreg , String mobile, String aliasadd) throws InterruptedException
	{
		Thread.sleep(2000);
		sendtxtbox(fn,firstname);
		Thread.sleep(2000);
		sendtxtbox(ln,lastname);
		Thread.sleep(2000);
		sendtxtbox(address,add);
		Thread.sleep(2000);
		sendtxtbox(city,cityreg);
		sendtxtbox(postcode,"12345");
		Thread.sleep(2000);
		sendtxtbox(phone_mobile,mobile);
		sendtxtbox(alias,aliasadd);
	}
	
	public void radiobtn() throws InterruptedException
	{
		clickbtn(gender2);
		Thread.sleep(2000);
		clickbtn(gender1);
		Thread.sleep(2000);
	}
	
	public void firstlastname()
	{
		try {
			Thread.sleep(1500);
			sendtxtbox(fname,"ahmed");
			Thread.sleep(1500);
			sendtxtbox(lname,"ali");
			Thread.sleep(1500);
			sendtxtbox(pass,"123456");
		} catch (InterruptedException e) {
			System.out.println("Something wrong with the inspection");
		}	
	}
	
	public void registering()
	{
		try {
			Thread.sleep(1500);
			clickbtn(registerbtn);
			Thread.sleep(1500);
			System.out.println(registeringmsg.getText());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Something wrong after clicking on register btn");
		}
	}
	
	
}
