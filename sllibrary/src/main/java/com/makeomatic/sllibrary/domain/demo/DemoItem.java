package com.makeomatic.sllibrary.domain.demo;

/**
 * Created by OLEG on 10.11.2018.
 */

public class DemoItem {
    private String title;
    private String image;
    private String points;

    public DemoItem(String title, String image, String points) {
        this.title = title;
        this.image = image;
        this.points = points;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
