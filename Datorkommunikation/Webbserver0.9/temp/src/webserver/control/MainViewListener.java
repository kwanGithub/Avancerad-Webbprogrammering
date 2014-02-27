/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserver.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;

/**
 *
 * @author Kevin
 */
public class MainViewListener implements ActionListener
{

    private JToggleButton start, logout;

    public MainViewListener(JToggleButton start, JToggleButton logout)
    {
        this.start = start;
        this.logout = logout;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object choice = (e.getSource());
        if (choice == start)
        {

        }
    }

}
