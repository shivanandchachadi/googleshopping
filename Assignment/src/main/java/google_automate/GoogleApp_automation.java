package google_automate;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import datewritefile.exceldatawrite;
import keywordread.xpath_read;

public class GoogleApp_automation {

	static int count=0;
	private static WebDriver driver;
	
	public void main_class() throws Exception
	{


		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");

		driver=new ChromeDriver();

		driver.get(xpath_read.pathread("url"));

		driver.manage().window().maximize();

		driver.findElement(By.xpath(xpath_read.pathread("sign_buttton"))).click();

		driver.findElement(By.xpath(xpath_read.pathread("username"))).sendKeys(xpath_read.pathread("myusername"));

		driver.findElement(By.xpath(xpath_read.pathread("next_button"))).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath(xpath_read.pathread("password"))).sendKeys(xpath_read.pathread("mypassword"));

		driver.findElement(By.xpath(xpath_read.pathread("next_button2"))).click();

		Thread.sleep(5000);



	}

	
	public void search_item() throws Exception
	{
		//click on search bar and type mobile
		driver.findElement(By.xpath(xpath_read.pathread("searchbar"))).sendKeys("Mobiles");
		driver.findElement(By.xpath("//*[@id=\"sh-dh__sf\"]/div/input[1]")).click();
		//Click on new item
		driver.findElement(By.xpath(xpath_read.pathread("tick_newitem"))).click();
		//click on 3rd option
		driver.findElement(By.xpath(xpath_read.pathread("thrid_option_price"))).click();

		Thread.sleep(3000);

		//select nokia phone
		driver.findElement(By.xpath(xpath_read.pathread("tick_nokia"))).click();
		Thread.sleep(3000);

		//select samsung phone
		driver.findElement(By.xpath("//span[contains(text(),'Samsung')]")).click();

		Thread.sleep(3000);
		//Scroll down to view

		((JavascriptExecutor)driver).executeScript("scroll(0,800)");

		Thread.sleep(2000);

		((JavascriptExecutor)driver).executeScript("scroll(800,1200)");

		Thread.sleep(2000);

		((JavascriptExecutor)driver).executeScript("scroll(1200,2000)");


		Thread.sleep(4000);

		//Click on Seller Croma
		driver.findElement(By.xpath(xpath_read.pathread("select_chrome"))).click();

		((JavascriptExecutor)driver).executeScript("scroll(0,1200)");

		Thread.sleep(4000);

		//Click on MORE

		driver.findElement(By.xpath(xpath_read.pathread("click_more"))).click();

		Thread.sleep(2000);


		//Click on Seller Tata CLiQ
		driver.findElement(By.xpath(xpath_read.pathread("click_tata"))).click();

		Thread.sleep(2000);
		// select order by low to high price
		
		driver.findElement(By.xpath("//span[@class='Yf5aUd']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'PRICE – LOW TO HIGH')]")).click();

		List<WebElement> total= driver.findElements(By.xpath(xpath_read.pathread("elements")));
		count=total.size();

		//display total number of mobiles displayed.
		System.out.println("Total number of mobiles displayed are "+ total.size());


		//make header bold
		//exwrite.font();
		//headers

	}
	
	public void writedataintoexcel() throws Exception
	{
		String mobname,selname,prices;

		// create object of exceldatawite class		
		exceldatawrite exwrite=new exceldatawrite("sheet1");
		exwrite.writedata("Mobilename", "SellerName", "Price");

		for (int i=1;i<=count;i++)
		{
			// get mobile names
			mobname=driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div["+i+"]/div/div[2]/div/div[1]/a")).getText();
			System.out.println("mobile name i s"+mobname);


			//	Get seller names (only name)
			selname=driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div["+i+"]/div/div[2]/div/div[2]/div/div")).getText().substring(15);
			System.out.println("seller name is"+ selname);


			//Get mobile price	
			prices=driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div["+i+"]/div/div[2]/div/div[2]/div/div/span")).getText();
			System.out.println(" price is "+prices);


			// Write data into excel sheet
			exwrite.writedata(mobname, selname, prices);
		}

		//output file
		exwrite.flush();

	}

	public void close()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	



}
