package ru.iFellow.pojoClasses;

public class Location {
    private String name;
    private String url;

    public Location() {
        super();
    }

    public Location(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
