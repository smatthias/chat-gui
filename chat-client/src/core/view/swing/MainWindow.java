
package core.view.swing;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 *
 * @author akraskov
 */
public class MainWindow extends JFrame {
    
    private MainPanel mainPanel;
    
    public MainWindow() {
        this.setSize(300, 400);
        
        this.setTitle("ZLChat");
        this.setLocationRelativeTo(null);
        
        this.setJMenuBar(new MainMenu());
        
        this.mainPanel = new MainPanel();
        
        this.add(this.mainPanel);
        
        this.show();
        this.setWindowListener();
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }    
    
    private void setWindowListener() {
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}
