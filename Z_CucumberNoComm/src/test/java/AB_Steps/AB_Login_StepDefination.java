package AB_Steps;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AB_Login_StepDefination
{
	WebDriver driver;
	
	@Given("AB User browser launch")
	public void a_user_browser_launch()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Java_Project\\Z_CucumberNoComm\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	@When("AB User enters url {string}")
	public void a_user_enters_url(String str) 
	{
		driver.get(str);
	}

	@When("AB user click on login button")
	public void a_user_click_on_login_button() 
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("AB Validate user successfully logged in application")
	public void validate_user_successfully_logged_in_application() throws InterruptedException 
	{
		System.out.println("Login Successful");
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	@Then("AB validate remember_me checkbox status")
	public void a_validate_remember_me_checkbox_status() throws InterruptedException 
	{
	    boolean actStatus = driver.findElement(By.xpath("//*[@type='checkbox']")).isSelected();
	    Assert.assertEquals(actStatus, false);
	    Thread.sleep(2000);
		driver.quit();
	}
	
	@When("AB User enters login credentials as {string} and {string}")
	public void ab_user_enters_login_credentials_as_and(String str1, String str2) throws InterruptedException 
	{
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		driver.findElement(By.xpath("//input[@id='Password']")).clear();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(str1); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(str2); 
	}
}