package com.example.tanks.Model;

import com.example.tanks.Model.Enums.BlockType;

import java.util.List;

public class GameMap {

    public BlockType[][] field;
    public int countBlocksWidth;
    public int countBlocksHeight;
    public int[][] spawnPoints;
    public int[] playerSpawnPoint;

    public GameMap(BlockType[][] field, int countBlocksWidth, int countBlocksHeight) {
        this.field = field;
        this.countBlocksWidth = countBlocksWidth;
        this.countBlocksHeight = countBlocksHeight;
    }

    public GameMap(BlockType[][] field, int countBlocksWidth, int countBlocksHeight,
                   int[][] spawnPoints, int[] playerSpawnPoint) {
        this(field, countBlocksWidth, countBlocksHeight);
        setSpawnPoints(spawnPoints,playerSpawnPoint);
    }

    public void setSpawnPoints(int[][] spawnPoints, int[] playerSpawnPoint){
        this.spawnPoints = spawnPoints;
        this.playerSpawnPoint = playerSpawnPoint;
    }

}
