package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClothesSelection extends PageBase {

	public ClothesSelection(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	WebElement women;
	
	@FindBy(linkText="Blouses")
	WebElement blouse;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/h1/span[1]")
	WebElement header;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]")
	WebElement product;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	WebElement prodsel;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[2]/span/span")
	WebElement avail;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[2]/div[1]/span")
	WebElement price;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span")
	WebElement morebtn;
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(xpath="//*[@id=\"quantity_wanted_p\"]/a[2]/span/i")  
	WebElement addbtn;
	
	@FindBy(xpath="//*[@id=\"quantity_wanted_p\"]/a[1]/span/i")
	WebElement subbtn;
	
	@FindBy(id="group_1")
	WebElement sizesel;
	
	@FindBy(xpath="//*[@id=\"color_8\"]")
	WebElement whitesel;
	
	@FindBy(xpath="//*[@id=\"color_11\"]")
	WebElement blacksel;
	
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button/span")
	WebElement addtocartbtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	WebElement proceedbtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	public WebElement prodaddedmsg;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[2]")
	WebElement contshopbtn;
	
	@FindBy(xpath="//*[@id=\"product\"]/div[2]/div/div/div/div/p")
	WebElement errormsg;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")
	WebElement contbtn;
	
	public void ProductSelection() throws InterruptedException
	{
		hoveroption(women);
		Thread.sleep(2000);
		clickbtn(blouse);
		Thread.sleep(2000);
		System.out.println("Accessing "+ header.getText()+ "page");
		Thread.sleep(3000);
		scrolloption("580");
		Thread.sleep(2000);
		hoveroption(product);
		Thread.sleep(3000);
		System.out.println("The product "+ avail.getText()+ " & the price: " +price.getText());
		Thread.sleep(2000);
		clickbtn(morebtn);
		Thread.sleep(2000);
	}
	
	public void ProductDescription() throws InterruptedException
	{
		Thread.sleep(2000);
		int i=1;
		Thread.sleep(2000);
		while(i<=4)
		{
			if(i==4)
			{
				break;
			}
			clickbtn(addbtn);
			Thread.sleep(2000);
			i++;	
		}
		while(i>=2)
		{
			if(i==2)
			{
				break;
			}
			clickbtn(subbtn);
			Thread.sleep(2000);
			i--;
		}
		Thread.sleep(1000);
		selectdrop(sizesel,"2");
		clickbtn(whitesel);
		Thread.sleep(1000);
		clickbtn(blacksel);
		Thread.sleep(1000);
	}
	
	public void AddToCart() throws InterruptedException
	{
		clickbtn(addtocartbtn);
		Thread.sleep(1500);
		System.out.println(prodaddedmsg.getText());
		clickbtn(proceedbtn);
	}
	
	public void emptyentry() throws InterruptedException
	{
		Thread.sleep(1000);
		clickbtn(contshopbtn);
		Thread.sleep(1000);
		cleartxtbox(quantity);
		Thread.sleep(1000);
		clickbtn(addtocartbtn);
		Thread.sleep(2000);
		
	}
	//clickbtn(view);
			//Thread.sleep(2000);
			//actions.sendKeys(Keys.ESCAPE);
			//clickbtn(closebtn);
	
	public void invalidentry() throws InterruptedException
	{
		clickbtn(contbtn);
		Thread.sleep(1000);
		sendtxtbox(quantity,"k");
		Thread.sleep(1000);
		clickbtn(addtocartbtn);
		Thread.sleep(2000);
		System.out.println("error msg should be resulted from invalid entry: "+errormsg.getText());
	}

	
}
