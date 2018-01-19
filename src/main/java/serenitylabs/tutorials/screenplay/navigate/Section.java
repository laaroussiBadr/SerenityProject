package serenitylabs.tutorials.screenplay.navigate;

public enum Section {
	
	contactUrl("https://notThisWebstite.com/");
	
    private final String url;

    Section(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }
}
