package com.example.tanks.Panes;

import com.example.tanks.Model.Enums.BlockType;
import com.example.tanks.Settings;
import javafx.scene.Node;
import javafx.scene.layout.*;

import java.util.HashMap;
import java.util.Map;


public class GamePane extends Pane {
    private Map<Position,MyBlockPane> blocks;

    private double blockWidth ;
    private double blockHeight ;

    Pane foreground;
    Pane background;


    public GamePane() {
        this.blockHeight = Settings.BLOCK_HEIGHT;
        this.blockWidth = Settings.BLOCK_WIDTH;
        this.blocks = new HashMap<>();

        foreground = new Pane();
        background = new Pane();

        this.getChildren().addAll(background,foreground);
    }

    public void addNode(Node node){
        background.getChildren().add(node);
    }

    public void removeNode(Node node){
        background.getChildren().remove(node);
    }

    public void changeBlock(int x, int y, BlockType blockType){
        MyBlockPane block = new MyBlockPane(blockType.path);
        block.setTranslateX(blockWidth * x);
        block.setTranslateY(blockHeight * y);


        Position pos = new Position(x,y);

        MyBlockPane oldBlock = blocks.get(pos);
        if (oldBlock != null){
            removeBlockPane(block,blockType);
        }

        blocks.put(pos,block);

        addBlockPane(block,blockType);
    }

    private void addBlockPane(MyBlockPane blockPane, BlockType blockType){
        if (blockType.equals(BlockType.LEAF))
            foreground.getChildren().add(blockPane);
        else
            background.getChildren().add(blockPane);
    }

    private void removeBlockPane(MyBlockPane blockPane,BlockType blockType){
        if (blockType.equals(BlockType.LEAF))
            foreground.getChildren().remove(blockPane);
        else
            background.getChildren().remove(blockPane);
    }

    private class Position{
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
