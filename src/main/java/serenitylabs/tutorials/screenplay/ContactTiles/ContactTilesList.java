package serenitylabs.tutorials.screenplay.ContactTiles;

import java.util.List;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ContactTilesList implements Question<List<String>>{
	
	public static Question<List<String>> displayed() {
        return new ContactTilesList();
    }
	
	@Override
	public List<String> answeredBy(Actor actor) {
		return Text.of(ContactTilesDetails.TILES).viewedBy(actor).asList();
	}
	
	

}
