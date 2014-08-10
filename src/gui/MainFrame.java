package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;

import Service.DB;

public class MainFrame extends JFrame
{
    public static void main(String[] args)
    {
        JFrame frame = new MainFrame();
        frame.pack();
        frame.setVisible(true);
    }

    public MainFrame()
    {
        this.setTitle("Intrigi manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setPreferredSize(new Dimension(240, 210));
        this.getContentPane().setLayout(null);

        this.initContent();
    }

    //-------------------------------------------------------------------------

    private JButton btnPersons = new JButton();
    private JButton btnIntrigi = new JButton();
    private JButton btnCalc = new JButton();
    buttonListener btnL = new buttonListener();

    private void initContent()
    {
        this.add(btnPersons);
        btnPersons.setText("Add Person");
        btnPersons.setBounds(20, 20, 200, 50);
        

        this.add(btnIntrigi);
        btnIntrigi.setText("Add intrigi");
        btnIntrigi.setBounds(20, 80, 200, 50);

        this.add(btnCalc);
        btnCalc.setText("Arrange table");
        btnCalc.setBounds(20, 140, 200, 50);
        
        btnPersons.addActionListener(btnL);
        btnIntrigi.addActionListener(btnL);
        btnCalc.addActionListener(btnL);
    }
    
    private class buttonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnPersons)
				openPersonPane();
			if(e.getSource()==btnIntrigi)
				openIntrigiPane();
			if(e.getSource()==btnCalc)
				openMapPane();
		}
    	
    }
    
    private void openPersonPane(){
    	PersonsPane p = new PersonsPane();
    	p.setBounds(30, 30, 300, 430);
    }
    
    private void openIntrigiPane(){
    	IntrigiPane i = new IntrigiPane();
    	i.setBounds(30, 30, 300, 435);
    }

    private void openMapPane(){
    	JFrame window = new JFrame();
	    window.setBounds(30, 30, 300, 300);
	    window.getContentPane().add(new Map());
	    window.setVisible(true);
	    JButton b = new JButton("Press for next");
		window.add(b);
		b.setVisible(true);
		b.setLocation(20, 20);
		b.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("next requested");
			}
		});
    }
}