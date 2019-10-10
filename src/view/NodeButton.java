package View;

import javax.swing.*;
import java.awt.event.*;
import naryTree.NaryTreeNode;
import model.Sensor;
import View.GUI;


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
				NodeButton source = (NodeButton) e.getSource();
		        father.setSelectedNode(source.getContents());
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
