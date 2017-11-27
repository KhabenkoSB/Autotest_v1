import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.*;


public class Steps {
    @Given("^I have login$")
    public void iHaveLogin() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("1");
    }

    @When("^I am logining to (\\d+)bet$")
    public void iAmLoginingToBet(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("2");
    }

    @Then("^I can see balase$")
    public void iCanSeeBalase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("3");
    }

    @Then("^I can see error$")
    public void iCanSeeError() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("4");
}
}
