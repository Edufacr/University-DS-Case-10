package View;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import naryTree.NaryTreeNode;
import model.Sensor;
import View.NodeButton;
import controller.SensorDisplayController;
import model.IConstants;

public class GUI implements IConstants{
	//Controller
	SensorDisplayController controller;
	
	private JFrame frame;
	private JTextField searchBar;
	private JButton searchButton;
	private JButton addButton;
	private JButton removeButton;
	private NaryTreeNode<Sensor> selectedNode;
	private ArrayList<NodeButton> sensors;
	
	
	public GUI() {
		controller = new SensorDisplayController();
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
				
				for (NaryTreeNode<Sensor> node : controller.search(searched)) {
					JFrame popFrame = new JFrame(node.getValue().getName());
					JLabel labelDir = new JLabel("Cantón: " + node.getValue().getLocation()[0] + "  Distrito: " + node.getValue().getLocation()[1] + "  Barrio: " + node.getValue().getLocation()[2]);
					JLabel labelConsumo = new JLabel("Consumo: " + node.getValue().getIntake());
					JLabel labelFather = new JLabel("Padre: " + node.getFather());
					JLabel labelSons = new JLabel("Hijos: " + node.getChildrenList());
					
					labelDir.setBounds(10, 10, 500, 40);
					labelConsumo.setBounds(10, 60, 100, 40);
					labelFather.setBounds(10, 110, 100, 40);
					labelSons.setBounds(10, 150, 1000, 40);
					
					popFrame.add(labelDir);
					popFrame.add(labelConsumo);
					popFrame.add(labelFather);
					popFrame.add(labelSons);
					
					popFrame.setSize(SCREEN_WIDTH/2,SCREEN_HEIGHT/2);
					popFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					popFrame.setLayout(null);  
					popFrame.setVisible(true); 
					
					
//					System.out.println("Cantón: " + node.getValue().getLocation()[0] + "\nDistrito: " + node.getValue().getLocation()[1] + "\nBarrio: " + node.getValue().getLocation()[2]);
//					System.out.println("Consumo: " + node.getValue().getIntake());
//					System.out.println("Padre: " + node.getFather());
//					System.out.println("Hijos: " + node.getChildrenList());
				}
		    }
		};
		return act;
	}
	
	public ActionListener addSensor() {
		ActionListener act = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
			    	
			    	controller.Add(selectedNode, Integer.valueOf(consumo), canton, distrito, barrio);
			    	// Call function to repaint tree
			    }
			  }
			
		};
		return act;
	}
	
	
	public ActionListener removeSensor() {
		
		ActionListener act = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Remove(selectedNode);
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
