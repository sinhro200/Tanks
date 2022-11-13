package com.example.tanks.Panes;

import com.example.tanks.Model.Enums.Direction;
import com.example.tanks.Model.Enums.TankImage;
import com.example.tanks.Settings;
import com.example.tanks.Utils.ImageViewLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TankPane extends Pane {

    private double tankWidth;
    private double tankHeight;


    public TankPane(String url,double posX,double posY,double tankWidth,double tankHeight) {

        this.tankHeight = tankHeight;
        this.tankWidth = tankWidth;

        ImageView tankImageView = ImageViewLoader.loadImageViewByURL(
                url,tankWidth,tankHeight);

        this.getChildren().add(tankImageView);

        this.setWidth(tankWidth);
        this.setHeight(tankHeight);
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }

    public TankPane(TankImage tankImage, double posX, double posY, double tankWidth, double tankHeight) {
        this(tankImage.path,posX,posY,tankWidth,tankHeight);
    }

    public TankPane(TankImage tankImage, double posX, double posY) {
        this(tankImage.path,posX,posY, Settings.DEF_TANK_WIDTH,Settings.DEF_TANK_HEIGHT);
    }

    public void setDirection(Direction direction){
        switch (direction){
            case Up:
                this.setRotate(0);
                break;
            case Right:
                this.setRotate(90);
                break;
            case Down:
                this.setRotate(180);
                break;
            case Left:
                this.setRotate(270);
                break;
        }
    }

    public double getTankWidth() {
        return tankWidth;
    }

    public double getTankHeight() {
        return tankHeight;
    }

    public double getPosX() {
        return this.getTranslateX();
    }

    public double getPosY() {
        return this.getTranslateY();
    }
}
