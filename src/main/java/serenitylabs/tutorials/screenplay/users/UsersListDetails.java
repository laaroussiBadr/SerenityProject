package serenitylabs.tutorials.screenplay.users;

import net.serenitybdd.screenplay.targets.Target;

public class UsersListDetails {
	
	public static final Target Users_List_Portlet = Target.the("Users List Portlet")
            .locatedBy("//*[@id=\"_userlistportlet_WAR_cngadministrationportlet_UserListPortlet\"]");
	
	public static final Target Skill_List_Link = Target.the("Skill List Link")
            .locatedBy("//*[@id='page_skilllist']/a[contains(text(),'Liste des compétences')]");

}
