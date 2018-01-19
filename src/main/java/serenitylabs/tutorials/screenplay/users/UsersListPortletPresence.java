package serenitylabs.tutorials.screenplay.users;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.*;

public class UsersListPortletPresence implements Question<Boolean>{
	
	public static Question<Boolean> displayed() {
        return new UsersListPortletPresence();
    }
	
	@Override
	public Boolean answeredBy(Actor actor) {
		return Presence.of(UsersListDetails.Users_List_Portlet).viewedBy(actor).asBoolean();
	}

}
