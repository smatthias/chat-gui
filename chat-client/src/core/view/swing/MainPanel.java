
package core.view.swing;

import core.model.Peer;
import core.model.events.Message;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

/**
 *
 * @author akraskov
 */
public class MainPanel extends JPanel{
    
    private JTextArea message;
    
    private JTree tree;
    
    private JTextField filter;
    
    private JList list;
    
    private JTextArea chat;
    
    public MainPanel()
    {
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(3, 3, 3, 3));
        
        this.chat = new JTextArea();
        this.chat.setBorder(LineBorder.createGrayLineBorder());
        
        this.message = new JTextArea();
        this.message.setPreferredSize(new Dimension(300, 50));
        this.message.setBorder(LineBorder.createGrayLineBorder());
        
        this.tree = new JTree();
        this.tree.setBorder(LineBorder.createGrayLineBorder());

        this.filter = new JTextField(); 
        this.filter.setBorder(LineBorder.createGrayLineBorder());
        
        this.list = new JList();
        this.list.setBorder(LineBorder.createGrayLineBorder());
        this.list.setPreferredSize(new Dimension(50, 300));
        
        JPanel usersPanel = new JPanel(new BorderLayout());       
        
        usersPanel.add(filter, BorderLayout.NORTH);
        usersPanel.add(tree, BorderLayout.CENTER);
        
        this.add(chat, BorderLayout.CENTER);
        this.add(message, BorderLayout.SOUTH);
        this.add(usersPanel, BorderLayout.EAST);
        this.add(list, BorderLayout.WEST);
        
        this.addListener();
    }

    public JTextArea getMessage() {
        return message;
    }

    public JTree getTree() {
        return tree;
    }

    public JTextField getFilter() {
        return filter;
    }

    public JList getList() {
        return list;
    }

    public JTextArea getChat() {
        return chat;
    }
    
    private void addListener() {
        
        this.message.addKeyListener(
            new KeyListener(){

                public void keyPressed(KeyEvent e){

                    if (e.getKeyCode() == KeyEvent.VK_ENTER && e.getModifiers() == KeyEvent.CTRL_MASK) {
                        Peer peer = new Peer();
                        Date date = new Date();
                        String text = message.getText();
                        
                        Message msg = new Message(peer, text, date);
                        
                        message.setText("");
                    }       
                }
                
                public void keyReleased(KeyEvent e) {               
                }
                
                public void keyTyped(KeyEvent e) {               
                }
            }
        );

    }
}
