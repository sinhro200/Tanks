package com.example.tanks.Controller.StepControllers.TankControllers;

import com.example.tanks.Controller.MapController;
import com.example.tanks.Model.Enums.Direction;
import com.example.tanks.Model.Tank;

public class TowerTankController extends TankController {
    public TowerTankController(MapController mapController, Tank tank) {
        super(mapController, tank);
    }

    @Override
    public void nextStep() {
        Direction directionOfEnemy = getDirectionOfEnemy();
        if (directionOfEnemy != null) {
            tank.rotate(directionOfEnemy);
            tryToFire();
        }
    }

}
