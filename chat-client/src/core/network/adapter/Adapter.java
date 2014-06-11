/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.network.adapter;

import java.io.IOException;
import net.tomp2p.futures.FutureDHT;
import net.tomp2p.futures.FutureBootstrap; 
import net.tomp2p.p2p.Peer;
import net.tomp2p.p2p.PeerMaker;
import net.tomp2p.peers.Number160;
import net.tomp2p.storage.Data;
/**
 *
 * @author msczepan
 */
public class Adapter implements core.interfaces.Adapter{
    
    public final Peer peer;
    
    public Adapter(int peerId) throws Exception{
            this.peer = new PeerMaker(Number160.createHash(peerId)).setPorts(port).makeAndListen();
            FutureBootstrap fb = peer.bootstrap().setBroadcast().setPorts(port + 1).start();
    }
    
    private void store(String name, String ip) throws IOException {
        peer.put(Number160.createHash(name)).setData(new Data(ip)).start().awaitUninterruptibly();
    }
    
    public String get(String name) throws ClassNotFoundException, IOException {
        FutureDHT futureDHT = peer.get(Number160.createHash(name)).start();
        futureDHT.awaitUninterruptibly();
        if (futureDHT.isSuccess()) {
            return futureDHT.getData().getObject().toString();
        }
        return "not found";
    }
}
