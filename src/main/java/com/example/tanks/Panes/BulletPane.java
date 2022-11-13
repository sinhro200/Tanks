package com.example.tanks.Panes;

import com.example.tanks.Model.Enums.BulletImage;
import com.example.tanks.Model.Enums.Direction;
import com.example.tanks.Settings;
import com.example.tanks.Utils.ImageViewLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class BulletPane extends Pane {

    public BulletPane(Direction direction, BulletImage bulletImage) {
        ImageView imageView = ImageViewLoader.loadImageViewByURL(bulletImage.path,8,16);
        rotateImage(imageView,direction);
        this.getChildren().add(imageView);

        this.setWidth(Settings.DEF_BULLET_WIDTH);
        this.setHeight(Settings.DEF_BULLET_HEIGHT);
    }

    private void rotateImage(ImageView imageView,Direction direction){
        switch (direction) {
            case Down -> imageView.setRotate(0);
            case Up -> imageView.setRotate(180);
            case Right -> imageView.setRotate(90);
            case Left -> imageView.setRotate(270);
        }
    }
}
