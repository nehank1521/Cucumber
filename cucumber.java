package StepDefinition;

import java.io.File;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cucumber 
{
WebDriver driver;
	@Given("^Browse the stackoverflow url$")
	public void browse_the_stackoverflow_url() throws Throwable
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Neha Kushwaha\\Desktop\\neha\\geckodriver.exe");
	    driver=new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.get("https://stackoverflow.com/users/login");
	}

	@Given("^provide valid credentials$")
	public void provide_valid_credentials() throws Throwable
	{
		driver.findElement(By.name("email")).sendKeys("nkneha1521@gmail.com");
		 driver.findElement(By.id("password")).sendKeys("nkneha1521..");
		 driver.findElement(By.id("submit-button")).click();
	}

	@When("^Login page should open$")
	public void login_page_should_open() throws Throwable 
	{
		System.out.println("Login successfully");  
	}

	@When("^Browse the url$")
	public void browse_the_url() throws Throwable 
	{
		Thread.sleep(4000);
		String url=driver.getCurrentUrl();
		System.out.println(url);
		driver.get(url+"questions/tagged/javascript");   
	}

	@When("^Getting text$")
	public void getting_text() throws Throwable
	{
		String text=driver.findElement(By.xpath(".//*[@class='summarycount al']")).getText();
	System.out.println("Total questions ="+text);
	 
	}

	@When("^taking snapshot$")
	public void taking_snapshot() throws Throwable {
		File screenshotfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile, new File("C:\\Users\\Neha Kushwaha\\Desktop\\neha\\page1..png")); 
	}

	@When("^Click on next$")
	public void click_on_next() throws Throwable
	{
		WebElement page =driver.findElement(By.xpath("//span[@class='page-numbers next']"));
		page.click();
	}

	@When("^Taking snap shots up to (\\d+) pages$")
	public void taking_snap_shots_up_to_pages(int arg1) throws Throwable 
	{
		for (int i =0; i<4; i++)
			{
		WebElement page =driver.findElement(By.xpath("//span[@class='page-numbers next']"));
		page.click();
		Random rand = new Random();
		int Randomnumber = rand.nextInt(5);
		File screenshotfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile, new File("C:\\Users\\Neha Kushwaha\\Desktop\\neha\\" +Randomnumber+".png")); 	
	}

	@Then("^Logout$")
	public void logout() throws Throwable 
	{
	  System.out.println("LOGOUT SUCCESSFULLY");
	}

	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	
	}


	

}
