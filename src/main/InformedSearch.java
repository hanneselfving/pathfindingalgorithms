package main;

import java.util.List;

public abstract class InformedSearch extends Search {

	InformedSearch(Grid grid, Panel panel) {
		super(grid, panel);

	}

	abstract int evaluate(Node n);
	
	abstract int heuristic(State a, State b);
	
	
}
