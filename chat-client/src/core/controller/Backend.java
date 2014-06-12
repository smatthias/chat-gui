
package core.controller;

import core.interfaces.Controller;
import core.interfaces.EventObject;
import core.model.Peer;
import core.network.adapter.Adapter;
import core.model.MessageQueue;
import core.model.eventObjects.*;
import java.net.*;
import java.io.*;
import java.util.*;
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
        this.setStore();
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
            String ip = getIp();
            this.adapter.store(peer.getAlias(), ip);
        } catch(IOException e) {
            
        }       
    }
    
    private String getIp() {
        try {
        for (Enumeration<NetworkInterface> ifaces = 
        NetworkInterface.getNetworkInterfaces();
        ifaces.hasMoreElements(); )
        {
            NetworkInterface iface = ifaces.nextElement();
            System.out.println(iface.getName() + ":");
            for (Enumeration<InetAddress> addresses =
                   iface.getInetAddresses();
                 addresses.hasMoreElements(); )
            {
                InetAddress address = addresses.nextElement();
                if (address instanceof Inet4Address) {
                    if(!iface.getName().equals("lo")) {
                        return address.getHostAddress();
                    }
                }
            }
        }
        } catch (Exception e) {
            
        }
        return null;
    }
}
 