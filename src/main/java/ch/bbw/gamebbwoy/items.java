package ch.bbw.gamebbwoy;

import ch.bbw.gamebbwoy.api.PixelDisplay;

public class items {
    private int x;
    private int y;
    private boolean visible = true;

    public items(int x, int y, boolean visible){
        this.x = x * 20 + 7;
        this.y = y * 20 + 7;
        this.visible = visible;
    }

    public void update(PixelDisplay graphic){
        //check if coin collide with player

        //save player and coin size
        int playerHeight = pixelSets.playerPixelArrayUp.length;
        int playerWidth = pixelSets.playerPixelArrayUp[0].length;
        int coinHeight = pixelSets.coin.length;
        int coinWidth = pixelSets.coin[0].length;

        //check collision with player
        boolean collidesX = player.x < this.x + coinWidth && player.x + playerWidth > this.x;
        boolean collidesY = player.y < this.y + coinHeight && player.y + playerHeight > this.y;

        // if player collides with coin add score + 1
        if(collidesX && collidesY){
            if(visible){
                MyPixelDrawing.gameScore++;

                //end game when all coins are collected
                if(MyPixelDrawing.gameScore >= 54){
                    MyPixelDrawing.gameHasStarted = false;
                    MyPixelDrawing.startGame = false;
                }
            }
            visible = false;
        }

        //draw coin, when he is visible
        if(this.visible){
            //draw coin
            MyPixelDrawing.drawArray(graphic, pixelSets.coin, this.x, this.y);
        }
    }

}
