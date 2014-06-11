
package core.controller;

import core.controller.Backend;
import core.controller.Frontend;
import core.model.MessageQueue;
import core.model.Peer;
import core.interfaces.View;

/**
 *
 * @author msczepan
 */
public class Bootstrap {
    
    private static MessageQueue inboundQueue = new MessageQueue();
    private static MessageQueue outboundQueue = new MessageQueue();
    
    private static Backend backendController = null;
    private static Frontend frontendController = null;
    
    private static Peer peer = null;
    private static View view = null;
    
    public static void startThreads() {
        if (peer != null && view != null) {
            backendController = new Backend(peer);
            frontendController = new Frontend(view);
            
            backendController.start();
            frontendController.start();
            
            view.start();
        }
    }
    
    public static void setPeer(Peer p) {
        peer = p;
    }
    
    public static void setView(View v) {
        view = v;
    }

    public static MessageQueue getInboundQueue() {
        return inboundQueue;
    }

    public static MessageQueue getOutboundQueue() {
        return outboundQueue;
    }

    public static Backend getBackendController() {
        return backendController;
    }

    public static Frontend getFrontendController() {
        return frontendController;
    } 
    
    public static void tearDown() {
        backendController.stop();
        backendController = null;
    }
    public static void restart() {
        tearDown();
        backendController = new Backend(peer);
        backendController.start();
    }
    
    public static void savePeer(String firstName, String lastName, String alias) {
        peer = new Peer();
        peer.setFirstName(firstName);
        peer.setLastName(lastName);
        peer.setAlias(alias);
        setPeer(peer);
    }
}
