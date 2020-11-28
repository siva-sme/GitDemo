package stepDefinations;

import org.junit.runner.RunWith;

import Newproject.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.HomePage;
import pageObjects.LoginPage;

@RunWith(Cucumber.class)
public class stepDefination extends  Base{

	@Given("^Initialize the browser$")
    public void initialize_the_browser() throws Throwable {
		driver = browserinit();
    }

    @When("^user enter (.+) and (.+)$")
    public void user_enter_something_and_something(String mail, String password) throws Throwable {
    	LoginPage lp = new LoginPage(driver);

		lp.email().sendKeys(mail);

		lp.password().sendKeys(password);

		lp.login().click();
    }

    @Then("^Error message is displayed$")
    public void error_message_is_displayed() throws Throwable {
    	
    	LoginPage lp = new LoginPage(driver);

		
        System.out.println(lp.error().getText());
    }

    @And("^Navigate to \"([^\"]*)\"$")
    public void navigate_to_something(String url) throws Throwable {
    	driver.get(url);
    }

    @And("^Click on Login button$")
    public void click_on_login_button() throws Throwable {
    	HomePage hp = new HomePage(driver);
    	
    	if((hp.popupSize().size())>0) {
    		
    		hp.popup().click();
    	}

		hp.login().click();
    }
    
    @And("^close browsers$")
    public void close_browsers() throws Throwable {
       driver.quit();
    }

}
