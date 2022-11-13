package com.example.tanks.Model;

import com.example.tanks.Model.Enums.BlockType;
import com.example.tanks.Utils.CodeBlockConverter;

public class MyMapConstructor {

    public static GameMap getMap(MapNum mapNum){
        return new GameMap(
                CodeBlockConverter.codesToBlocks(mapNum.mapArray),
                mapNum.mapArray[0].length,
                mapNum.mapArray.length,
                mapNum.spawnPoints,
                new int[]{1,1}
        );
    }

    private static final int e = CodeBlockConverter.blockToCode(BlockType.EMPTY);
    private static final int b = CodeBlockConverter.blockToCode(BlockType.BRICKS);
    private static final int l = CodeBlockConverter.blockToCode(BlockType.LEAF);

    public enum MapNum{
        emptyMap (new int[][]{
                {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                {b,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,b},
                {b,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,b},
                {b,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,b},
                {b,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,b},
                {b,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,b},
                {b,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,b},
                {b,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,b},
                {b,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,b},
                {b,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,b},
                {b,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,b},
                {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b}
        },new int[][]{
                {1,1},
                {18,10}
        }),
        map1(new int[][]{
                {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                {b,e,e,b,b,b,e,e,e,e,e,e,e,e,e,e,l,l,l,b},
                {b,e,l,l,l,l,l,l,l,l,l,l,l,l,e,b,e,e,e,b},
                {b,e,b,b,b,e,e,b,b,b,e,e,e,e,e,b,e,e,e,b},
                {b,e,l,l,l,l,l,l,l,l,l,l,l,l,e,b,b,b,e,b},
                {b,e,e,b,b,b,e,e,b,b,b,e,e,e,e,e,e,e,e,b},
                {b,b,b,b,l,l,l,l,l,b,b,b,l,l,e,l,e,e,l,b},
                {b,e,e,e,e,e,e,e,e,e,b,b,b,e,e,b,e,l,e,b},
                {b,e,l,l,l,l,l,l,l,l,l,b,b,b,e,b,e,l,e,b},
                {b,e,e,e,e,e,e,e,e,e,e,e,b,b,b,l,e,e,e,b},
                {b,e,b,b,b,e,e,b,b,b,e,e,e,e,e,b,e,e,e,b},
                {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
        },new int[][]{
//                {1,1},
                {6,7},
                {14,10},
                {18,10}
        }),
        bigMap(new int[][]{
                {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
                {b,e,e,b,b,b,e,e,e,e,e,e,e,e,e,e,l,l,l,e,e,e,l,b,b,e,e,e,l,b},
                {b,e,l,l,l,l,l,l,l,l,l,l,l,l,e,b,e,e,e,e,e,e,l,b,b,e,e,e,l,b},
                {b,e,b,b,b,e,e,b,b,b,e,e,e,e,e,b,e,e,e,e,e,e,l,b,b,e,e,e,l,b},
                {b,e,l,l,l,l,l,l,l,l,l,l,l,l,e,b,b,b,e,e,e,e,l,e,e,e,e,e,l,b},
                {b,e,e,b,b,b,e,e,b,b,b,e,e,e,e,e,e,e,e,e,e,e,l,b,b,e,e,e,l,b},
                {b,b,b,b,l,l,l,l,l,b,b,b,l,l,e,l,e,e,l,e,e,e,l,b,b,e,e,e,l,b},
                {b,e,e,e,e,e,e,e,e,e,b,b,b,e,e,b,e,l,e,e,e,e,b,e,e,e,e,e,l,b},
                {b,e,l,l,l,l,l,l,l,l,l,b,b,b,e,b,e,l,e,e,e,b,e,e,l,e,e,e,l,b},
                {b,e,e,e,e,e,e,e,e,e,e,e,b,b,b,l,e,e,e,e,e,e,l,l,l,e,e,e,l,b},
                {b,e,b,b,b,e,e,b,b,b,e,e,e,e,e,b,e,e,e,e,e,e,l,l,l,e,e,e,l,b},
                {b,e,l,l,l,l,l,l,l,l,l,l,l,l,e,b,e,e,e,e,e,e,l,b,b,e,e,e,l,b},
                {b,e,b,b,b,e,e,b,b,b,e,e,e,e,e,b,e,e,e,e,e,e,l,b,b,e,e,e,l,b},
                {b,e,l,l,l,l,l,l,l,l,l,l,l,l,e,b,b,b,e,e,e,e,l,e,e,e,e,e,l,b},
                {b,e,e,b,b,b,e,e,b,b,b,e,e,e,e,e,e,e,e,e,e,e,l,b,b,e,e,e,l,b},
                {b,b,b,b,l,l,l,l,l,b,b,b,l,l,e,l,e,e,l,e,e,e,l,b,b,e,e,e,l,b},
                {b,e,e,e,e,e,e,e,e,e,b,b,b,e,e,b,e,l,e,e,e,e,b,e,e,e,e,e,l,b},
                {b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b,b},
        },new int[][]{
//                {1,1},
                {6,7},
                {14,10},
                {18,10}
        }),
        ;
        private final int[][] mapArray;
        private final int[][] spawnPoints;

        MapNum(int[][] mapArray,int[][] spawnPoints) {
            this.mapArray = mapArray;
            this.spawnPoints = spawnPoints;
        }
    }





}
