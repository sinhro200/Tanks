package com.example.tanks.Controller;

import com.example.tanks.Model.Enums.BlockType;
import com.example.tanks.Model.GameMap;
import com.example.tanks.Panes.GamePane;
import javafx.scene.Node;

public class MapController {
    private GameMap gameMap;
    private GamePane gamePane;

    public MapController(GameMap gameMap, GamePane gamePane) {
        this.gameMap = gameMap;
        this.gamePane = gamePane;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setBlock(int x, int y, BlockType blockType){
        gamePane.changeBlock(x,y,blockType);
        gameMap.field[y][x] = blockType;
    }

    public void addNode(Node node){
        gamePane.addNode(node);
    }

    public void removeNode(Node node){
        gamePane.removeNode(node);
    }

    public void moveViewOnX(double x){
        this.gamePane.setTranslateX(x);
    }

    public void moveViewOnY(double y){
        this.gamePane.setTranslateY(y);
    }

    public double getViewX(){
        return this.gamePane.getTranslateX();
    }

    public double getViewY(){
        return this.gamePane.getTranslateY();
    }
}
