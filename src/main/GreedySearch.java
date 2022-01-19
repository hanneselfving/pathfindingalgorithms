package main;

import java.awt.Graphics;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.SwingWorker;

public class GreedySearch extends InformedSearch{

	public GreedySearch(Grid grid, Panel panel) {
		super(grid,panel);
	}
	
	public void execute() {	
		
		SwingWorker worker = new SwingWorker() {
					
			@Override
			protected Void doInBackground() throws Exception {
				boolean retGoal = false;
			
				PriorityQueue<Node> front = new PriorityQueue<Node>(30, new Comparator<Node>() {
					// override compare method
					public int compare(Node i, Node j) {
						if (evaluate(i) > evaluate(j)) {
							return 1;
						}

						else if (evaluate(i) < evaluate(j)) {
							return -1;
						}

						else {
							return 0;
						}
					}

				});
				
				Hashtable<State,Node> reached = new Hashtable<State,Node>();				
				State s;
				Node goal = null;
				n = new Node(grid.startState, null);
				int pCost = 0;
				n.state.pCost = pCost;
				front.add(n);
				reached.put(n.state, n);
				n.state.front=true;
				panel.repaint();
				
				
				
				
				while(!front.isEmpty()) {
					Thread.sleep(Main.delay);
					n.state.front=false;
					n=front.poll();
					pCost=n.state.pCost+1;
					if(grid.isGoal(n.state)) {
						goal = n;
						break;
					}
					
					
					for (Node child : expand(n, grid)) {
						s = child.state;
						if((!reached.containsKey(s)) && !s.isObstacle) {
							s.reached = true;
							s.front = true;
							
							s.pCost = pCost;
							child.parent = n;
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
	
	int evaluate(Node n) {
		
		int i=heuristic(n.state, grid.goalState);
		return i;
	}
	
	int heuristic(State a, State b) {
		
		int aSide = Math.abs(a.arrX - b.arrX);
		int bSide = Math.abs(a.arrY - b.arrY);
		
		return (int) Math.sqrt(Math.pow(aSide, 2) + Math.pow(bSide, 2));
	}
	
	
}
