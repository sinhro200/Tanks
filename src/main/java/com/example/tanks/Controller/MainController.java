package com.example.tanks.Controller;

import com.example.tanks.Animation.MyAnimation;
import com.example.tanks.Animation.MyAnimationByAnimationTimer;
import com.example.tanks.Controller.StepControllers.StepControllerContainer;
import com.example.tanks.Controller.StepControllers.TankControllers.PlayerTankController;
import com.example.tanks.Controller.StepControllers.TankControllers.TankController;
import com.example.tanks.Controller.StepControllers.TankControllers.Utils.AITankControllerFactory;
import com.example.tanks.Controller.StepControllers.TankControllers.Utils.TankControllerContainer;
import com.example.tanks.Controller.StepControllers.TankControllers.Utils.TankControllerType;
import com.example.tanks.Model.Enums.TankImage;
import com.example.tanks.Model.Enums.Team;
import com.example.tanks.Model.GameMap;
import com.example.tanks.Model.Tank;
import com.example.tanks.Panes.TankPane;
import com.example.tanks.Settings;
import javafx.scene.input.KeyCode;

import java.util.*;

public class MainController {
    MyAnimation myAnimation;
    MapController mapController;
//    List<TankController> tanksControllers;

    public MainController(MapController mapController,  Set<KeyCode> pressedKeys) {
        this.mapController = mapController;
//        tanksControllers = new LinkedList<>();


        Tank playerTank = createPlayer(mapController.getGameMap());
        mapController.addNode(playerTank.getTankPane());

        TankController playerTankController = new PlayerTankController(
                mapController,pressedKeys,playerTank //tanksControllers
        );
        TankControllerContainer.getInstance().add(playerTankController);
        StepControllerContainer.getInstance().add(playerTankController);


        TankPane tankPane = new TankPane(
                TankImage.FIRST,
                mapController.getGameMap().spawnPoints[0][0]* Settings.BLOCK_WIDTH,
                mapController.getGameMap().spawnPoints[0][1] * Settings.BLOCK_HEIGHT
                );
        mapController.addNode(tankPane);
        Tank towerTank = new Tank(tankPane, Team.c1);

        TankController towerTankController = AITankControllerFactory.getTankController(
                TankControllerType.RandomMove,mapController,towerTank
        );
        TankControllerContainer.getInstance().add(towerTankController);
        StepControllerContainer.getInstance().add(towerTankController);



        TankPane tankPane2 = new TankPane(
                TankImage.FIRST,
                mapController.getGameMap().spawnPoints[2][0]*Settings.BLOCK_WIDTH,
                mapController.getGameMap().spawnPoints[2][1] * Settings.BLOCK_HEIGHT
        );
        mapController.addNode(tankPane2);
        Tank towerTank2 = new Tank(tankPane2,Team.c1);

        TankController towerTankController2 = AITankControllerFactory.getTankController(
                TankControllerType.RandomMove,mapController,towerTank2
        );
        TankControllerContainer.getInstance().add(towerTankController2);
        StepControllerContainer.getInstance().add(towerTankController2);



        TankPane tankPane3 = new TankPane(
                TankImage.FIRST,
                mapController.getGameMap().spawnPoints[1][0]*Settings.BLOCK_WIDTH,
                mapController.getGameMap().spawnPoints[1][1] * Settings.BLOCK_HEIGHT
        );
        mapController.addNode(tankPane3);
        Tank towerTank3 = new Tank(tankPane3,Team.c1);

        TankController towerTankController3 = AITankControllerFactory.getTankController(
                TankControllerType.RandomMove,mapController,towerTank3
        );
        TankControllerContainer.getInstance().add(towerTankController3);
        StepControllerContainer.getInstance().add(towerTankController3);

        myAnimation = new MyAnimationByAnimationTimer(StepControllerContainer.getInstance());
                        //new MyAnimationByTimerSchedule(StepControllerContainer.getTankFireThread());

    }

    private Tank createPlayer(GameMap gameMap){
        int x = 2;
        int y = 1;
        try {
            x = gameMap.playerSpawnPoint[0];
            y = gameMap.playerSpawnPoint[1];
        }catch (Exception ignored){}
        TankPane playerTankPane = new TankPane(
                TankImage.FIRST, x*Settings.BLOCK_WIDTH,y*Settings.BLOCK_HEIGHT
        );

        return new Tank(playerTankPane, Team.player);
    }

    public void beginAnimation(){
        myAnimation.startAnimation();
    }


}
