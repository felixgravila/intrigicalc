package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class AnotherGUI
{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main ( String [ ] args )
	{
		EventQueue.invokeLater ( new Runnable ( )
		{

			public void run ( )
			{
				try
				{
					AnotherGUI window = new AnotherGUI ( );
					window.frame.setVisible ( true );
				}
				catch ( Exception e )
				{
					e.printStackTrace ( );
				}
			}
		} );
	}

	/**
	 * Create the application.
	 */
	public AnotherGUI ( )
	{
		initialize ( );
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize ( )
	{
		frame = new JFrame ( );
		frame.setBounds ( 100 , 100 , 820 , 450 );
		frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
		frame.getContentPane().setLayout(null);
		
		final DefaultListModel<String> lmPersons = new DefaultListModel<String>();
		final JList<String> jlPersons = new JList<String>(lmPersons);
		final JScrollPane scrollPane = new JScrollPane(jlPersons);
		scrollPane.setBounds(36, 42, 215, 246);
		frame.getContentPane().add(scrollPane);
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(173, 299, 89, 23);
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener ( new ActionListener ( )
		{
			public void actionPerformed ( ActionEvent event )
			{
			     	lmPersons.addElement (  textField.getText ( )  );
			}
		});
		
		textField = new JTextField();
		textField.setBounds(77, 300, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(36, 303, 46, 14);
		frame.getContentPane().add(lblName);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(173, 333, 89, 23);
		frame.getContentPane().add(btnRemove);
		btnRemove.addActionListener ( new ActionListener ( )
		{
			public void actionPerformed ( ActionEvent event )
			{
				lmPersons.remove ( jlPersons.getSelectedIndex ( ) );
			}
		});
		
		JLabel lblPeople = new JLabel("People");
		lblPeople.setBounds(36, 11, 46, 14);
		frame.getContentPane().add(lblPeople);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.setBounds(296, 333, 89, 23);
		frame.getContentPane().add(btnAdd_1);
		
		JButton btnRemove_1 = new JButton("Remove");
		btnRemove_1.setBounds(425, 333, 89, 23);
		frame.getContentPane().add(btnRemove_1);
		
		JLabel label = new JLabel("<->");
		label.setBounds(392, 303, 46, 14);
		frame.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(296, 300, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(425, 300, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		//list for intrigi code
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(296, 42, 215, 246);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JLabel lblIntrigi = new JLabel("Intrigi");
		lblIntrigi.setBounds(296, 11, 46, 14);
		frame.getContentPane().add(lblIntrigi);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(567, 42, 215, 246);
		frame.getContentPane().add(scrollPane_2);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(567, 11, 46, 14);
		frame.getContentPane().add(lblResult);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(693, 299, 89, 23);
		frame.getContentPane().add(btnRefresh);
	}
}
