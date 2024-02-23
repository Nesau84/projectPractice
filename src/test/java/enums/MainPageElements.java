package enums;

public enum MainPageElements {

    WHATS_NEW("What's New", "ui-id-3"),
    WOMEN("Women", "ui-id-4"),
    MEN("Men", "ui-id-5"),
    GEAR("Gear", "ui-id-6");

    private final String name;
    private final String pageElement;

    MainPageElements(String name, String pageElement) {

        this.name = name;
        this.pageElement = pageElement;
    }

    public String getName() {

        return this.name;
    }

    public String getPageElement() {

        return this.pageElement;
    }
}
