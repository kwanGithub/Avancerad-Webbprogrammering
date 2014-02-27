import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import static javax.swing.GroupLayout.Alignment.*;

/**
 * A GUI for a simple number selector that lets the user input numbers and
 * criteria that will be used to select matching numbers that will be
 * displayed to the user.
 */
public class NumberSelectorGUI extends JFrame {
	
	private NumberSelector mNumberSelector = new NumberSelector();
	private static final long serialVersionUID = 7380590794285843986L;
	private JCheckBox mLessThan = new JCheckBox("Mindre än");
	private JCheckBox mEqual = new JCheckBox("Lika med");
	private JCheckBox mMoreThan = new JCheckBox("Mer än");
	private JTextArea mNumbers = new JTextArea();
	private JScrollPane mScrollPane = new JScrollPane(mNumbers);
	private JTextField mNumber = new JTextField();		
			
	/**
	 * Constructs a NumberSelectorGUI
	 */
	public NumberSelectorGUI() {
		super("Nummerväljaren");
		this.initializeGUI();
		this.setVisible(true);
	}
	/**
	 * Constructs the GUI
	 */
	private void initializeGUI() {				
		JButton run = new JButton("Kör");
		run.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {				
				matchNumbers();
			}			
		});
		mNumbers.setLineWrap(true);		
		JLabel numbersHeading = new JLabel("Siffror (separerade med mellanslag)");
		JLabel numberHeading = new JLabel("Tal");
					
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(LEADING)
						.addComponent(numbersHeading)
						.addComponent(mScrollPane))
				.addGroup(layout.createParallelGroup(LEADING)
						.addComponent(numberHeading)
						.addComponent(mNumber)
						.addComponent(mLessThan)
						.addComponent(mEqual)
						.addComponent(mMoreThan)
						.addComponent(run))
				);
		
		layout.setVerticalGroup(layout.createSequentialGroup()
	            .addGroup(layout.createParallelGroup(BASELINE)
	                .addComponent(numbersHeading)
	                .addComponent(numberHeading))	                
	            .addGroup(layout.createParallelGroup(LEADING)
	            	.addComponent(mScrollPane)
	            	.addGroup(layout.createSequentialGroup()
	                    .addComponent(mNumber)
	                    .addComponent(mLessThan)
	                    .addComponent(mEqual)
	                    .addComponent(mMoreThan)
	                    .addComponent(run)))
	        );
	      
	        this.setSize(400, 200);
	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	        
	}
	/**
	 * Match numbers to the criteria and displays the result
	 */
	private void matchNumbers() {
		String numbers = mNumbers.getText().replaceAll("[^0-9- ]", ""); 
		String number = mNumber.getText().replaceAll("[^0-9-]", "");
		
		String[] numbersArray = numbers.split(" ");
		ArrayList<Integer> numbersList = new ArrayList<Integer>();
		int value = 0;
		
		for(String s : numbersArray) {
			try{				
				numbersList.add(Integer.valueOf(s));
			} catch (NumberFormatException ignore) {
				//Do nothing
			}			
		}
		try {
			value = Integer.valueOf(number);
			
			ArrayList<Integer> selectedNumbers = mNumberSelector.selectNumbers(numbersList, value, mLessThan.isSelected(), mEqual.isSelected(), mMoreThan.isSelected());
			
			String selectedNumbersString = "";
			
			for(Integer i : selectedNumbers) {
				selectedNumbersString += i + ", ";
			}		
			JOptionPane.showMessageDialog(this, "Siffror som matchar kriterierna: " + selectedNumbersString.substring(0, selectedNumbersString.length() > 2 ? selectedNumbersString.length() - 2 : 0));
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "Ogiltigt värde för tal");
		}		
	}	
}