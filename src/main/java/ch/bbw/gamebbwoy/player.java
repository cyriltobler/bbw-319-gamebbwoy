package ch.bbw.gamebbwoy;

import ch.bbw.gamebbwoy.api.PixelDisplay;

public class player {
    public static double x = 2;
    public static double y = 2;
    static String direction = "";
    static String nextDirection = "";

    static void update(PixelDisplay graphic){
        //check in which block the user is
        int currentMapBlockX = (int) Math.floor(x / 20);
        int currentMapBlockY = (int) Math.floor(y / 20);
        int currentMapBlockIndex = currentMapBlockY * pixelSets.mapTemplate[0].length + currentMapBlockX;

        //check if the user is in the middle
        boolean inMiddleX = (int) Math.floor(x) > 20 * currentMapBlockX + 1 && (int) Math.floor(x) < 20 * currentMapBlockX + 3;
        boolean inMiddleY = (int) Math.floor(y) > 20 * currentMapBlockY + 1 && (int) Math.floor(y) < 20 * currentMapBlockY + 3;

        //check if the direction is possible
        if(inMiddleX && inMiddleY){
            direction = "";
            switch(nextDirection){
                case "UP":
                    if(currentMapBlockY != 0 && !MyPixelDrawing.mapArray[currentMapBlockIndex].top){
                        direction = nextDirection;
                    }
                    break;
                case "DOWN":
                    if(currentMapBlockY != pixelSets.mapTemplate.length && !MyPixelDrawing.mapArray[currentMapBlockIndex].bottom){
                        direction = nextDirection;
                    }
                    break;
                case "RIGHT":
                    if(currentMapBlockX != pixelSets.mapTemplate[0].length && !MyPixelDrawing.mapArray[currentMapBlockIndex].right){
                        direction = nextDirection;
                    }
                    break;
                case "LEFT":
                    if(currentMapBlockX != 0 && !MyPixelDrawing.mapArray[currentMapBlockIndex].left){
                        direction = nextDirection;
                    }
                    break;
            }
        }

        //move the player
        switch (direction) {
            case "UP" -> y -= MyPixelDrawing.speed;
            case "DOWN" -> y += MyPixelDrawing.speed;
            case "LEFT" -> x -= MyPixelDrawing.speed;
            case "RIGHT" -> x += MyPixelDrawing.speed;
            default -> {
            }
        }

        //select the right player pixel array
        int[][] currentPlayerPixelArray;
        if(MyPixelDrawing.animationCounter < 10){
            switch (direction) {
                case "UP" -> currentPlayerPixelArray = pixelSets.playerPixelArrayUp;
                case "DOWN" -> currentPlayerPixelArray = pixelSets.playerPixelArrayDown;
                case "LEFT" -> currentPlayerPixelArray = pixelSets.playerPixelArrayLeft;
                case "RIGHT" -> currentPlayerPixelArray = pixelSets.playerPixelArrayRight;
                default -> {
                    currentPlayerPixelArray = pixelSets.playerPixelArrayRight;
                }
            }
        }else{
            switch (direction) {
                case "UP" -> currentPlayerPixelArray = pixelSets.playerPixelArrayUpClosed;
                case "DOWN" -> currentPlayerPixelArray = pixelSets.playerPixelArrayDownClosed;
                case "LEFT" -> currentPlayerPixelArray = pixelSets.playerPixelArrayLeftClosed;
                case "RIGHT" -> currentPlayerPixelArray = pixelSets.playerPixelArrayRightClosed;
                default -> {
                    currentPlayerPixelArray = pixelSets.playerPixelArrayRight;
                }
            }
        }

        //draw the player with the selected pixel array
        MyPixelDrawing.drawArray(graphic, currentPlayerPixelArray, player.x, player.y);
    }
}
