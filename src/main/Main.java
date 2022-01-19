package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame {
	
	JPanel top = new JPanel();
	Panel panel = new Panel(1280,720);
	
	JButton obstacleBtn = new JButton("Obstacle");
	JButton startBtn = new JButton("Start");
	JButton goalBtn = new JButton("Goal");
	JButton resetBtn = new JButton("Reset");
	JButton mazeBtn = new JButton("Maze");
	
	static String[] selNames = { "Breadth-first Search", "Greedy Search", "A* Search", "Weighted A* Search"};
	public static JComboBox selection = new JComboBox(selNames);
	
	public static int drawState = 0; // 0 = no draw, 1 draw obstacle, 2 set start, 3 set goal
	public static int delay = 5;
	
	
	JLabel label = new JLabel("Drawing: Nothing" );
	
	
	
	Main() {
		
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(panel);
		top.add(selection);
		top.add(mazeBtn);
		top.add(obstacleBtn);
		top.add(startBtn);
		top.add(goalBtn);
		top.add(resetBtn);
		top.add(label);
		this.add(top, BorderLayout.NORTH);
		pack();
		
		mazeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.grid.generateMaze();
				panel.repaint();
				
			}
		});
		
		obstacleBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				drawState = 1;
				label.setText("Obstacles");
				panel.grid.generateObstacle();
				panel.repaint();
			}
		});
		
		startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				drawState = 2;
				label.setText("Start State");
				
			}
		});
		
		goalBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				drawState = 3;
				label.setText("Goal State");
				
			}
		});	
		
		resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.grid.generateGrid();
				repaint();
				
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		
		new Main();
		
		
		
	}
	

}
