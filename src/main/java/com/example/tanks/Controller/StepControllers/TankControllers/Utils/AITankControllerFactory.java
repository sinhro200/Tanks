package com.example.tanks.Controller.StepControllers.TankControllers.Utils;

import com.example.tanks.Controller.MapController;
import com.example.tanks.Controller.StepControllers.TankControllers.SeeAndGoTankController;
import com.example.tanks.Controller.StepControllers.TankControllers.TankController;
import com.example.tanks.Controller.StepControllers.TankControllers.TowerTankController;
import com.example.tanks.Model.Tank;

public class AITankControllerFactory {
    public static TankController getTankController(
            TankControllerType tankControllerType,
            MapController mapController, Tank tank
            ){

        return createTankController(tankControllerType,mapController,tank);
    }

    private static TankController createTankController(
            TankControllerType tankControllerType,MapController mapController,
            Tank tank
    ){
        switch (tankControllerType){
            case Tower:
                return new TowerTankController(mapController,tank);
            case RandomMove:
                return new SeeAndGoTankController(mapController,tank);
            case AlwaysGo:
                return new TankController(mapController,tank) {
                    @Override
                    public void nextStep() {
                        //todo
                    }
                };
            case Defender:
                return new TankController(mapController,tank) {
                    @Override
                    public void nextStep() {
                        //todo
                    }
                };
            case FirstFindThenGo:
                return new TankController(mapController,tank) {
                    @Override
                    public void nextStep() {
                        //todo
                    }
                };
        }
        return null;
    }
}
