/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.model;

import java.util.ArrayList;

/**
 *
 * @author akraskov
 */
public class GroupChat {
    
    private String name;

    private ArrayList<Peer> peers;
    
    public void Group()
    {
        this.peers = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }

    public GroupChat setName(String name) {
        this.name = name;
        return this;
    }
    
    public ArrayList<Peer> getPeers() {
        return peers;
    }

    public GroupChat setPeers(ArrayList<Peer> peers) {
        this.peers = peers;
        return this;
    }

    public GroupChat addPeer(Peer peer)
    {
        this.peers.add(peer);
        return this;
    }
}
