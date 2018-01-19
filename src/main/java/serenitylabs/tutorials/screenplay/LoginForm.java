package serenitylabs.tutorials.screenplay;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class LoginForm {
	
	public static final Target USERNAME = Target.the("Username Input Field").located(By.xpath("//*[@id='username']"));
	
	public static final Target PASSWORD = Target.the("Password Input Field").located(By.xpath("//*[@id='password']"));
	
	public static final Target CONNECT_BUTTON = Target.the("Connect Button")
            .locatedBy("//*[@id='connectButton']");
}
