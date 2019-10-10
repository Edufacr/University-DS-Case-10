package view;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import naryTree.NaryTreeNode;
import model.Sensor;
import view.NodeButton;
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
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				
//				String canton = JOptionPane.showInputDialog(frame, "Cantón: ", null); 
//				String distrito = JOptionPane.showInputDialog(frame, "Distrito: ", null); 
				
			    JTextField fCanton = new JTextField(15);
			    JTextField fDistrito = new JTextField(15);
			    JTextField fBarrio = new JTextField(15);
			    JTextField fConsumo = new JTextField(8);

			    JPanel myPanel = new JPanel();
			    myPanel.add(new JLabel("Cantón:"));
			    myPanel.add(fCanton);
			    //myPanel.add(Box.createVerticalStrut(40)); // a spacer
			    myPanel.add(new JLabel("Distrito:"));
			    myPanel.add(fDistrito);
			    myPanel.add(new JLabel("Barrio:"));
			    myPanel.add(fBarrio);
			    myPanel.add(new JLabel("Consumo:"));
			    myPanel.add(fConsumo);

			    int result = JOptionPane.showConfirmDialog(null, myPanel,
			        "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
			    
			    if (result == JOptionPane.OK_OPTION) {
			    	String canton = fCanton.getText();
			    	String distrito = fDistrito.getText();
			    	String barrio = fBarrio.getText();
			    	String consumo = fConsumo.getText();
			    }

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
