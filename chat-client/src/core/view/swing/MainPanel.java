
package core.view.swing;

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
public class MainPanel extends JPanel{
    public void MainPanel()
    {
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(3, 3, 3, 3));
        
        JTextArea chat = new JTextArea();
        chat.setBorder(LineBorder.createGrayLineBorder());
        
        JTextArea message = new JTextArea();
        message.setPreferredSize(new Dimension(300, 50));
        message.setBorder(LineBorder.createGrayLineBorder());
        
        JTree tree = new JTree();
        tree.setBorder(LineBorder.createGrayLineBorder());

        JTextField filter = new JTextField(); 
        filter.setBorder(LineBorder.createGrayLineBorder());
        
        JList list = new JList();
        list.setBorder(LineBorder.createGrayLineBorder());
        list.setPreferredSize(new Dimension(50, 300));
        
        JPanel usersPanel = new JPanel(new BorderLayout());       
        
        usersPanel.add(filter, BorderLayout.NORTH);
        usersPanel.add(tree, BorderLayout.CENTER);
        
        this.add(chat, BorderLayout.CENTER);
        this.add(message, BorderLayout.SOUTH);
        this.add(usersPanel, BorderLayout.EAST);
        this.add(list, BorderLayout.WEST);
    }
}
