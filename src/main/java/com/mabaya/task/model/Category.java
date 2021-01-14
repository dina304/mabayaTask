package com.mabaya.task.model;

import lombok.Getter;
import lombok.Setter;


public enum Category {
    SMARTPHONE("smartphone", 1),
    SHOES("shoes", 2),
    TSHIRTS("t-shirts", 3),
    DEFAULT("default", 0);
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private int id;


    Category(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public static int getIdByName(String name) {
        for (Category cat : Category.values()) {
            if (cat.name.equals(name)) {
                return cat.id;
            }
        }
        return DEFAULT.id;
    }
}
