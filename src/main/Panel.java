package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel extends JPanel {

	public Grid grid = new Grid();
	JButton execBtn = new JButton("Go");
	BestFirstSearch bfs = new BestFirstSearch(grid, this);
	DepthFirstSearch dfs = new DepthFirstSearch(grid, this);
	GreedySearch gs = new GreedySearch(grid, this);
	AStarSearch ass = new AStarSearch(grid, this);
	WeightedAStarSearch wass = new WeightedAStarSearch(grid, this);
	//Node goal = null;
	
	Panel(int w, int h) {
		
		this.setPreferredSize(new Dimension(w, h));
		this.setFocusable(true);
		this.grabFocus();
		grid.generateGrid();
		execBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(Main.selection.getSelectedIndex() == 0) {
				System.out.println("Executing bfs");
				bfs.execute();
				}
				else if(Main.selection.getSelectedIndex() == 1) {
					System.out.println("Executing gs");
					gs.execute();
					}
				
				else if(Main.selection.getSelectedIndex() == 2) {
					System.out.println("Executing star");
					ass.execute();
				}
				else if(Main.selection.getSelectedIndex() == 3) {
					System.out.println("Executing wass");
					wass.execute();
				}
			}
		});
		this.add(execBtn);
		
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if(Main.drawState == 1) {
					if(grid.grid[e.getY()/State.SIZE][e.getX()/State.SIZE].isObstacle == false) {
					grid.grid[e.getY()/State.SIZE][e.getX()/State.SIZE].isObstacle = true;
					}
					repaint();
				}		
			}
			
		});
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(Main.drawState == 2) {
					grid.startState = grid.grid[e.getY()/State.SIZE][e.getX()/State.SIZE];
					Main.drawState = 0;
				}
				else if(Main.drawState == 3) {
					grid.goalState = grid.grid[e.getY()/State.SIZE][e.getX()/State.SIZE];
					Main.drawState = 0;
					
				}
				repaint();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		grid.draw(g);
		
		
		
		
	}
	
	
	
	
	
}
