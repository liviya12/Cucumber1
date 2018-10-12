package org;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test1 {
	static WebDriver driver;
	@Given("^The user is in guru login page$")
	public void the_user_is_in_guru_login_page() {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("http://demo.guru99.com/v4/");
	    driver.manage().window().maximize();
	}

	@Given("^The user login with valid username & password$")
	public void the_user_login_with_valid_username_password(DataTable Credentials) {
		List<String> list = Credentials.asList(String.class);
		System.out.println(list);
    driver.findElement(By.name("uid")).sendKeys(list.get(0));
    driver.findElement(By.name("password")).sendKeys(list.get(1));
    driver.findElement(By.name("btnLogin")).click();
	
	}
	
@When("^The user navigates to new customer page$")
	public void the_user_navigates_to_new_customer_page() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
 
	}

@When("^The user provides the personal details to login \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
public void the_user_provides_the_personal_details_to_login(String custname, String gender, String dob, String address, String city, String state, String pin, String mobile, String email, String password)
{
        driver.findElement(By.name("name")).sendKeys(custname);
	    driver.findElement(By.name("rad1")).click();
	    driver.findElement(By.name("dob")).sendKeys(dob);
	    driver.findElement(By.name("addr")).sendKeys(address);
	    driver.findElement(By.name("city")).sendKeys(city);
	    driver.findElement(By.name("state")).sendKeys(state);
	    driver.findElement(By.name("pinno")).sendKeys(pin);
	    driver.findElement(By.name("telephoneno")).sendKeys(mobile);
	    driver.findElement(By.name("emailid")).sendKeys(email);
	    driver.findElement(By.name("password")).sendKeys(password);
	    driver.findElement(By.xpath("//input[@name=\"sub\"]")).click();
}

   @Then("^The user should be registered as a new cutomer$")
	public void the_user_should_be_registered_as_a_new_cutomer() {
		Assert.assertEquals("Customer Registered Successfully!!!",driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).getText());
	
	}





}