package com.example.tanks.Model.Enums;

public enum TankImage {
FIRST("tank_1_66_66.png"),
    ZIGH("ZIGH.png")
    ;
    public String path;

    TankImage(String url) {
        this.path = url;
    }
}
