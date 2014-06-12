/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.network.adapter;

import java.io.IOException;
import net.tomp2p.futures.FutureDHT;
import net.tomp2p.futures.FutureBootstrap; 
import net.tomp2p.futures.BaseFutureAdapter;
import net.tomp2p.p2p.Peer;
import net.tomp2p.p2p.PeerMaker;
import net.tomp2p.peers.Number160;
import net.tomp2p.storage.Data;
import net.tomp2p.connection.Bindings;
import net.tomp2p.futures.FutureDiscover;
import java.net.*;
/**
 *
 * @author msczepan
 */
public class Adapter implements core.interfaces.Adapter{
    
    public final Peer peer;
    
    public Adapter(int peerId) throws Exception{
        Bindings b = new Bindings();
        b.addInterface("eth0");
        this.peer = new PeerMaker(Number160.createHash(peerId)).setPorts(port).makeAndListen();
        peer.getConfiguration().setBehindFirewall(true);
        Peer another = new PeerMaker(new Number160(peerId)).setMasterPeer(peer).makeAndListen();
        FutureDiscover future = another.discover().setPeerAddress(peer.getPeerAddress()).start();
        future.awaitUninterruptibly();
        
    }
    
    /**
     *
     * @param name
     * @param ip
     * @throws IOException
     */
    public void store(String name, String ip) throws IOException {
        peer.put(Number160.createHash(name)).setData(new Data(ip)).start().awaitUninterruptibly();
    }
    
    public String get(String name) throws ClassNotFoundException, IOException {
        FutureDHT futureDHT = peer.get(Number160.createHash(name)).start();
        try {
            futureDHT.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        futureDHT.getData();
        
        if (futureDHT.isSuccess()) {
            return futureDHT.getData().getObject().toString();
        }
        return "not found";
    }
}
