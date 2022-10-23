package A_Steps;
import java.time.Duration;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class A_Login_StepDefination 
{   
	WebDriver driver;
	
	@Given("A User browser launch")
	public void a_user_browser_launch()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Java_Project\\Z_CucumberNoComm\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	@When("A User enters url {string}")
	public void a_user_enters_url(String str) 
	{
		driver.get(str);
	}
	
	@When("A User enters login credentials as below")
	public void a_user_enters_login_credentials_as_below(DataTable data) throws InterruptedException
	{
		//List<String> d = data.asList();			// for single row
		List<List<String>> d = data.asLists();		// inner list = row, outer list = columns
		
		// for second row -> wrong credentials
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		driver.findElement(By.xpath("//input[@id='Password']")).clear();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(d.get(2).get(1)); // "snehal@gmail.com"
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(d.get(2).get(2)); //"xyz@123"
		
		// for first row -> right credentials
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		driver.findElement(By.xpath("//input[@id='Password']")).clear();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(d.get(1).get(1)); // "admin@yourstore.com"
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(d.get(1).get(2)); // "admin"
	}

	@When("A user click on login button")
	public void a_user_click_on_login_button() 
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("A Validate user successfully logged in application")
	public void validate_user_successfully_logged_in_application() throws InterruptedException 
	{
		String expTitle = "Dashboard / nopCommerce administration";
		String actTitle = driver.getTitle();
		
		Assert.assertEquals(expTitle, actTitle);
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Then("A validate remember_me checkbox status")
	public void a_validate_remember_me_checkbox_status() 
	{
	    boolean actStatus = driver.findElement(By.xpath("//*[@type='checkbox']")).isSelected();
	    Assert.assertEquals(actStatus, false);
	}
}