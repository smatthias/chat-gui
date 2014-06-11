/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.controller;

import core.model.MessageQueue;
import core.controller.Core;
import core.view.Listener;
import core.model.Peer;

/**
 *
 * @author msczepan
 */
public class Com {
    
    public static MessageQueue frontendQueue = new MessageQueue();
    public static MessageQueue backendQueue = new MessageQueue();
    
    public static Core core = null;
    public static Listener listener = null;
    private static Peer peer = null;
    
    public static void startThreads(){
        if(peer != null) {
            core = new Core(peer);
            listener = new Listener();
            core.start();
            listener.start();
        }
    }
    
    public static void setPeer() {
        peer = new Peer();
    }
}
