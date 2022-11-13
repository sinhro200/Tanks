package com.example.tanks.Model.Enums;

import java.util.HashSet;
import java.util.Set;

public enum BlockType {
//    EMPTY("src\\Tanks\\textures\\empty.png"),
//    LEAF("src\\Tanks\\textures\\leaf.png"),
//    BRICKS("src\\Tanks\\textures\\bricks.png")
    EMPTY("empty.png"),
    LEAF("leaf.png"),
    BRICKS("bricks.png")
    ;
    public String path;

    BlockType(String url) {
        this.path = url;
    }


    private static Set<BlockType> obstacles;
    private static Set<BlockType> hides;

    public static void init() {
        obstacles = new HashSet<>();
        obstacles.add(BlockType.BRICKS);
        hides = new HashSet<>();
        hides.add(BRICKS);
        hides.add(LEAF);
    }

    public static boolean isObstacle(BlockType blockType){
        return (obstacles.contains(blockType));
    }

    public static boolean isVisible(BlockType blockType){
        return !hides.contains(blockType);
    }
}
