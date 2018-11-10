package com.makeomatic.sllibrary.domain.menu;

import java.io.Serializable;

/**
 * Created by OLEG on 10.11.2018.
 */

public class Menu implements Serializable {
    private String title;
    private String image;
    private String action;

    public Menu(String title, String image, String action) {
        this.title = title;
        this.image = image;
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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
}
