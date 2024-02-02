package ch.bbw.gamebbwoy;

import ch.bbw.gamebbwoy.api.PixelDisplay;

public class entitys {
    public double x = 2;
    public double y = 2;
    private String direction = "";

    private int lastMapBlockIndex = -1;

    public entitys(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void update(PixelDisplay graphic){
        //check in which block the user is
        int currentMapBlockX = (int) Math.floor(this.x / 20);
        int currentMapBlockY = (int) Math.floor(this.y / 20);
        int currentMapBlockIndex = currentMapBlockY * pixelSets.mapTemplate[0].length + currentMapBlockX;

        //check if the user is in the middle
        boolean inMiddleX = (int) Math.floor(this.x) > 20 * currentMapBlockX + 1 && (int) Math.floor(this.x) < 20 * currentMapBlockX + 3;
        boolean inMiddleY = (int) Math.floor(this.y) > 20 * currentMapBlockY + 1 && (int) Math.floor(this.y) < 20 * currentMapBlockY + 3;

        //set new direction
        if(inMiddleX && inMiddleY && lastMapBlockIndex != currentMapBlockIndex){

            //save the current block
            mapBlock currentMapBlock = MyPixelDrawing.mapArray[currentMapBlockIndex];

            //create an Array with all possible directions
            java.util.List<String> trueDirections = new java.util.ArrayList<>();
            if(!currentMapBlock.top && direction != "DOWN"){
                trueDirections.add("UP");
            }
            if(!currentMapBlock.bottom && direction != "UP"){
                trueDirections.add("DOWN");
            }
            if(!currentMapBlock.right && direction != "LEFT"){
                trueDirections.add("RIGHT");
            }
            if(!currentMapBlock.left && direction != "RIGHT"){
                trueDirections.add("LEFT");
            }

            //select random direction from the Array
            java.util.Random random = new java.util.Random();
            direction = trueDirections.get(random.nextInt(trueDirections.size()));


            lastMapBlockIndex = currentMapBlockIndex;
        }

        //move entity
        switch (direction) {
            case "UP" -> this.y -= MyPixelDrawing.speed;
            case "DOWN" -> this.y += MyPixelDrawing.speed;
            case "LEFT" -> this.x -= MyPixelDrawing.speed;
            case "RIGHT" -> this.x += MyPixelDrawing.speed;
            default -> {
            }
        }



        //check if entity collide with player

        //save player and entity size
        int playerHeight = pixelSets.playerPixelArrayRight.length;
        int playerWidth = pixelSets.playerPixelArrayRight[0].length;
        int entityHeight = pixelSets.sprite.length;
        int entityWidth = pixelSets.sprite[0].length;

        //check collision with player
        boolean collidesX = player.x < this.x + entityWidth && player.x + playerWidth > this.x;
        boolean collidesY = player.y < this.y + entityHeight && player.y + playerHeight > this.y;

        //stop game by collision
        if(collidesX && collidesY){
            //stop the game
            MyPixelDrawing.gameHasStarted = false;
            MyPixelDrawing.startGame = false;
        }


        //draw entity
        MyPixelDrawing.drawArray(graphic, pixelSets.sprite, this.x, this.y);
    }
}
