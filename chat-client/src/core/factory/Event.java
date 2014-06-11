/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.factory;

import core.model.MessageQueue;

/**
 *
 * @author msczepan
 */
public interface Event {

    public MessageQueue queue = core.controller.Com.backendQueue;
    
    public void process();
    
    public void send();
}
