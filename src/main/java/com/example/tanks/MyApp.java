package com.example.tanks;

import com.example.tanks.Scenes.MyGameScene;
import com.example.tanks.Scenes.MyMenuScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        launchMenuScene();
    }

    private void launchMenuScene(){
        Scene scene = new MyMenuScene(
                Settings.MENU_WIDTH,Settings.MENU_HEIGHT,
                this::launchGameScene
                );

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void launchGameScene(){
        Scene scene = new MyGameScene(
                Settings.GAME_WIDTH,Settings.GAME_HEIGHT
        );
        primaryStage.setX(
                100+
                (Settings.FULL_SCREEN_WIDTH-Settings.GAME_WIDTH)/2);
        primaryStage.setY(
                (Settings.FULL_SCREEN_HEIGHT-Settings.GAME_HEIGHT)/2
        );

        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }

}
