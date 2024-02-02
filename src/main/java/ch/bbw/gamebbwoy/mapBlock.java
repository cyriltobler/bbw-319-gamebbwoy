package ch.bbw.gamebbwoy;


import ch.bbw.gamebbwoy.api.PixelDisplay;

public class mapBlock{
    private int x;
    private int y;
    public boolean top = false;
    public boolean bottom = false;
    public boolean left = false;
    public boolean right = false;

    //convert input
    public mapBlock(String mapBlockType, int x, int y) {
        switch (mapBlockType) {
            case "cornerTopLeft" -> {
                this.top = true;
                this.left = true;
            }
            case "cornerTopRight" -> {
                this.top = true;
                this.right = true;
            }
            case "cornerBottomLeft" -> {
                this.bottom = true;
                this.left = true;
            }
            case "cornerBottomRight" -> {
                this.bottom = true;
                this.right = true;
            }
            case "straightHorizontal" -> {
                this.top = true;
                this.bottom = true;
            }
            case "straightVertical" -> {
                this.left = true;
                this.right = true;
            }
            case "nothing" -> {
                this.left = true;
                this.right = true;
                this.top = true;
                this.bottom = true;
            }
            case "crossBottom" -> {
                this.top = true;
            }
            case "crossTop" -> {
                this.bottom = true;
            }
            case "crossLeft" -> {
                this.right = true;
            }
            case "crossRight" -> {
                this.left = true;
            }
        }
        this.x = x;
        this.y = y;
    }

    //draw the way objects
    public void drawBlocks(PixelDisplay graphic){
        MyPixelDrawing.drawArray(graphic, pixelSets.standardMap, this.x * 20, this.y * 20);
        if(this.top){
            MyPixelDrawing.drawArray(graphic, pixelSets.topMap, this.x * 20, this.y * 20);
        }
        if(this.bottom){
            MyPixelDrawing.drawArray(graphic, pixelSets.bottomMap, this.x * 20, this.y * 20);
        }
        if(this.left){
            MyPixelDrawing.drawArray(graphic, pixelSets.leftMap, this.x * 20, this.y * 20);
        }
        if(this.right){
            MyPixelDrawing.drawArray(graphic, pixelSets.rightMap, this.x * 20, this.y * 20);
        }
    }
}