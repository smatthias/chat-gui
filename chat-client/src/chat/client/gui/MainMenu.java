
package chat.client.gui;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 *
 * @author akraskov
 */
public class MainMenu {
    
    public JMenuBar createMenu()
    {
        JMenuBar menubar = new JMenuBar();
        
        menubar.add(this.createFileMenu());
        menubar.add(this.createHelpMenu());
        
        return menubar;
    }
    
    private JMenu createFileMenu()
    {
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Exit application");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        
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
}
