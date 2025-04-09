package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.*;

public class LoginSteps {

    WebDriver driver;

    @Given("the browser is open")
    public void open_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Optional
    }

    @Given("user is on the login page")
    public void user_on_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("user enters username {string} and password {string}")
    public void enter_credentials(String username, String password) throws InterruptedException {
        Thread.sleep(2000); // Wait for page to load (optional)

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(5000); // Wait for login and page redirect
    }

    @Then("user should be navigated to the home page")
    public void validate_home_page() {
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        assertTrue("User is not on the dashboard page", driver.getCurrentUrl().contains("dashboard"));
        driver.quit();
    }
}
