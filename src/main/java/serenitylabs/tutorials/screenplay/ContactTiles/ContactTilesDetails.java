package serenitylabs.tutorials.screenplay.ContactTiles;

import net.serenitybdd.screenplay.targets.Target;

public class ContactTilesDetails {
	
	public static final Target TILES = Target.the("Contact Tiles")
            .locatedBy("//*[@class='mask tile'][@style!='display:none;']");
	
	public static final Target ADMIN_TILE = Target.the("Administration Tile")
            .locatedBy("//div[@id='portalContent']/div[@id='administrator_tile']//a[contains(text(),'istration')]");
}
