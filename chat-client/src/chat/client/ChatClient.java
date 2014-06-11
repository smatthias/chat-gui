/**
 * @author: matthias.sczepan@zalando-lounge.de
 */

package chat.client;

import core.controller.Bootstrap;
import core.view.swing.Gui;
import core.model.Peer;

/**
 *
 * @author msczepan
 */
public class ChatClient {
   
    public static void main(String[] args) {
        
        Gui gui = new Gui();
        Peer peer = new Peer();
       
        Bootstrap.setPeer(peer);
        Bootstrap.setView(gui);
        
        Bootstrap.startThreads();
    }
}
