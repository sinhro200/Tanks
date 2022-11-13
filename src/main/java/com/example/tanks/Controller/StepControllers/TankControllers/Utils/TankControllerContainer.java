package com.example.tanks.Controller.StepControllers.TankControllers.Utils;

import com.example.tanks.Controller.StepControllers.TankControllers.TankController;
import com.example.tanks.Utils.MyContainer;

import java.util.List;

public class TankControllerContainer extends MyContainer<TankController> {
    private static TankControllerContainer instance;

    public static TankControllerContainer getInstance() {
        if (instance == null) {
            instance = new TankControllerContainer();
        }
        return instance;
    }

    public TankControllerContainer() {
        super();
    }

    public List<TankController> getControllers() {
        return super.get();
    }
}
