/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.view.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.BoxLayout.X_AXIS;

/**
 *
 * @author msczepan
 */
public class Settings extends JFrame{
    
    //some JPanels
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel buttonPanel;
    
    //labels
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel aliasLabel;
    
    //textfields
    private JTextField firstName;
    private JTextField lastName;
    private JTextField alias;
    
    private JButton cancelButton;
    private JButton saveButton;
    
    
    public Settings() {
        initialize();
        setup();
        setListener();
        this.show();
        this.setSize(300,100);
        this.setLocation(350, 250);
        this.setResizable(false);
    }
    
    private void initialize() {
        mainPanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        buttonPanel = new JPanel();
        
        firstNameLabel = new JLabel("Vorname");
        lastNameLabel = new JLabel("Nachname");
        aliasLabel = new JLabel("Alias");
        
        firstName = new JTextField(20);
        lastName = new JTextField();
        alias = new JTextField();
        
        cancelButton = new JButton("cancel");
        saveButton = new JButton("save");
    }
    
    private void setup() {
        mainPanel.setLayout(new BorderLayout());
        leftPanel.setLayout(new GridLayout(3,1));
        rightPanel.setLayout(new GridLayout(3,1));
        buttonPanel.setLayout(new BorderLayout());
        packPanels();
    }
    
    private void packPanels() {
        leftPanel.add(firstNameLabel);
        leftPanel.add(lastNameLabel);
        leftPanel.add(aliasLabel);
        rightPanel.add(firstName);
        rightPanel.add(lastName);
        rightPanel.add(alias);
        buttonPanel.add(cancelButton, BorderLayout.WEST);
        buttonPanel.add(saveButton, BorderLayout.EAST);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        this.add(mainPanel);
        this.validate();
    }
    
    private void setListener() {
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        saveButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               String first = firstName.getText();
               String last = lastName.getText();
               String username = alias.getText();
               core.controller.Bootstrap.savePeer(first, last, username);
               core.controller.Bootstrap.restart();
               dispose();
           } 
        });
    }
}
