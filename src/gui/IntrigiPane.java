package gui;

import java.awt.Dimension;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.KeyFactory;
import java.util.Date;

import javax.crypto.KeyGenerator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;

import model.Intriga;
import model.Person;
import Service.DB;
import Service.Service;

public class IntrigiPane extends JFrame
{

    public IntrigiPane()
    {
        this.setTitle("Intrigi");
        this.getContentPane().setPreferredSize(new Dimension(300, 430));
        this.getContentPane().setLayout(null);
        this.initContent();
        this.setVisible(true);
        this.pack();
    }

    //-------------------------------------------------------------------------

    private JButton btnAdd = new JButton();
    private JButton btnDelete = new JButton();
    private DefaultListModel<Intriga> lmIntrigi = new DefaultListModel<Intriga>();
    private JList jlIntrigi = new JList(lmIntrigi);
    private JScrollPane jspIntrigi = new JScrollPane(jlIntrigi);
    
    JComboBox<Person> cbp1 = new JComboBox<Person>();
    JComboBox<Person> cbp2 = new JComboBox<Person>();
    JLabel lbl = new JLabel("<->");
    

    private void initContent()
    {
    	this.add(jspIntrigi);
    	jspIntrigi.setBounds(20,20,260,290);
    	
    	this.add(btnDelete);
    	btnDelete.setText("Delete Intriga");
    	btnDelete.setBounds(50,320,200,25);
    	btnDelete.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jlIntrigi.getSelectedValue()!=null){
					DB.getInstance().getIntrigi().remove(jlIntrigi.getSelectedValue());
					refresh();
				}
			}
		});
    	
        this.add(btnAdd);
        btnAdd.setText("Add Intriga");
        btnAdd.setBounds(50, 380, 200, 25);
        btnAdd.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				addIntrigaMethod();
			}
		});
        
        this.add(cbp1);
        this.add(cbp2);
        
        for(Person p:DB.getInstance().getPersons()){
        	cbp1.addItem(p);
        	cbp2.addItem(p);
        }
        
        cbp1.setBounds(20, 345, 115, 25);
        cbp2.setBounds(165, 345, 115, 25);
        
        this.add(lbl);
        lbl.setBounds(135,345,30,25);
        
        refresh();
       
    }
    
    private boolean addIntrigaMethod(){
    	Person p1 = cbp1.getItemAt(cbp1.getSelectedIndex());
    	Person p2 = cbp2.getItemAt(cbp2.getSelectedIndex());
    	if(!p1.getName().equals(p2.getName())){
    		if(!Service.getInstance().existsIntriga(p1, p2)){
    			Intriga i = new Intriga(p1, p2);
    			DB.getInstance().getIntrigi().add(i);
    			refresh();
    		}
    	}
    	return true;
    }
        
    
    private void refresh(){
    	lmIntrigi.clear();
    	for(Intriga i:DB.getInstance().getIntrigi())
    		lmIntrigi.addElement(i);
    }
}