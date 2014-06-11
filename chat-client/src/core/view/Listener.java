/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.view;

import core.factory.EventObject;
import core.model.MessageQueue;
import core.view.swing.MainForm;
/**
 *
 * @author akraskov
 */
public class Listener extends Thread{
    
    private MessageQueue frontendQueue = core.controller.Com.frontendQueue;
    private MessageQueue backendQueue = core.controller.Com.backendQueue;
    
    public void run() {
        
        while(true) {
            try {
                synchronized(this) {
                    wait(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
    
    public void push(EventObject obj) {
        this.backendQueue.add(obj);
    }
}
