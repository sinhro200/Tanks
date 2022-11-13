package com.example.tanks.Animation;

import com.example.tanks.Controller.StepControllers.MyStepController;
import com.example.tanks.Controller.StepControllers.StepControllerContainer;

public abstract class MyAnimation {
    StepControllerContainer stepControllerContainer;

    public MyAnimation(StepControllerContainer stepControllerContainer) {
        this.stepControllerContainer = stepControllerContainer;
    }

    protected void nextStep(){
        for (MyStepController controller : stepControllerContainer.getControllers()){
            controller.nextStep();
        }
    }

    public abstract void startAnimation();

}
