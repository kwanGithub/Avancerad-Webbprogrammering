/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserver.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import webserver.control.MainViewListener;

/**
 *
 * @author Kevin
 */
public class MainView extends JFrame
{

    private final JButton port;
    private final JToggleButton start, logout;

    //private final JTextField input;
    private final JPanel panel;
    private final JLabel portnumber;
    private String num = "1111";

    public MainView()
    {

        //port = new JLabel();
        panel = new JPanel();
        //input = new JTextField("TEST");
        start = new JToggleButton("Start");
        logout = new JToggleButton("Logout");
        port = new JButton("Change Port");
        portnumber = new JLabel(num, SwingConstants.CENTER);

        panel.setLayout(new FlowLayout());

        //Listeners
        MainViewListener listener = new MainViewListener(start, logout);

        start.addActionListener(listener);
        //Color
        start.setBackground(Color.green);
        logout.setBackground(Color.red);
        port.setBackground(Color.orange);

        //border
        Border border = BorderFactory.createLoweredBevelBorder();
        Border raised = BorderFactory.createRaisedBevelBorder();
        portnumber.setBorder(border);
        start.setBorder(raised);
        port.setBorder(raised);

        //setsSize
        portnumber.setPreferredSize(new Dimension(175, 60));
        start.setPreferredSize(new Dimension(175, 60));
        port.setPreferredSize(new Dimension(175, 60));

        //fontsize
        portnumber.setFont(portnumber.getFont().deriveFont(35.0f));
        start.setFont(portnumber.getFont().deriveFont(25.0f));
        port.setFont(portnumber.getFont().deriveFont(20.0f));

        //fontcolor
        portnumber.setForeground(Color.GRAY);

        panel.add(portnumber);
        //panel.add(input);
        panel.add(start);
        panel.add(port);
        //panel.add(logout);

        add(panel);

        setSize(200, 240);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

}
