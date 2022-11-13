package com.example.tanks.Utils;

import com.example.tanks.Model.Enums.BlockType;

import java.util.HashMap;
import java.util.Map;

public class CodeBlockConverter {
    private static Map<Integer, BlockType> codes = null;
    private static Map<BlockType, Integer> blocks = null;

    public static void init(){
        codes = new HashMap<>();
        blocks = new HashMap<>();

        tie(0,BlockType.EMPTY);
        tie(1,BlockType.BRICKS);
        tie(2,BlockType.LEAF);
    }

    public static int[][] blocksToCodes(BlockType[][] blockTypes){
        if (codes == null)
            init();
        int height = blockTypes.length;
        int width = blockTypes[0].length;
        int[][] codes = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                codes[i][j] = blockToCode(blockTypes[i][j]);
            }
        }
        return codes;
    }

    public static BlockType[][] codesToBlocks(int[][] codes){
        if (blocks == null)
            init();
        int height = codes.length;
        int width = codes[0].length;
        BlockType[][] blockTypes = new BlockType[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                blockTypes[i][j] = codeToBlock(codes[i][j]);
            }
        }
        return blockTypes;
    }

    public static BlockType codeToBlock(int code){
        return codes.get(code);
    }

    public static int blockToCode(BlockType blockType){
        return blocks.get(blockType);
    }

    private static void tie(int code, BlockType blockType){
        codes.put(code,blockType);
        blocks.put(blockType,code);
    }
}
