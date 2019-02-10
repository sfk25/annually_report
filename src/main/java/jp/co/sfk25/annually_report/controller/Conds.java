package jp.co.sfk25.annually_report.controller;

import java.io.Serializable;

public class Conds implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
