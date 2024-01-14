package pageObjects.herokuApp;

public enum HomePageItem {
    DYNAMIC_CONTROLS("Dynamic Controls"),
    FRAMES("Frames"),
    IFRAME("iFrame"),
    FILE_DOWNLOAD("File Download");

    private final String item;

    HomePageItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
