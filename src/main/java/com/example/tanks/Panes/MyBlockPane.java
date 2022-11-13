package com.example.tanks.Panes;

import com.example.tanks.Settings;
import com.example.tanks.Utils.ImageViewLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MyBlockPane extends Pane {

    private final double blockWidth = Settings.BLOCK_WIDTH;
    private final double blockHeight = Settings.BLOCK_HEIGHT;

    public MyBlockPane(String url) {
        ImageView blockImageView = ImageViewLoader.loadImageViewByURL(url,blockWidth,blockHeight);
        this.getChildren().add(blockImageView);

        this.setWidth(blockWidth);
        this.setHeight(blockHeight);
    }
}
