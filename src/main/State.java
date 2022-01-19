package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.color.ColorSpace;

public class State {

	int x;
	int y;
	static final int SIZE = 20;
	boolean isPath = false;
	public int arrX;
	public int arrY;
	public int pCost = 0; //path cost from goal
	boolean isObstacle = false;
	

	public boolean front = false;
	public boolean reached = true;
	
	public State(int x, int y) {
		this.x = x;
		this.y = y;
		this.arrX = x/SIZE;
		this.arrY = y/SIZE;
	}
	
	public void draw(Graphics g, Color c) {
		if(isPath) {
			c = Color.green;
		}
		if(isObstacle) {
			c = Color.orange;
		}
		g.setColor(c);
		g.fillRect(x, y, SIZE, SIZE);
		g.setColor(c.darker());
		g.drawRect(x, y, SIZE, SIZE);
		

		if(pCost != 0) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 10)); 
			g.setColor(Color.BLACK);
			g.drawString(""+pCost, this.x + 8, this.y + 16);
		}
			
		
			
	}
	
	public int getPathCost() {
		return pCost;
	}
	
	
	
}
