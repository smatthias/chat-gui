/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.network.adapter;

import java.net.*;
import java.io.*;
/**
 *
 * @author msczepan
 */
public class InboundChat extends Thread{
    
    private static DatagramSocket serverSocket = null;
    
    public InboundChat() {
        try {
            serverSocket = new DatagramSocket(9876);
        } catch (SocketException e) {
            
        }
        
    }
    
    public void run() {
        byte[] receiveData = new byte[1024];             
        
        while(true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
            try {
                synchronized(this) {
                    if (serverSocket != null) {
                        serverSocket.receive(receivePacket);
                        core.model.Serializer.dezerialize(receivePacket);
                    }    
                    this.wait(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void send(byte [] data, InetAddress ip, int port) {
        try {
            DatagramPacket sendPacket = new DatagramPacket(data, data.length, ip, port); 
            serverSocket.send(sendPacket);
        } catch (IOException e) {
            
        }
    }
}
