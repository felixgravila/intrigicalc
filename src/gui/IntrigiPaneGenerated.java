package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import Service.DB;
import Service.Service;
import model.Intriga;
import model.Person;


public class IntrigiPaneGenerated extends JFrame
{

    public IntrigiPaneGenerated()
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
    JLabel lbl = new JLabel(" <->");
    

    private void initContent()
    {
    	getContentPane().add(jspIntrigi);
    	jspIntrigi.setBounds(20,20,260,290);
    	
    	getContentPane().add(btnDelete);
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
    	
        getContentPane().add(btnAdd);
        btnAdd.setText("Add Intriga");
        btnAdd.setBounds(50, 394, 200, 25);
        btnAdd.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				addIntrigaMethod();
			}
		});
        
        getContentPane().add(cbp1);
        getContentPane().add(cbp2);
        
        for(Person p:DB.getInstance().getPersons()){
        	cbp1.addItem(p);
        	cbp2.addItem(p);
        }
        
        cbp1.setBounds(10, 358, 115, 25);
        cbp2.setBounds(170, 358, 115, 25);
        
        getContentPane().add(lbl);
        lbl.setBounds(135,358,30,25);
        
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
