/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.controller;

import core.model.Peer;
import core.network.adapter.Adapter;
/**
 *
 * @author msczepan
 */
public class Core extends Thread implements core.factory.Core{   
    
    private Peer peer = null;
    
    public Core (Peer peer) {
        
        this.peer = peer;
    }
    
    public void run() {
        Adapter adapter = this.getAdapter();
        
        while(true) {
            try {
                
                
                this.wait(MAX_SLEEP_TIME);
            } catch (InterruptedException e) {
                
            } 
            
        }
    }
    
    private Adapter getAdapter() {
        return new Adapter();
    }
}