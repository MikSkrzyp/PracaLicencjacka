package driver.browser;

public enum BrowserTypes {

    FIREFOX("firefox"),
    CHROME("chrome"),
    EDGE("edge"),
    SAFARI("safari"),
    OPERA("opera");

    private final String browser;

    BrowserTypes(String browser) {
        this.browser = browser;
    }
}