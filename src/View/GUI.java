package View;

import javax.swing.*;
import java.awt.event.*;

public class GUI {
	
	private JFrame frame;
	private JTextField searchBar;
	
	public GUI() {
		this.frame =new JFrame("Caso 10 - Eduardo y Gabriel");
		this.searchBar = new JTextField("Search...");
		searchBar.setBounds(50,50, 150,20);
	      
	    
	    JButton button =new JButton("Click Here");  
	    button.setBounds(50,100,95,30);  
	    button.addActionListener(this.getActionListener(this.searchBar));
	    
	    frame.add(button);
	    frame.add(this.searchBar);
	    frame.setSize(600,600);  
	    frame.setLayout(null);  
	    frame.setVisible(true); 
	    
	}
	
	public ActionListener getActionListener(JTextField pTextField) {
		ActionListener act = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
		        System.out.println(pTextField.getText());  
		    }
		};
		return act;
	}
	
	
	public static void main(String[] args) {  
		
		GUI gui = new GUI();
		
	    
	    
	}  
}
