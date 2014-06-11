/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.model.events;

import core.model.MessageQueue;
import core.model.eventObjects.MessageObject;
import core.model.Peer;
import java.util.Date;
/**
 *
 * @author msczepan
 */
public class Message implements core.factory.Event{
    
    private MessageObject msg;
    
    public Message(Peer peer, String text, Date date) {
        this.msg = new MessageObject(peer, text, date);
        this.send();
        
    }
    
    public void send () {
        this.queue.add(msg);
    }
    
    public void process() {
        
    }
}
