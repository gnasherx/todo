package com.example.ganesh.mytodo;

import java.io.Serializable;

public class Todo implements Serializable {
    private String title;
    private String subTitle;

    public Todo() {
    }

    public Todo(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
