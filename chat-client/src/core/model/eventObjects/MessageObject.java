/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.model.eventObjects;

import core.model.Peer;
import java.util.Date;

/**
 *
 * @author akraskov
 */
public class MessageObject implements core.interfaces.EventObject {
    
    private Peer peer;
    
    private String text;
    
    private Date date;
    
    public MessageObject(Peer peer, String text, Date date) {
        this.peer = peer;
        this.text = text;
        this.date = date;
    }

    public Peer getPeer() {
        return peer;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }    
}
