package com.example.tanks.Model;


import com.example.tanks.Controller.MapController;
import com.example.tanks.Controller.StepControllers.BulletController;
import com.example.tanks.Model.Enums.BulletImage;
import com.example.tanks.Model.Enums.Direction;
import com.example.tanks.Model.Enums.Team;
import com.example.tanks.Panes.BulletPane;

public class BulletControllerConstructor {

    public static BulletController createBulletController(
            Direction direction, double x, double y, Team team, double damage, double speed,
            MapController mapController
            ){
        BulletPane bulletPane = new BulletPane(direction, BulletImage.RED);
        bulletPane.setTranslateX(x);
        bulletPane.setTranslateY(y);

        mapController.addNode(bulletPane);

        Bullet bullet = new Bullet(bulletPane,direction,damage,team,speed);


        return new BulletController(
                bullet,mapController
        );
    }
}
