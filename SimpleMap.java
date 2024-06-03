package graphics;
import java.awt.Color;

import hsa2.GraphicsConsole;

public class SimpleMap {
	
	static GraphicsConsole gc = new GraphicsConsole(800,600);
	String[][] tiles = new String[20][15];
	
	static void setup() {
		gc.setLocationRelativeTo(null);
		gc.setBackground(Color.BLACK);
		gc.clear();

	}
	String[] pinchedRow(int leftPinch, int rightPinch, int rowLength) {
		String[] row = new String[rowLength];
		for(int i = 0; i < leftPinch; i++) {
			row[i] = "wall";
		}
		for(int i = rowLength-1; i > rowLength-1-rightPinch; i--) {
			row[i] = "wall";
		}
		return row;
	}
	void generateMap() {
		for(String[] c: tiles) {
			int leftPinch = (int)Math.random()*10;
			int rightPinch = (int)Math.random()*10;
			c = pinchedRow(leftPinch, rightPinch, 20);
		}
		makePerimeterWall();
	}
	
	void makePerimeterWall() {
		for(String t: tiles[0]) {
			t = "wall";
		}
		for(String t: tiles[19]) {
			t = "wall";
		}
		for(String[] c: tiles) {
			c[0] = "wall";
			c[19]= "wall";
		}
	}
	
	public static void drawTile(String type, int x, int y) {
		if(type.equals("wall")) {
			gc.setColor(Color.DARK_GRAY);
			gc.fillRect(x,y,40,40);
		}
		if(type.equals("floor")) {
			gc.setColor(Color.LIGHT_GRAY);
			gc.fillRect(x,y,40,40);
		}
	}

	SimpleMap(){
		setup();
		generateMap();
		drawMap();
	}
	private void drawMap() {
		int y = 0;
		for(String[] r: tiles) {
			int x =0;
			for(String t: r) {
				drawTile(t,x,y);
				x += 40;
			}
			y+=40;
		}
	}
	public static void main(String [] args) {
		SimpleMap map = new SimpleMap();
	}
}
