package enums;

public enum MainPageElements {


    WHATS_NEW("What's New", "ui-id-3"),
    WOMEN("Women", "ui-id-4"),
    REVERT_TEST("revert_test", "u2-id-4"),
    REVERT_TEST2("revert_test", "u2-id-4");

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
