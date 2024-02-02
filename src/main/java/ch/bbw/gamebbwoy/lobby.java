package ch.bbw.gamebbwoy;

import ch.bbw.gamebbwoy.api.PixelColor;
import ch.bbw.gamebbwoy.api.PixelDisplay;

public class lobby {
    public static int lobbyTick = 0;


    static void update(PixelDisplay graphic){

        if(!MyPixelDrawing.startGame){
            //draw lobby
            graphic.clear();

            MyPixelDrawing.drawArray(graphic, lobbyPixelSets.logo, 0, 25);
            MyPixelDrawing.drawArray(graphic, lobbyPixelSets.startText, 0, 70);
            MyPixelDrawing.drawArray(graphic, lobbyPixelSets.pixelpadLogo, 0, 100);

            animationOpen(graphic);

            lobbyTick++;
        }else{
            //start game
            graphic.clear();

            MyPixelDrawing.setup();
            MyPixelDrawing.gameHasStarted = true;
            MyPixelDrawing.gameScore = 0;
            lobbyTick = 0;
        }
    }

    //draw an horizontal line
    static void drawHorizontalLine(PixelDisplay graphic, int y){
        for (int x = 0; x < graphic.getPixelWidth(); x++) {
            graphic.setPixel(x, y, PixelColor.fromValue(3));
        }
    }

    //draw an open animation
    static void animationOpen(PixelDisplay graphic){
        int canvasHeight = graphic.getPixelHeight();
        if(lobbyTick * 2 < canvasHeight){
            int thisAnimationTick = canvasHeight / 2 - lobbyTick;
            for (int y = thisAnimationTick; y > 0; y--) {
                drawHorizontalLine(graphic, y);
                drawHorizontalLine(graphic, canvasHeight - y);
            }
        }
    }

    //draw a close animation
    static void animationClose(PixelDisplay graphic){
        int canvasHeight = graphic.getPixelHeight();
        if(lobbyTick * 2 < canvasHeight){
            for (int y = lobbyTick; y > 0; y--) {
                drawHorizontalLine(graphic, y);
                drawHorizontalLine(graphic, canvasHeight - y);
            }
        }
    }

}
