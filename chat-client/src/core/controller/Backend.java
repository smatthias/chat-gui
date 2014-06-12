
package core.controller;

import core.interfaces.Controller;
import core.interfaces.EventObject;
import core.model.Peer;
import core.network.adapter.Adapter;
import core.model.MessageQueue;
import core.model.eventObjects.*;
import java.net.*;
import java.io.*;

/**
 *
 * @author msczepan
 */
public class Backend extends Thread implements Controller {
    
    private Peer peer = null;
    
    private Adapter adapter = null;
    
    private MessageQueue outboundQueue = core.controller.Bootstrap.getOutboundQueue();
    
    public Backend (Peer peer) {
        this.peer = peer;
        this.adapter = this.createAdapter();
        try {
        } catch (Exception e) {
            
        }
        
    }
    
    public void run() {

        while(true) {
            try {
                synchronized (this) {
                    if (this.outboundQueue.isEmpty() == false) {
                        EventObject obj = this.outboundQueue.get(0);
                        this.outboundQueue.remove(0);
                        this.process(obj);
                    }
                    wait(MAX_SLEEP_TIME);
                }
            } catch (InterruptedException e) {
                
            } 
            
        }
    }
    
    private Adapter createAdapter() {
        try {
            int id = (int)(Math.random() * 1000);
            return new Adapter(id);
        } catch (Exception e) {
            return null;
        }
    }
    
    private void process(EventObject obj) {
        switch (obj.getClass().toString()) {
            case "class core.model.eventObjects.MessageObject":
                Bootstrap.getFrontendController().push(obj);
                break;
            case "class core.model.eventObjects.UserSearchObject":
                UserSearchObject userSearch = (UserSearchObject) obj;
                try {
                    String result = this.adapter.get(userSearch.getAlias());
                    System.out.println(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    
    public void setStore() {
        try {
            this.adapter.store("akraskov", "10.161.128.193");
        } catch(IOException e) {
            
        }       
    }
}
 