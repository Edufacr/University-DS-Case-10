package view;

import javax.swing.*;
import java.awt.event.*;
import naryTree.NaryTreeNode;
import model.Sensor;
import view.GUI;


public class NodeButton extends JButton{
	
	private NaryTreeNode<Sensor> contents;
	private ActionListener buttonAction;
	private static GUI father;

	public NodeButton(NaryTreeNode<Sensor> pContents, GUI pFather) {
		super(pContents.getValue().getName());
		this.contents = pContents;
		father = pFather;
		
		buttonAction = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				@SuppressWarnings("unchecked")
				NaryTreeNode<Sensor> source = (NaryTreeNode<Sensor>) e.getSource();
		        father.setSelectedNode(source);
		    }
		};
		this.addActionListener(buttonAction);
	}
	
	public NaryTreeNode<Sensor> getContents(){
		return this.contents;
	}
	
	public void setContents(NaryTreeNode<Sensor> pNode) {
		this.contents = pNode;
	}
}
