package com.example.tanks.Animation;

import com.example.tanks.Controller.StepControllers.StepControllerContainer;

import java.util.Timer;
import java.util.TimerTask;

public class MyAnimationByTimerSchedule extends MyAnimation{
    private Timer timer;

    public MyAnimationByTimerSchedule(StepControllerContainer stepControllerContainer) {
        super(stepControllerContainer);
        timer = new Timer();
    }

    @Override
    public void startAnimation() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                for (MyStepController controller : stepControllerContainer.get()){
//                    controller.nextStep();
//                }
                nextStep();
            }
        }, 0, 16);
    }

}
