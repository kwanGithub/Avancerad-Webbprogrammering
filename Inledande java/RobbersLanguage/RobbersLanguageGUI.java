 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import static javax.swing.GroupLayout.Alignment.*;

/**
 * Graphical User Interface for a simple application that
 * lets you translate text into the robber language 
 * (rövarspråket)
 */
public class RobbersLanguageGUI extends JFrame {
	
	private static final long serialVersionUID = -7339180215926889511L;
	private RobbersLanguage mRobbersLanguage = new RobbersLanguage();

	private JTextField mText = new JTextField(30);
	private JLabel mRobbersText = new JLabel();	
			
	/**
	 * Constructs a RobbersLanguageGUI
	 */
	public RobbersLanguageGUI() {
		super("Rövarspråksöversättare");
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
				translate();
			}			
		});		
		JLabel textHeading = new JLabel("Mening");
		JLabel robbersTextHeading = new JLabel("Rövarspråk");
					
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(LEADING)
						.addComponent(textHeading)
						.addComponent(mText)
						.addComponent(run))
				.addGroup(layout.createParallelGroup(LEADING)
						.addComponent(robbersTextHeading)
						.addComponent(mRobbersText))
				);
		
		layout.setVerticalGroup(layout.createSequentialGroup()
	            .addGroup(layout.createParallelGroup(BASELINE)
	                .addComponent(textHeading)
	                .addComponent(robbersTextHeading))	                
	            .addGroup(layout.createParallelGroup(LEADING)	            	
	            	.addGroup(layout.createSequentialGroup()
	                    .addComponent(mText)
	                    .addComponent(run))	            
	            .addComponent(mRobbersText))
	        );
	    
		layout.linkSize(SwingConstants.HORIZONTAL, mText, mRobbersText);
		this.pack();
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	        
	}
	/**
	 * Match numbers to the criteria and displays the result
	 */
	private void translate() {
		mRobbersText.setText(mRobbersLanguage.translate(mText.getText()));
	}	
}