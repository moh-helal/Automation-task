package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.testng.Assert.assertTrue;


public class AuthNewUser extends PageBase{

	public AuthNewUser(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="email")
	WebElement emailaddress;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement loginbtn;
	
	@FindBy(css="h1.page-heading")
	WebElement header;
	
	@FindBy(linkText="Forgot your password?")
	WebElement forget_pass;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
	WebElement signout;
	
	@FindBy(xpath="//*[@id=\"form_forgotpassword\"]/fieldset/p/button")
	WebElement resetpass;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/a")
	WebElement back;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div/p")
	WebElement conf;
	
	@FindBy(xpath="//*[@id=\"create_account_error\"]/ol/li")
	WebElement accerror;
	
	@FindBy(id="email_create")
	WebElement createemail;
	
	@FindBy(id="SubmitCreate")
	WebElement submitbtn;
	
	@FindBy(xpath="//*[@id=\"create_account_error\"]/ol/li")
	WebElement emptyalertcreateacc;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div[1]/ol/li")
	WebElement emptyalertlogin;
	
	public void login(String email,String pass) throws InterruptedException
	{
		assertTrue(header.getText().contains("AUTHENTICATION"));
		sendtxtbox(emailaddress,email);
		Thread.sleep(1000);
		sendtxtbox(password,pass);
		Thread.sleep(1000);
		clickbtn(loginbtn);	
	}
	public void forgetpass(String email) throws InterruptedException
	{
		clickbtn(signout);
		Thread.sleep(1000);
		clickbtn(forget_pass);
		Thread.sleep(1000);
		sendtxtbox(emailaddress,email);
		Thread.sleep(1000);
		clickbtn(resetpass);
		Thread.sleep(1000);
		System.out.println(conf.getText());
		clickbtn(back);
		Thread.sleep(1000);
		sendtxtbox(createemail,email);
		clickbtn(submitbtn);
		System.out.println(accerror.getText());
	}
	
	public void emptyentries() throws InterruptedException
	{
		cleartxtbox(createemail);
		clickbtn(submitbtn);
		System.out.println(emptyalertcreateacc.getText());
		Thread.sleep(1000);
		cleartxtbox(emailaddress);
		clickbtn(loginbtn);	
		System.out.println(emptyalertlogin.getText());
	}
	
	public void invalidentries() throws InterruptedException {
		
		cleartxtbox(emailaddress,password);
		Thread.sleep(1000);
		sendtxtbox(emailaddress,"gg@ss");
		Thread.sleep(1000);
		sendtxtbox(password,"789456");
		clickbtn(loginbtn);
		System.out.println(emptyalertlogin.getText());
		Thread.sleep(4000);
		cleartxtbox(emailaddress,password);
		Thread.sleep(1000);
		sendtxtbox(emailaddress,"gg@ss.com");
		Thread.sleep(1000);
		sendtxtbox(password,"789");
		clickbtn(loginbtn);
		System.out.println(emptyalertlogin.getText());
		Thread.sleep(4000);
		cleartxtbox(emailaddress,password);
		Thread.sleep(1000);
		cleartxtbox(createemail);
		sendtxtbox(createemail,"gg@ss");
		clickbtn(submitbtn);
		System.out.println(accerror.getText());
		
	}
	

}
