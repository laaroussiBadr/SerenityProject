package serenitylabs.tutorials.screenplay.navigate;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class Navigate implements Task {
	
    private final Section section;

    public Navigate(Section section) {
        this.section = section;
    }
	
	@Step("{0} navigates to #section")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(section.url())        
        );
    }

    public static Performable to(Section section) {
        return instrumented(Navigate.class, section);
    }
	
}
