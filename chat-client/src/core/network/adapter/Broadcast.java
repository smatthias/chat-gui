/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.network.adapter;

import java.net.*;
/**
 *
 * @author msczepan
 */
public class Broadcast {
    private final int SERVERPORT = 15005; 
    private String serverIp;
    private InetAddress address;
    private DatagramSocket socket;
    public Broadcast() {
        
        try {
            this.serverIp = Inet4Address.getLocalHost().getHostAddress();
            this.address = InetAddress.getByName("10.161.143.255");
            startSocket();
        } catch (Exception e) {
            
        }     
    }
    
    public void sendBroadcast() {
        try {
            System.out.println("starting: ");
            String data = "test";
            DatagramPacket dataPack = new DatagramPacket(data.getBytes(), data.getBytes().length, address, SERVERPORT);
            socket.send(dataPack);
            byte [] rec = new byte[1024];
            dataPack = new DatagramPacket(data.getBytes(), data.getBytes().length, address, SERVERPORT);
            socket.receive(dataPack); 
            byte [] receive = dataPack.getData();
            String received = receive.toString();
            System.out.println("Received: " + received);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void startSocket() {
        try {
             socket = new DatagramSocket(SERVERPORT);
             InetAddress address = InetAddress.getByName(serverIp);
             socket.setBroadcast(true);
             socket.connect(address, SERVERPORT);
        } catch(Exception e) {
            
        }
    }
}
