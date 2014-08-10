package gui;

import java.awt.Graphics;
import java.awt.Paint;

import javax.print.attribute.standard.JobName;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Service.DB;
import Service.Service;
import model.Person;

public class Map extends JComponent{
	
	public Map() {
		Person arr[] = Service.getInstance().getTheThing();
	    if(arr!=null){
	    for(int i=1;i<=DB.getInstance().getPersons().size();i++)
	    	System.out.println(""+i+" "+arr[i]);
	    }
	}
	
	@Override
	public void paint(Graphics g) {
	    g.drawOval(20, 20, 250, 250);
	    

	  }
	
}
