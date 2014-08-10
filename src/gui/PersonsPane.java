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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;

import model.Person;
import Service.DB;

public class PersonsPane extends JFrame
{

    public PersonsPane()
    {
        this.setTitle("People");
        this.getContentPane().setPreferredSize(new Dimension(300, 400));
        this.getContentPane().setLayout(null);
        this.initContent();
        this.setVisible(true);
        this.pack();
    }

    //-------------------------------------------------------------------------

    private JButton btnAdd = new JButton();
    private JButton btnDelete = new JButton();
    private JTextField txfPerson = new JTextField();
    private DefaultListModel<Person> lmPersons = new DefaultListModel<Person>();
    private JList jlPersons = new JList(lmPersons);
    private JScrollPane jspPersons = new JScrollPane(jlPersons);
    

    private void initContent()
    {
    	this.add(jspPersons);
    	jspPersons.setBounds(20,20,260,290);
    	
    	this.add(btnDelete);
    	btnDelete.setText("Delete Person");
    	btnDelete.setBounds(50,320,200,25);
    	btnDelete.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jlPersons.getSelectedValue()!=null){
					DB.getInstance().getPersons().remove(jlPersons.getSelectedValue());
					refresh();
				}
			}
		});
    	
        this.add(btnAdd);
        btnAdd.setText("Add Person");
        btnAdd.setBounds(180, 360, 100, 25);
        btnAdd.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				addPersonMethod();
			}
		});
        
        this.add(txfPerson);
        txfPerson.setBounds(20, 360, 155, 25);
        refresh();
    }
    
    private void addPersonMethod(){
    	if(!txfPerson.getText().toString().equals("")){
			Person p = new Person(txfPerson.getText().toString());
			DB.getInstance().getPersons().add(p);
			refresh();
			txfPerson.setText("");
			txfPerson.requestFocus();
		}
    }
    
    private void refresh(){
    	lmPersons.clear();
    	for(Person p:DB.getInstance().getPersons())
    		lmPersons.addElement(p);
    	txfPerson.requestFocus();
    }
}