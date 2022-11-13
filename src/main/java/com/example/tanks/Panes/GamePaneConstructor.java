package com.example.tanks.Panes;

import com.example.tanks.Model.Enums.BlockType;
import com.example.tanks.Model.GameMap;
import com.example.tanks.Settings;
import javafx.scene.canvas.Canvas;

public class GamePaneConstructor {

    public static GamePane getGamePane(GameMap gameMap) {
        GamePane gamePane = new GamePane();
        fillBackWithEmptyBlocks(gamePane, gameMap);
        loadTextures(gamePane, gameMap);

        return gamePane;
    }

    private static void fillBackWithCanvas(GamePane gamePane) {
        Canvas canvas = new Canvas(Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gamePane.background.getChildren().add(canvas);
    }

    private static void fillBackWithEmptyBlocks(GamePane gamePane, GameMap gameMap) {
        BlockType[][] field = gameMap.field;
        for (int i = 0; i < field.length; i++)
            for (int j = 0; j < field[0].length; j++)
                gamePane.changeBlock(j, i, BlockType.EMPTY);
    }

    private static void loadTextures(GamePane gamePane, GameMap gameMap) {
        BlockType[][] field = gameMap.field;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                BlockType blockType = field[i][j];
                gamePane.changeBlock(j, i, blockType);
            }
        }
    }
}
