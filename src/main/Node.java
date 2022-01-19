package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

public class Node {
		
	
	//up, right, down, left
	//Node[] node;
	Node parent;
	int pathCost; //path cost from goal
	State state;
	
	
	Node(State state, Node parent) {
		
	
		this.state = state;
		this.parent = parent;
		
	}
	
	public void draw(Graphics g) {
			
			
		
		}
	
	public int getPathCost() { //immidiate pathcost i.e. 1 in grid
		return state.getPathCost();
		
	}
	
}
