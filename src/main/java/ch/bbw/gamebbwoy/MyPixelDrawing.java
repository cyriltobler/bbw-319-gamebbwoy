package ch.bbw.gamebbwoy;

import ch.bbw.gamebbwoy.api.ButtonListener;
import ch.bbw.gamebbwoy.api.PixelColor;
import ch.bbw.gamebbwoy.api.PixelDisplay;
import ch.bbw.gamebbwoy.api.PixelDrawing;
import ch.bbw.gamebbwoy.internal.GameBbwoy;


public class MyPixelDrawing implements PixelDrawing, ButtonListener {
	//game settings
	public static int numberOfEntitys = 3;
	public static double speed = 0.4;

	//game variable
	public static int gameScore = 0;
	public static int animationCounter = 0;
	public static boolean startGame = false;
	public static boolean gameHasStarted = false;

	//initialize Arrays for multiple classes
	public static mapBlock[] mapArray = new mapBlock[7 * 8];
	public static entitys[] entityArray = new entitys[3];
	public static items[] coinArray = new items[7 * 8];

	//set up the game
	public static void main(String[] args) throws Throwable {
		GameBbwoy.playGame(new MyPixelDrawing());
	}

	//reset the game
	public static void setup(){
		createMap();
		createEntity();

		player.x = 2;
		player.y = 2;
	}

	//repeated function(game ticks)
	@Override
	public void tick(PixelDisplay graphic) {
		if(!gameHasStarted){
			//update lobby
			lobby.update(graphic);
		}else{
			//update game
			graphic.clear();

			//draw the map
			for (mapBlock element : mapArray) {
				element.drawBlocks(graphic);
			}

			//update and draw the coins
			for (items element : coinArray) {
				element.update(graphic);
			}

			//update and draw the player
			player.update(graphic);

			//update and draw the entitys
			for (entitys element : entityArray) {
				element.update(graphic);
			}

			//count the ticks and reset them
			animationCounter++;
			if(animationCounter >= 20){
				animationCounter = 0;
			}
		}
	}

	//draw an object
	public static void drawArray(PixelDisplay graphic, int[][] object, double doublePosX, double doublePosY) {
		//round double down to an integer
		int posX = (int) Math.floor(doublePosX);
		int posY = (int) Math.floor(doublePosY);

		//draw each pixel of the Array
		for (int y = posY; y < posY + object.length; y++) {
			for (int x = posX; x < posX + object[y - posY].length; x++) {
				if (object[y - posY][x - posX] != 4) {
					//set a single pixel
					graphic.setPixel(x, y, PixelColor.fromValue(object[y - posY][x - posX]));
				}
			}
		}
	}

	//create the map from the template
	public static void createMap(){
		String[][] map = pixelSets.mapTemplate;
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				int index = y * map[y].length + x;
				String blockType = map[y][x];

				//push the map block class in the array
				mapArray[index] = new mapBlock(blockType, x, y);

				//push the coin class in the array
				coinArray[index] = new items(x, y, "nothing" != blockType);
			}
		}
	}

	//creates the ghosts
	public static void createEntity(){
		//start mapBlock
		int x = 6;
		int y = 6;

		//create the entitys
		for (int i = 0; i < numberOfEntitys; i++) {
			entityArray[i] = new entitys(2 + 20 * x, 2 + 20 * y);
		}
	}


	//button events
	public void onButtonPress(GameButton button) {
		System.out.println(button);
		//save next direction in the player class
		switch (button) {
			case UP -> player.nextDirection = "UP";
			case DOWN -> player.nextDirection = "DOWN";
			case LEFT -> player.nextDirection = "LEFT";
			case RIGHT -> player.nextDirection = "RIGHT";
			case SPACE -> startGame = true;
			default -> {
			}
		}
	}
	@Override
	public void onButtonRelease(GameButton button) {}
}

