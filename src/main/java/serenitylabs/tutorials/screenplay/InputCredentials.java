package serenitylabs.tutorials.screenplay;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;

public class InputCredentials implements Task {
	
	private String username;
	private String password;
	
	public InputCredentials(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Step("{0} Enters Username : #username and Password : #password")
	public <T extends Actor> void performAs(T actor) {
        
		actor.attemptsTo(
                Enter.theValue(username).into(LoginForm.USERNAME),
                Enter.theValue(password).into(LoginForm.PASSWORD)
        );
	}

}
