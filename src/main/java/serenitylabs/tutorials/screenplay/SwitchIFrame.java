package serenitylabs.tutorials.screenplay;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

public class SwitchIFrame implements Ability{
	
	private WebDriver browser;
	
    public static SwitchIFrame as(Actor actor) {
        
        return actor.abilityTo(SwitchIFrame.class);
    }

	public SwitchIFrame(WebDriver browser) {
		this.browser = browser;

	}
	
}
