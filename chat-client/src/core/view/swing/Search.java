/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.view.swing;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author msczepan
 */
public class Search extends JFrame{
    
    private JPanel searchPanel;
    private JPanel buttonPanel;
    
    private JLabel searchLabel;
    
    private JTextField search;
    
    private JButton cancelButton;
    private JButton searchButton;
    
    public Search() {
        
        setup();
        addListener();
        this.show();
        this.setSize(300, 75);
        this.setLocation(400,250);
    }
    
    private void setup() {
        searchPanel = new JPanel();
        buttonPanel = new JPanel();
        searchLabel = new JLabel("Find User");
        search = new JTextField();
        cancelButton = new JButton("cancel");
        searchButton = new JButton("suche");
        
        this.setLayout(new GridLayout(2,1));
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
        buttonPanel.setLayout(new BorderLayout());
        searchPanel.add(searchLabel);
        searchPanel.add(search);
        buttonPanel.add(cancelButton, BorderLayout.WEST);
        buttonPanel.add(searchButton, BorderLayout.EAST);
        
        this.add(searchPanel);
        this.add(buttonPanel);
    }
    
    private void addListener() {
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
