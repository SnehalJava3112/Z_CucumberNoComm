package Steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefination 
{   
	WebDriver driver;
	
	@Given("User is on Login page")
	public void user_is_on_login_page()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Java_Project\\Z_CucumberNoComm\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://admin-demo.nopcommerce.com/admin/");
	}

	@When("User enters username and password")
	public void user_enters_username_and_password() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("admin@yourstore.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='Password']")).clear();
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("admin");
		Thread.sleep(2000);
	}

	@When("User click on Login button")
	public void user_click_on_login_button() 
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("Validate user successfully logged in application")
	public void validate_user_successfully_logged_in_application() throws InterruptedException 
	{
		String expTitle = "Dashboard / nopCommerce administration";
		String actTitle = driver.getTitle();
		
		System.out.println(expTitle);
		System.out.println(actTitle);
		
		Assert.assertEquals(expTitle, actTitle, "Both Titles are different ");
		Thread.sleep(2000);
		driver.quit();
	}
}
