
package core.view.swing;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import core.view.swing.Settings;
import core.view.swing.Search;

/**
 *
 * @author akraskov
 */
public class MainMenu extends JMenuBar {
    
    public MainMenu()
    {        
        this.add(this.createFileMenu());
        this.add(this.createChatMenu());
        this.add(this.createHelpMenu());
    }
    
    public JMenu createFileMenu()
    {
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        
        JMenuItem settingsMenuItem = new JMenuItem("Settings");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Exit application");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        
        settingsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                new Settings();
            }
        });
        
        file.add(settingsMenuItem);
        file.add(exitMenuItem);
        
        return file;
    }
    
    private JMenu createHelpMenu()
    {
        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        
        JMenuItem helpMenuItem = new JMenuItem("About");
        helpMenuItem.setMnemonic(KeyEvent.VK_E);
        
        help.add(helpMenuItem);
        
        return help;
    }
    
    private JMenu createChatMenu()
    {
        JMenu chat = new JMenu("Chat");
        chat.setMnemonic(KeyEvent.VK_C);
        
        JMenuItem findUserMenuItem = new JMenuItem("Find user");
        findUserMenuItem.setMnemonic(KeyEvent.VK_E);
        
        findUserMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                new Search();
            }
        });
        
        chat.add(findUserMenuItem);
        
        return chat;
                
    }
}
