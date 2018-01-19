package serenitylabs.tutorials.screenplay.skills;

import net.serenitybdd.screenplay.targets.Target;

public class SkillListDetails {
	
	public static final Target Skill_List_Portlet = Target.the("Skill List Portlet")
            .locatedBy("//*[@id='skillListPortlet']");
	
	public static final Target Create_New_Skill_Button = Target.the("Create New Skill Button")
            .locatedBy("//*[@id='skillListTable']//a[contains(text(),'Créer une nouvelle compétence')]");

}
