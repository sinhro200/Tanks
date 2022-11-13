package com.example.tanks.Scenes;

import com.example.tanks.Controller.MainController;
import com.example.tanks.Controller.MapController;
import com.example.tanks.Model.Enums.BlockType;
import com.example.tanks.Model.GameMap;
import com.example.tanks.Model.MyMapConstructor;
import com.example.tanks.Panes.GamePane;
import com.example.tanks.Panes.GamePaneConstructor;
import com.example.tanks.Utils.CodeBlockConverter;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.HashSet;
import java.util.Set;

public class MyGameScene extends Scene {
    private Set<KeyCode> controlKeys;
    GamePane gamePane;

    Set<KeyCode> pressedKeys;

    public MyGameScene(double width, double height) {
        super(new Pane(), width, height);
        CodeBlockConverter.init();
        BlockType.init();
        initControlKeys();

        GameMap gameMap = MyMapConstructor.getMap(MyMapConstructor.MapNum.bigMap);
        gamePane = GamePaneConstructor.getGamePane(gameMap);
        MapController mapController = new MapController(gameMap,gamePane);

        MainController mainController = new MainController(
                mapController, pressedKeys
        );

        this.setRoot(gamePane);

        mainController.beginAnimation();
    }

    private void initControlKeys(){
        controlKeys = new HashSet<>();
        controlKeys.add(KeyCode.UP);
        controlKeys.add(KeyCode.DOWN);
        controlKeys.add(KeyCode.RIGHT);
        controlKeys.add(KeyCode.LEFT);
        controlKeys.add(KeyCode.SPACE);

        pressedKeys = new HashSet<>();

        this.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            if (controlKeys.contains(code))
                pressedKeys.add(code);
        });
        this.setOnKeyReleased(event -> {
            KeyCode code = event.getCode();
            if (controlKeys.contains(code))
                pressedKeys.remove(code);
            pressedKeys.remove(event.getCode());
        });
    }

}
