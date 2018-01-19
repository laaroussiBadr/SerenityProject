package serenitylabs.tutorials.trains.features.steps;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;
import static serenitylabs.tutorials.screenplay.navigate.Section.contactUrl;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.OpenUrl;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.waits.WaitUntil;
import serenitylabs.tutorials.screenplay.LoginForm;
import serenitylabs.tutorials.screenplay.SwitchToPortalIFrame;
import serenitylabs.tutorials.screenplay.navigate.Navigate;
import serenitylabs.tutorials.screenplay.navigate.Section;
import serenitylabs.tutorials.screenplay.skills.SkillListDetails;
import serenitylabs.tutorials.screenplay.skills.SkillListPortletPresence;
import serenitylabs.tutorials.screenplay.users.UsersListDetails;
import serenitylabs.tutorials.screenplay.users.UsersListPortletPresence;



public class createNewSkillStepDefinitions {
	
    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }
    
    @Given("^that (.*) is on the users list page$")
    public void user_on_the_users_kist(String personaName){
    	theActorCalled(personaName)
    	.should(seeThat(UsersListPortletPresence.displayed(), equalTo(Boolean.TRUE)));
    }
	
    @When("^he clicks on the Skills List Link$")
    public void clicks_on_the_Skills_List_Link(){
    	theActorInTheSpotlight()
    	.attemptsTo(
    		WaitUntil.the(UsersListDetails.Skill_List_Link, isVisible()),
    		Click.on(UsersListDetails.Skill_List_Link)
    	);
    }

    @Then("^The skill list is displayed$")
    public void the_skill_list_is_displayed(){
    	theActorInTheSpotlight()
		.attemptsTo(SwitchToPortalIFrame.switchToIframe());
    }
    
    @When("^(.*) clicks on the create new skill button$")
    public void badr_clicks_on_the_create_new_skill_button(String personaName){
    	
    	theActorInTheSpotlight()
    	.attemptsTo(
    		WaitUntil.the(SkillListDetails.Create_New_Skill_Button, isVisible()),
    		Click.on(SkillListDetails.Create_New_Skill_Button)
    	);
    	
    }

    @Then("^the skill create form is displayed$")
    public void the_skill_create_form_is_displayed(){
    	
    }
    
    
    @Given("^that (.*) opens another window$")
    public void opens_another_window(String personaName) {
    	theActorCalled(personaName)
    	.attemptsTo(
    			Navigate.to(contactUrl)
    	);
    }
}
