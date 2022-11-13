package com.example.tanks.Controller.StepControllers.TankControllers;

import com.example.tanks.Controller.MapController;
import com.example.tanks.Controller.StepControllers.MyStepController;
import com.example.tanks.Model.Enums.Direction;
import com.example.tanks.Model.Tank;
import com.example.tanks.Settings;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class PlayerTankController extends TankController implements MyStepController {

    private Set<KeyCode> pressedKeys ;//for player

    public PlayerTankController(
            MapController mapController, Set<KeyCode> pressedKeys,
            Tank tank
            ) {
        super(mapController,tank);
        this.pressedKeys = pressedKeys;
        this.tank = getTank();
    }


    @Override
    public void nextStep() {
        checkPressedKeys();
    }

    private void checkPressedKeys(){
        if (pressedKeys.size() > 0) {
            if (pressedKeys.contains(KeyCode.UP)) {
                tank.rotate(Direction.Up);
                moveTankInItsDir();
            }
            else if (pressedKeys.contains(KeyCode.DOWN)) {
                tank.rotate(Direction.Down);
                moveTankInItsDir();
            }
            else if (pressedKeys.contains(KeyCode.RIGHT)) {
                tank.rotate(Direction.Right);
                moveTankInItsDir();
            }
            else if (pressedKeys.contains(KeyCode.LEFT)) {
                tank.rotate(Direction.Left);
                moveTankInItsDir();
            }
            if (pressedKeys.contains(KeyCode.SPACE)){
                tryToFire();
            }

            checkView();
        }
    }

    private double rightMoveBorder = 0.6;//(double)3/4;
    private double leftMoveBorder = 0.4;//(double)1/4;

    private double bottomMoveBorder = 0.6;//(double)3/4;
    private double topMoveBorder = 0.4;//(double)1/4;

    private void checkView(){
        double width = mapController.getGameMap().countBlocksWidth* Settings.BLOCK_WIDTH;
        double height = mapController.getGameMap().countBlocksHeight*Settings.BLOCK_HEIGHT;

        double paneWidth = Settings.GAME_WIDTH;
        double paneHeight = Settings.GAME_HEIGHT;

        if (tank.getCurrDirection() == Direction.Right &&
                tank.getPosX() > paneWidth* rightMoveBorder )
            mapController.moveViewOnX(
                    -(Math.min(tank.getPosX()-paneWidth* rightMoveBorder,width - paneWidth))
            );
        else if (tank.getCurrDirection() == Direction.Left &&
                tank.getPosX()+mapController.getViewX() < paneWidth*leftMoveBorder ) {
            mapController.moveViewOnX(
                    Math.min(-(tank.getPosX() - paneWidth * leftMoveBorder), 0)
            );
        }

        if (tank.getCurrDirection() == Direction.Down &&
                tank.getPosY()+mapController.getViewY() > paneHeight* bottomMoveBorder )
            mapController.moveViewOnY(
                    -(Math.min(tank.getPosY()-paneHeight* bottomMoveBorder,height - paneHeight))
            );
        else if (tank.getCurrDirection() == Direction.Up &&
                tank.getPosY()+mapController.getViewY() < paneHeight*topMoveBorder ) {
            mapController.moveViewOnY(
                    Math.min(-(tank.getPosY() - paneHeight * topMoveBorder), 0)
            );
        }
    }



}
