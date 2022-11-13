package com.example.tanks.Model.Enums;

public enum BulletImage {
    BLACK("bullet_8_16.png"),
    RED("bullet_red.png"),
    ;
    public String path;

    BulletImage(String url) {
        this.path = url;
    }
}
