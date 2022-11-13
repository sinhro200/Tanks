package com.example.tanks.Animation;

import com.example.tanks.Controller.StepControllers.StepControllerContainer;
import javafx.animation.AnimationTimer;

public class MyAnimationByAnimationTimer extends MyAnimation {
    private AnimationTimer animationTimer = null;

    public MyAnimationByAnimationTimer(StepControllerContainer stepControllerContainer) {
        super(stepControllerContainer);
        initAnimationTimer();
    }

    @Override
    public void startAnimation() {
        if (animationTimer != null)
            animationTimer.start();
    }

    private void initAnimationTimer(){

        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                nextStep();
            }
        };
    }
}
