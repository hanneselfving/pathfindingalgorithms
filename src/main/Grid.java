package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javax.swing.tree.DefaultTreeModel;



public class Grid {
	
	int gridX = 1280/State.SIZE;
	int gridY = 720/State.SIZE;
	
	State grid[][] = new State[gridY][gridX];
	
	State goalState;
	State startState;
	
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1280, 720);
		for(int i=0; i<gridX;i++) {
			for(int i2=0; i2<gridY; i2++) {
				if(grid[i2][i].x == goalState.x && grid[i2][i].y == goalState.y) {
					grid[i2][i].draw(g, Color.YELLOW); }
				else if(grid[i2][i].x == startState.x && grid[i2][i].y == startState.y ) {
					grid[i2][i].draw(g, Color.BLUE); }
				else if(grid[i2][i].front == true) {
					grid[i2][i].draw(g, Color.GRAY); 
				}
				else if(grid[i2][i].reached == true) {
					grid[i2][i].draw(g, Color.LIGHT_GRAY); 
				}
				else{
					grid[i2][i].draw(g, Color.DARK_GRAY); 
					}
			}		
		}
	}
	
	public void generateGrid() {
		int stateX=0, stateY=0;
		for(int i=0; i<gridX;i++) {
			for(int i2=0; i2<gridY; i2++) {
				grid[i2][i] = new State(i * State.SIZE, i2 * State.SIZE);
			}
			stateX++;
			stateY=0;
		}
		
		startState = grid[14][4];
		goalState = grid[14][50];
		
	}
	
	public void generateMaze() {
		
		grid[goalState.arrY - 3][goalState.arrX].isObstacle = true;
		grid[goalState.arrY - 3][goalState.arrX + 1].isObstacle = true;
		grid[goalState.arrY - 3][goalState.arrX + 2].isObstacle = true;
		grid[goalState.arrY - 3][goalState.arrX + 3].isObstacle = true;
		grid[goalState.arrY - 3][goalState.arrX - 1].isObstacle = true;
		grid[goalState.arrY - 3][goalState.arrX - 2].isObstacle = true;
		grid[goalState.arrY - 3][goalState.arrX - 3].isObstacle = true;
		
		grid[goalState.arrY + 3][goalState.arrX].isObstacle = true;
		grid[goalState.arrY + 3][goalState.arrX + 1].isObstacle = true;
		grid[goalState.arrY + 3][goalState.arrX + 2].isObstacle = true;
		grid[goalState.arrY + 3][goalState.arrX + 3].isObstacle = true;
		grid[goalState.arrY + 3][goalState.arrX - 1].isObstacle = true;
		grid[goalState.arrY + 3][goalState.arrX - 2].isObstacle = true;
		grid[goalState.arrY + 3][goalState.arrX - 3].isObstacle = true;
		grid[goalState.arrY + 3][goalState.arrX - 4].isObstacle = true;
		grid[goalState.arrY + 3][goalState.arrX - 5].isObstacle = true;
		grid[goalState.arrY + 3][goalState.arrX - 6].isObstacle = true;
		grid[goalState.arrY + 3][goalState.arrX - 7].isObstacle = true;
		
		grid[goalState.arrY + 5][goalState.arrX - 7].isObstacle = true;
		grid[goalState.arrY + 4][goalState.arrX - 7].isObstacle = true;
		grid[goalState.arrY + 3][goalState.arrX - 7].isObstacle = true;
		grid[goalState.arrY + 2][goalState.arrX - 7].isObstacle = true;
		grid[goalState.arrY + 1][goalState.arrX - 7].isObstacle = true;
		grid[goalState.arrY][goalState.arrX- 7].isObstacle = true;
		grid[goalState.arrY - 1][goalState.arrX - 7].isObstacle = true;
		grid[goalState.arrY - 2][goalState.arrX - 7].isObstacle = true;
		grid[goalState.arrY - 3][goalState.arrX - 7].isObstacle = true;
		grid[goalState.arrY - 4][goalState.arrX - 7].isObstacle = true;
		grid[goalState.arrY - 5][goalState.arrX - 7].isObstacle = true;
		grid[goalState.arrY - 6][goalState.arrX - 7].isObstacle = true;
		grid[goalState.arrY - 7][goalState.arrX - 7].isObstacle = true;
		grid[goalState.arrY - 8][goalState.arrX - 7].isObstacle = true;
		grid[goalState.arrY - 9][goalState.arrX - 7].isObstacle = true;
		
	}
	
	public void generateObstacle() {
		
		grid[goalState.arrY + 5][goalState.arrX - 3].isObstacle = true;
		grid[goalState.arrY + 4][goalState.arrX - 3].isObstacle = true;
		grid[goalState.arrY + 3][goalState.arrX - 3].isObstacle = true;
		grid[goalState.arrY + 2][goalState.arrX - 3].isObstacle = true;
		grid[goalState.arrY + 1][goalState.arrX - 3].isObstacle = true;
		grid[goalState.arrY][goalState.arrX- 3].isObstacle = true;
		grid[goalState.arrY - 1][goalState.arrX - 3].isObstacle = true;
		grid[goalState.arrY - 2][goalState.arrX - 3].isObstacle = true;
		grid[goalState.arrY - 3][goalState.arrX - 3].isObstacle = true;
		grid[goalState.arrY - 4][goalState.arrX - 3].isObstacle = true;
		grid[goalState.arrY - 5][goalState.arrX - 3].isObstacle = true;

		
	}
	
	public boolean isGoal(State state) {
		if(state == this.goalState)
			return true;
		else return false;
	}
	
	
	
}
