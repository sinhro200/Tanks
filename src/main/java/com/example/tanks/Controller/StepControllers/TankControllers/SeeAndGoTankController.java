package com.example.tanks.Controller.StepControllers.TankControllers;

import com.example.tanks.Controller.MapController;
import com.example.tanks.Model.Enums.Direction;
import com.example.tanks.Model.Tank;
import com.example.tanks.Settings;

import java.util.Random;

public class SeeAndGoTankController extends TankController {
    public SeeAndGoTankController(MapController mapController, Tank tank) {
        super(mapController, tank);
        tank.rotate(Direction.Right);
    }

//    int xBlockTo;
//    int yBlockTo;

    @Override
    public void nextStep() {
        Direction directionOfEnemy = getDirectionOfEnemy();
        if (directionOfEnemy != null) {
            tank.rotate(directionOfEnemy);
            tryToFire();
        }
        else if (!moveTankInItsDir()){
            tank.rotate(Direction.values()[new Random().nextInt(4)]);
        }
    }

    private boolean alignToBlockWithoutRotating(){
        double xC = tank.getPosX() + tank.getTankWidth()/2;
        double yC = tank.getPosY() + tank.getTankHeight()/2;

        double blockXC = xC/ Settings.BLOCK_WIDTH + Settings.BLOCK_WIDTH/2;
        double blockYC = yC/Settings.BLOCK_HEIGHT + Settings.BLOCK_HEIGHT/2;

        double dX =Math.abs(xC - blockXC );
        double dY =Math.abs(yC - blockYC);
        if (dX > 1 ) {
            if (dX<= tank.getSpeed())
                tank.setPosXCenter(blockXC);
            else

            return true;
        }
        else if (dY > 1 && dY <= tank.getSpeed()){
            tank.setPosYCenter(blockYC);
            return true;
        }
        return false;
    }

    private void goToBlock(int xBlockTo,int yBlockTo){
        double xTo = xBlockTo*Settings.BLOCK_WIDTH;
        double yTo =yBlockTo*Settings.BLOCK_HEIGHT;
        Direction direction = null;
        if (xTo > tank.getPosX())
            direction = Direction.Right;
        if (xTo < tank.getPosX())
            direction = Direction.Left;
        if (yTo < tank.getPosY())
            direction = Direction.Up;
        if (yTo > tank.getPosY())
            direction = Direction.Down;

        tank.rotate(direction);
        moveTankInItsDir();
    }


}
