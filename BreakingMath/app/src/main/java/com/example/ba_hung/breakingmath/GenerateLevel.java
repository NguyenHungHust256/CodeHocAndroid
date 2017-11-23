package com.example.ba_hung.breakingmath;

import java.util.Random;

/**
 * Created by ba-hung on 24/06/2017.
 */

public class GenerateLevel {
    // Score of each level
    public static final int EASY = 10;
    public static final int MEDIUM = 20;
    public static final int HARD = 50;

    public static LevelModel generateLevel(int count){
        LevelModel level = new LevelModel();
        Random rand = new Random();

        //get current difficult level

        if(count <= EASY){
            level.difficultLevel=1;
        }
        else {
            if(count <=MEDIUM){
                level.difficultLevel = 2;
            }
            else {
                if(count <=HARD){
                    level.difficultLevel = 3;
                }
                else{
                    level.difficultLevel = 4;
                }
            }
        }
        //random operation
        level.operator = rand.nextInt(level.difficultLevel);

        //random operation
        level.x = rand.nextInt(level.arrMaxOperatorValue[level.difficultLevel])+1;
        level.y = rand.nextInt(level.arrMaxOperatorValue[level.difficultLevel])+1;

        //random result:correct or wrong

        level.correctWrong = rand.nextBoolean();

        //random result
        if(level.correctWrong==false){
            switch(level.operator){
                case LevelModel.ADD:
                    do{
                        level.result = rand.nextInt(level.arrMaxOperatorValue[level.difficultLevel]);
                    }while(level.result==(level.x + level.y));
                    break;
                case LevelModel.SUB:
                    do{
                        level.result = rand.nextInt(level.arrMaxOperatorValue[level.difficultLevel]);
                    }while(level.result==(level.x - level.y));
                    break;
                case LevelModel.MUL:
                    do{
                        level.result = rand.nextInt(level.arrMaxOperatorValue[level.difficultLevel]);
                    }while(level.result==(level.x * level.y));
                    break;
                case LevelModel.DIV:
                    do{
                        level.result = rand.nextInt(level.arrMaxOperatorValue[level.difficultLevel]);
                    }while(level.result==(level.x / level.y));
                    break;
                default:
                    break;
            }
        }else {
            switch (level.operator){
                case LevelModel.ADD:
                    level.result = level.x + level.y;
                    break;
                case LevelModel.SUB:
                    level.result = (level.x * level.y);
                    break;
                case LevelModel.DIV:
                    level.result = level.x / level.y;
                    break;
                default:
                    break;
            }
        }

        level.strOperator = String.valueOf(level.x) + level.arrMaxOperatorValue[level.operator-1]
                            + String.valueOf(level.y);
        // Create String Result
        level.strResult = LevelModel.EQU_TEXT + String.valueOf(level.result);
        return level;
    }
}
