package com.anuj.crud_interface;

public class Table {
    private int id;
    private String title,desc;

    public Table(int id, String title, String desc) {
        this.id = id;
        this.title = title;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
