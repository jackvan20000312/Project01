package edu.mtc.egr283.project05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * @author Jacob Vaught
 *
 */
public class ShoppingListGUIDriver extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	/**
	 * main method
	 */
	public static void main( String args[] ) {
		new ShoppingListGUIDriver(); 	
	}//ending bracket of main method

	ShoppingList shopper = new ShoppingList();
	File inputFile=null, outputFile=null;
	JTextArea mainTextArea = null;
	JTextField addItemAtPosition_Name_JTextField = null, addItemAtPosition_Position_JTextField = null, removeItem_Name_JTextField = null, addItemNameAtEndOfListJTextField = null;
	JCheckBox displayListJCheckBox = null;
	JButton addItemAtEndJButton = null, removeItemJButton = null, addItemAtPositionJButton = null;
	JLabel removeItemJLabel = null, addAtPosition_Position_JLabel = null, addAtPosition_Name_JLabel = null, addAtEndJLabel = null, completionMessageJLabel=null, dataJLabel = null, spacer1ItemJLabel=null, spacer2ItemJLabel=null;
	JFrame jFrame = new JFrame("Shopping List GUI");
	JMenuBar menuBar = null;
	JMenu fileMenu = null;
	JMenuItem outputMenuItem = null, inputMenuItem = null, about=null;
	JFileChooser fileChooser=new JFileChooser();    

	/**
	 * Constructor
	 */
	public ShoppingListGUIDriver() {

		this.inputMenuItem = new JMenuItem("Select Shopping List");
		this.inputMenuItem.addActionListener(this); 
		this.outputMenuItem = new JMenuItem("Select Output File");
		this.outputMenuItem.addActionListener(this); 
		this.about = new JMenuItem("About");
		this.about.addActionListener(this); 

		this.fileMenu = new JMenu("File");    
		this.fileMenu.add(inputMenuItem);
		this.fileMenu.add(outputMenuItem);
		this.fileMenu.add(about);
		this.menuBar = new JMenuBar();  
		this.menuBar.add(fileMenu);              


		this.mainTextArea = new JTextArea();
		this.mainTextArea.setBounds( 400, 25, 400, 500 );
		this.mainTextArea.setText( "Shopping List" );
		this.mainTextArea.setEditable(false);
		this.mainTextArea.setToolTipText( "Shopping List Text Area" );
		this.mainTextArea.setVisible( true );
		this.mainTextArea.setOpaque( true );

		this.addItemAtPosition_Name_JTextField = new JTextField();
		this.addItemAtPosition_Name_JTextField.setBounds( 100, 45, 80, 30 );
		this.addItemAtPosition_Name_JTextField.setToolTipText( "Item Name" );
		this.addItemAtPosition_Name_JTextField.setOpaque( true );

		this.addItemAtPosition_Position_JTextField = new JTextField();
		this.addItemAtPosition_Position_JTextField.setBounds( 100, 80, 80, 30 );
		this.addItemAtPosition_Position_JTextField.setToolTipText( "Item Location on List" );
		this.addItemAtPosition_Position_JTextField.setVisible( true );
		this.addItemAtPosition_Position_JTextField.setOpaque( true );

		this.displayListJCheckBox = new JCheckBox();
		this.displayListJCheckBox.setBounds( 6, 160, 100, 20 );
		this.displayListJCheckBox.setText( "Display List" );
		this.displayListJCheckBox.setToolTipText( "Display Shopping List" );
		this.displayListJCheckBox.setBorderPaintedFlat( true );
		this.displayListJCheckBox.setVisible( true );
		this.displayListJCheckBox.setOpaque( true );
		this.displayListJCheckBox.addActionListener( this );

		this.removeItem_Name_JTextField = new JTextField();
		this.removeItem_Name_JTextField.setBounds( 100, 120, 80, 30 );
		this.removeItem_Name_JTextField.setToolTipText( "Enter Item name To be Deleted." );

		this.addItemNameAtEndOfListJTextField = new JTextField();
		this.addItemNameAtEndOfListJTextField.setBounds( 100, 5, 80, 30 );
		this.addItemNameAtEndOfListJTextField.setToolTipText( "Item Name" );
		this.addItemNameAtEndOfListJTextField.setVisible( true );
		this.addItemNameAtEndOfListJTextField.setOpaque( true );

		this.addItemAtEndJButton = new JButton();
		this.addItemAtEndJButton.setBounds( 190, 5, 200, 30 );
		this.addItemAtEndJButton.setText( "Add Item At End Of List" );
		this.addItemAtEndJButton.setToolTipText( "Add Item At End Of List" );
		this.addItemAtEndJButton.setDefaultCapable( true );
		this.addItemAtEndJButton.setVisible( true );
		this.addItemAtEndJButton.setOpaque( true );
		this.addItemAtEndJButton.addActionListener( this );

		this.removeItemJButton = new JButton();
		this.removeItemJButton.setBounds( 190, 120, 200, 30 );
		this.removeItemJButton.setText( "Remove an Item" );
		this.removeItemJButton.setToolTipText( "Removes an Item from the Shopping List" );
		this.removeItemJButton.setVisible( true );
		this.removeItemJButton.addActionListener( this );

		this.addItemAtPositionJButton = new JButton();
		this.addItemAtPositionJButton.setBounds( 190, 45, 200, 65 );
		this.addItemAtPositionJButton.setText( "Add Item At Position on List" );
		this.addItemAtPositionJButton.setToolTipText( "Adds Item At Specific Position on List" );
		this.addItemAtPositionJButton.setVisible( true );
		this.addItemAtPositionJButton.addActionListener( this );

		this.removeItemJLabel = new JLabel();
		this.removeItemJLabel.setBounds( 5, 120, 85, 30 );
		this.removeItemJLabel.setText( "Item Name" );
		this.removeItemJLabel.setToolTipText( "Item Name of Removed item" );
		this.removeItemJLabel.setVisible( true );

		this.spacer1ItemJLabel = new JLabel();
		this.spacer1ItemJLabel.setBounds( 5, 102, 400, 30 );
		this.spacer1ItemJLabel.setText( "******************************************************************************" );
		this.spacer1ItemJLabel.setVisible( true );
		
		this.spacer2ItemJLabel = new JLabel();
		this.spacer2ItemJLabel.setBounds( 5, 27, 400, 30 );
		this.spacer2ItemJLabel.setText( "******************************************************************************" );
		this.spacer2ItemJLabel.setVisible( true );
		
		this.addAtPosition_Position_JLabel = new JLabel();
		this.addAtPosition_Position_JLabel.setBounds( 5, 80, 85, 30 );
		this.addAtPosition_Position_JLabel.setText( "Position" );
		this.addAtPosition_Position_JLabel.setToolTipText( "Position Of Item" );
		this.addAtPosition_Position_JLabel.setVisible( true );

		this.addAtPosition_Name_JLabel = new JLabel();
		this.addAtPosition_Name_JLabel.setBounds( 5, 45, 85, 30 );
		this.addAtPosition_Name_JLabel.setText( "Item Name" );
		this.addAtPosition_Name_JLabel.setToolTipText( "Item Name" );
		this.addAtPosition_Name_JLabel.setVisible( true );

		this.addAtEndJLabel = new JLabel();
		this.addAtEndJLabel.setBounds( 5, 5, 85, 30 );
		this.addAtEndJLabel.setText( "Item Name" );
		this.addAtEndJLabel.setToolTipText( "Adding At End Item Name" );
		this.addAtEndJLabel.setVisible( true );

		this.completionMessageJLabel = new JLabel();
		this.completionMessageJLabel.setBounds( 120, 160, 270, 80 );
		this.completionMessageJLabel.setVisible(true);

		this.dataJLabel = new JLabel();
		this.dataJLabel.setBounds( 400, 4, 400, 20 );
		this.dataJLabel.setText( "Shopping List" );
		this.dataJLabel.setToolTipText( "Java Shopping List GUI" );
		this.dataJLabel.setVisible(true);

		this.jFrame.add(mainTextArea);  
		this.jFrame.add(addItemAtPosition_Name_JTextField);
		this.jFrame.add(addItemAtPosition_Position_JTextField);
		this.jFrame.add(displayListJCheckBox);
		this.jFrame.add(removeItem_Name_JTextField);
		this.jFrame.add(addItemNameAtEndOfListJTextField);
		this.jFrame.add(addItemAtEndJButton);
		this.jFrame.add(removeItemJButton);
		this.jFrame.add(addItemAtPositionJButton);
		this.jFrame.add(removeItemJLabel);
		this.jFrame.add(addAtPosition_Position_JLabel);
		this.jFrame.add(addAtPosition_Name_JLabel);
		this.jFrame.add(addAtEndJLabel);
		this.jFrame.add(completionMessageJLabel);
		this.jFrame.add(dataJLabel);
		this.jFrame.add(spacer1ItemJLabel);
		this.jFrame.add(spacer2ItemJLabel);
		this.jFrame.setJMenuBar(menuBar);
		//set size of JFrame and make visible
		this.jFrame.setLayout(null);    
		this.jFrame.setVisible(true);  
		this.jFrame.setSize(850, 600);
		this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}//ending bracket of constructor

	/**
	 *method to do something when button is clicked
	 */
	public void actionPerformed(ActionEvent e) {
		if(displayListJCheckBox.isSelected()){  
			mainTextArea.setText(shopper.toString());
		}else if(!displayListJCheckBox.isSelected()){
			mainTextArea.setText("Shopping List");
		}//end of else

		if(e.getSource()==inputMenuItem){    
			inputFileSelection();
			completionMessageJLabel.setText("File Opened Succesfully");
			if(displayListJCheckBox.isSelected()){  
				mainTextArea.setText(shopper.toString());
			}//ending bracket of if
		}//ending bracket of if getSource statement

		if(e.getSource()==outputMenuItem){   
			outputFileSelection();
			completionMessageJLabel.setText("Output File Completed");
		}//ending bracket of if getSource statement

		if(e.getSource()==addItemAtEndJButton){    
			completionMessageJLabel.setText(shopper.addShoppingItem(addItemNameAtEndOfListJTextField.getText()));
			addItemNameAtEndOfListJTextField.setText("");
			if(displayListJCheckBox.isSelected()){  
				mainTextArea.setText(shopper.toString());
			}//ending bracket of if
		}//ending bracket of if getSource statement\

		if(e.getSource()==addItemAtPositionJButton){    
			int temp;
			try {
			temp=Integer.parseInt(addItemAtPosition_Position_JTextField.getText());
			completionMessageJLabel.setText(shopper.addShoppingItem(addItemAtPosition_Name_JTextField.getText(), temp ));
			addItemAtPosition_Name_JTextField.setText("");
			addItemAtPosition_Position_JTextField.setText("");
			if(displayListJCheckBox.isSelected()){  
				mainTextArea.setText(shopper.toString());
			}//ending bracket of if
			}
			catch(NumberFormatException nfe){
				completionMessageJLabel.setText("Error, number not detected in Position box");
			}
			
		}//ending bracket of if getSource statement

		if(e.getSource()==removeItemJButton){    
			completionMessageJLabel.setText(shopper.removeShoppingItem(removeItem_Name_JTextField.getText()));
			removeItem_Name_JTextField.setText("");
			if(displayListJCheckBox.isSelected()){  
				mainTextArea.setText(shopper.toString());
			}//ending bracket of if
		}//ending bracket of if getSource statement\
		
		if(e.getSource()==about){    
			this.aboutPage();
		}//ending bracket of if getSource statement
	}//ending bracket of actionPerformed

	/**
	 * selects output file
	 */
	private void outputFileSelection() {
		if(this.fileChooser.showOpenDialog(jFrame)==JFileChooser.APPROVE_OPTION){    
			shopper.outputFile(this.fileChooser.getSelectedFile());
		}//ending bracket of if FileChooser statement
	}//ending bracket of method outputFileSelection   

	/**
	 * selects input file.
	 */
	private void inputFileSelection() {   
		if(this.fileChooser.showOpenDialog(jFrame)==JFileChooser.APPROVE_OPTION){      
			shopper.readFile(this.fileChooser.getSelectedFile());
		}//ending bracket of if FileChooser statement
	}//ending bracket of method inputfileselection   
	
	/**
	 * Creates an About Page
	 */
	private void aboutPage() {		
		JFrame frame = new JFrame("About Shopping List V0.1");
		JLabel aboutLabel = new JLabel("Shopping List(Java Version)\n");
		JLabel aboutLabel1 = new JLabel("(c) Copyright Jacob Vaught 2021. All rights reserved.");
		aboutLabel.setBounds(5, 5, 400, 30 );
		aboutLabel1.setBounds( 5, 40, 600, 30 );
		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(235, 75, 60, 30);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(exitButton);
		frame.add(aboutLabel);
		frame.add(aboutLabel1);
		frame.setSize(550, 150);
		exitButton.addActionListener(e -> { frame.dispose(); });
		frame.setVisible(true);
	}
}//ending bracket of class.