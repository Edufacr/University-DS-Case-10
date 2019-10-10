package View;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import naryTree.NaryTreeNode;
import model.Sensor;
import View.NodeButton;
import model.IConstants;

public class GUI implements IConstants{
	
	private JFrame frame;
	private JTextField searchBar;
	private JButton searchButton;
	private JButton addButton;
	private JButton removeButton;
	private NaryTreeNode<Sensor> selectedNode;
	private ArrayList<NodeButton> sensors;
	
	
	public GUI() {
		this.frame =new JFrame("Caso 10 - Eduardo y Gabriel");
		this.searchBar = new JTextField("Search...");
		searchBar.setBounds(50, SCREEN_HEIGHT - 100, 200, 20);
	      
	    
	    searchButton = new JButton("Search");  
	    searchButton.setBounds(270, SCREEN_HEIGHT - 100, 95, 20);  
	    searchButton.addActionListener(this.searchFunction());
	    
	    addButton = new JButton("+");
	    addButton.setBounds(SCREEN_WIDTH - 100, SCREEN_HEIGHT - 100, 40, 40);
	    addButton.addActionListener(this.addSensor());
	    
	    
	    removeButton = new JButton("-");
	    removeButton.setBounds(SCREEN_WIDTH - 160, SCREEN_HEIGHT - 100, 40, 40);
	    removeButton.addActionListener(this.removeSensor());
	    
	    
	    
	    
	    
	    
	    frame.add(this.searchButton);
	    frame.add(this.searchBar);
	    frame.add(this.addButton);
	    frame.add(this.removeButton);
	    frame.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);  
	    frame.setLayout(null);  
	    frame.setVisible(true); 
	    
	}
	
	public ActionListener searchFunction() {
		ActionListener act = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				String searched = searchBar.getText();
				
				// verificar igualdad de búsqueda con splay
				
		    }
		};
		return act;
	}
	
	public ActionListener addSensor() {
		ActionListener act = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
			
		};
		return act;
	}
	
	
	public ActionListener removeSensor() {
		
		ActionListener act = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		};
		
		return act;
	}
	
	
	
	public void setSelectedNode(NaryTreeNode<Sensor> pSelected) {
		this.selectedNode = pSelected; 
	}
	
	
	
	public static void main(String[] args) {  
		
		GUI gui = new GUI();
		
	    
	    
	}  
}
