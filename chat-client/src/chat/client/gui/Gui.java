/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.client.gui;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 *
 * @author msczepan
 */
public class Gui extends JFrame{
    
    public Gui() {
        this.setSize(300, 400);
        
        this.setTitle("ZLChat");
        this.setLocationRelativeTo(null);
        
        this.setJMenuBar(this.getMainMenu());
        
        this.add(this.getPanel());
        
        this.show();
        this.setWindowListener();
    }
    
    private void setWindowListener() {
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
    
    private JMenuBar getMainMenu()
    {
        MainMenu menu = new MainMenu();
        return menu.createMenu();
    }
    
    private JPanel getPanel()
    {
        MainForm form = new MainForm();
        return form.createPanel();
    }
}
