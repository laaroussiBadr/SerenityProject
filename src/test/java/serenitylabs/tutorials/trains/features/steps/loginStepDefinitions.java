package serenitylabs.tutorials.trains.features.steps;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import serenitylabs.tutorials.screenplay.LoginForm;
import serenitylabs.tutorials.screenplay.SwitchToPortalIFrame;
import serenitylabs.tutorials.screenplay.ContactTiles.ContactTilesList;
import serenitylabs.tutorials.screenplay.ContactTiles.ContactTilesDetails;
import serenitylabs.tutorials.screenplay.authentication.Authenticate;
import serenitylabs.tutorials.screenplay.authentication.Login;
import serenitylabs.tutorials.screenplay.navigate.Navigate;
import serenitylabs.tutorials.screenplay.users.UsersListPortletPresence;

import static serenitylabs.tutorials.screenplay.navigate.Section.contactUrl;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.GivenWhenThen.*;


public class loginStepDefinitions {
	
    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }
    
    @Given("^that (.*) has Accessed The Contact Authentication Page$")
    public void decided_to_travel_by_train(String personaName) throws Throwable {
        theActorCalled(personaName).attemptsTo(
        		Navigate.to(contactUrl)
        );
    }
    
    @When("^he inputs his username '(.*)' and password '(.*)'$")
    public void he_inputs_his_username_and_password(String username, String password) {
    	
    	theActorInTheSpotlight()
    		.attemptsTo(SwitchToPortalIFrame.switchToIframe());
    	
    	theActorInTheSpotlight()	
    		.can(Authenticate.with(username, password))
    		.attemptsTo(Login.withCredentials());
    }
    
    @When("^he clicks on the connect button$")
    public void he_clicks_on_the_connect_button() {
    	theActorInTheSpotlight().attemptsTo(
    			WaitUntil.the(LoginForm.CONNECT_BUTTON, isVisible()),
    			Click.on(LoginForm.CONNECT_BUTTON)
    	);
    	
    }
    
    @Then("^he authenticated successfuly$")
    public void he_authenticated_successfuly() {
    	theActorInTheSpotlight()
		.attemptsTo(SwitchToPortalIFrame.switchToIframe());
    	
    	theActorInTheSpotlight()
    	.should(seeThat(ContactTilesList.displayed(), hasItem("ADMINISTRATION")));
    }
    
    @Then("^Clicks On The Administration Tile$")
    public void clicks_On_The_Administration_Tile(){
    	theActorInTheSpotlight().attemptsTo(
    			WaitUntil.the(ContactTilesDetails.ADMIN_TILE, isVisible()),
    			Click.on(ContactTilesDetails.ADMIN_TILE)
    	);
    }

    @Then("^The Users List Is Displayed$")
    public void The_Users_List_Is_Dispolayed(){
    	theActorInTheSpotlight()
		.attemptsTo(SwitchToPortalIFrame.switchToIframe());
    	
    	theActorInTheSpotlight()
    	.should(seeThat(UsersListPortletPresence.displayed(), equalTo(Boolean.TRUE)));
    	
    }
}
