/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swing.testFrame;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author msczepan
 */
public class TestFrame extends JFrame{
    
    public TestFrame() {
        this.setSize(300, 400);
        this.show();
        this.setWindowListener();
    }
    
    private void setWindowListener()
    {
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}
