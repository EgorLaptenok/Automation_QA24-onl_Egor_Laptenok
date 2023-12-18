package pageObjects.herokuApp;

public enum HomePageItem {
    DYNAMIC_CONTROLS("Dynamic Controls"),
    FRAMES("Frames"),
    IFRAME("iFrame");

    private final String item;

    HomePageItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
