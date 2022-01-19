package main;

import java.util.List;

import javax.swing.SwingWorker;

public abstract class Search {
	
	Grid grid;
	Panel panel;
	
	Node n;
	
	Search(Grid grid, Panel panel) {
		this.grid = grid;
		this.panel = panel;
	}
	
	public abstract void execute();
	
	public abstract List<Node> expand(Node n, Grid grid);
	
	
}
