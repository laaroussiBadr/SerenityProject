package serenitylabs.tutorials.screenplay.skills;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.waits.WaitUntil;
import serenitylabs.tutorials.screenplay.users.UsersListPortletPresence;

public class SkillListPortletPresence implements Question<Boolean>{
	
	public static Question<Boolean> displayed() {
        return new UsersListPortletPresence();
    }
	
	@Override
	public Boolean answeredBy(Actor actor) {
		return Presence.of(SkillListDetails.Create_New_Skill_Button).viewedBy(actor).asBoolean();
	}

}
