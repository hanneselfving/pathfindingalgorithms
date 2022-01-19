package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.SwingWorker;

public class BestFirstSearch extends Search {
	
	public BestFirstSearch(Grid grid, Panel panel) {
		super(grid,panel);
	}
	
	@Override
	public void execute() {	
		
		SwingWorker worker = new SwingWorker() {
					
			@Override
			protected Void doInBackground() throws Exception {
				boolean retGoal = false;
				Queue<Node> front = new LinkedList<Node>();
				Hashtable<State,Node> reached = new Hashtable<State,Node>();				
				State s;
				Node goal = null;
				n = new Node(grid.startState, null);
				int pCost = 0;
				n.pathCost = pCost;
				front.add(n);
				reached.put(n.state, n);
				n.state.front=true;
				panel.repaint();
				
				
				
				
				while(!front.isEmpty()) {
					Thread.sleep(Main.delay);
					n.state.front=false;
					n=front.poll();
					if(grid.isGoal(n.state)) {
						goal = n;
						break;
					}
					panel.repaint();
					pCost=n.state.pCost+1; //for visual purposes. Steps from goal
					for (Node child : expand(n, grid)) {
						s = child.state;
						if((!reached.containsKey(s)) && !s.isObstacle) {
							s.reached = true;
							s.front = true;
							s.pCost = pCost; //steps from goal
							reached.put(s, child);
							front.add(child);	
							panel.repaint();
						}				
					}
					
				}
				
				if(goal != null) {
					Node n = goal.parent;
					while(n.parent != null) {
						n.state.isPath=true;
						Thread.sleep(Main.delay);
						panel.repaint();
						n = n.parent;			
					}	
				}
				
				panel.repaint();
					
				return null;
			}
			
			
		};
		worker.execute();

	}
	
	@Override
	public List<Node> expand(Node n, Grid grid) {
		// TODO Auto-generated method stub
		
		List<Node> list = new LinkedList<Node>();
		if(n.state.arrY-1 >= 0) {
			list.add(new Node(grid.grid[n.state.arrY - 1][n.state.arrX], n));
		}
		if(n.state.arrY+1 < grid.grid.length) {
			list.add(new Node(grid.grid[n.state.arrY + 1][n.state.arrX], n));
		}
		if(n.state.arrX-1 >= 0) {
			list.add(new Node(grid.grid[n.state.arrY][n.state.arrX-1], n));
		}
		if(n.state.arrX+1 < grid.grid[n.state.arrY].length) {
			list.add(new Node(grid.grid[n.state.arrY][n.state.arrX+1], n));
		}
		return list;
				
	}
	

	
	
	
	
	
}
