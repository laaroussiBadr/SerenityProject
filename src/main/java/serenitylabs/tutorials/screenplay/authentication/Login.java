package serenitylabs.tutorials.screenplay.authentication;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.screenplay.LoginForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class Login implements Task {
	
    public static Login withCredentials() {
        return instrumented(Login.class);
    }
	
    private Authenticate authenticated(Actor actor) {
        return Authenticate.as(actor);
    }
    
	@Step("{0} Enters Username and Password")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
                Enter.theValue(authenticated(actor).username()).into(LoginForm.USERNAME),
                Enter.theValue(authenticated(actor).password()).into(LoginForm.PASSWORD)
        );		
	}
	
	

}
