package facebook;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;


public class Login
{
    private WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty(Constants.CHROME_DRIVER, Constants.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }


    @Given("^I am on Facebook login page$")
    public void goToFacebok()
    {
        driver.get(Constants.FACEBOOK_URL);
    }

    @When("^I enter username as \"([^\"]*)\"$")
    public void i_enter_username_as(String username)
    {
        sleep(5000);
        WebElement email = driver.findElement(By.id(Constants.ELEMENT_ID_EMAIL));
        email.sendKeys(username);

    }

    @When("^I enter password as \"([^\"]*)\"$")
    public void i_enter_password_as(String password)
    {
        WebElement pass = driver.findElement(By.id(Constants.ELEMENT_ID_PASSWORD));
        WebElement submitButton = driver.findElement(By.id(Constants.ELEMENT_ID_SUBMIT_BUTTON));

        pass.sendKeys(password);
        submitButton.click();
    }


    @Then("^Login should succeed$")
    public void login_should_succeed()
    {
        sleep(10000);
        driver.getCurrentUrl();
        WebElement name = driver.findElement(By.className("_1vp5"));
        String txtName = name.getText();
        assertEquals(Constants.PROFILE_NAME, txtName);
    }

    @Then("^Login should fail$")
    public void login_should_fail()
    {
        sleep(10000);
        driver.getCurrentUrl();
        String message = driver.findElement(By.xpath(Constants.ELEMENT_XPATH_ERROR_MESSAGE)).getText();
        assertEquals(Constants.ERROR_MESSAGE, message);
    }

    private void sleep(long milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
