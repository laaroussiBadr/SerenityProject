package serenitylabs.tutorials.screenplay;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class SwitchToPortalIFrame implements Task {

	static final Target IFRAME = Target.the("Portal Iframe").located(By.xpath("//*[@id='portalIframe']"));
	
    public static SwitchToPortalIFrame switchToIframe() {
        return instrumented(SwitchToPortalIFrame.class);
    }
	
    private SwitchIFrame switched(Actor actor) {
        return SwitchIFrame.as(actor);
    }
	
	@Step("{0} Switch to Portal IFrame")
	public <T extends Actor> void performAs(T actor) {
		WebDriver driver = BrowseTheWeb.as(actor).getDriver();
    	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='portalIframe']")));
	}
	
	

}
