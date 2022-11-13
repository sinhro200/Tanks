package com.example.tanks.Controller.StepControllers;

import com.example.tanks.Utils.MyContainer;

import java.util.List;

public class StepControllerContainer extends MyContainer<MyStepController> {
    private static StepControllerContainer instance;
    public static StepControllerContainer getInstance() {
        if (instance == null) {
            instance = new StepControllerContainer();
        }
        return instance;
    }

    public StepControllerContainer() {
        super();
    }


    public List<MyStepController> getControllers() {
        return super.get();
    }

}
