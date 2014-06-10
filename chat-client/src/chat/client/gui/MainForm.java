/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat.client.gui;

import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 *
 * @author akraskov
 */
public class MainForm {
    public JPanel createPanel()
    {
        JPanel panel = new JPanel(new BorderLayout());
        
        panel.setBorder(new EmptyBorder(3, 3, 3, 3));
        
        JTextArea chat = new JTextArea();
        chat.setBorder(LineBorder.createGrayLineBorder());
        
        JTextArea message = new JTextArea();
        message.setPreferredSize(new Dimension(300, 50));
        message.setBorder(LineBorder.createGrayLineBorder());
        
        JTree tree = new JTree();
        tree.setBorder(LineBorder.createGrayLineBorder());

        panel.add(chat, BorderLayout.CENTER);
        panel.add(message, BorderLayout.SOUTH);
        panel.add(tree, BorderLayout.EAST);
        
        return panel;
    }
}
