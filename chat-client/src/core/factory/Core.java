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
public interface Core {

    public static int MAX_SLEEP_TIME = 1000;
    
    public void run();
    
    public MessageQueue getBackendQueue();
    
    public MessageQueue getFrontendQueue();
}
