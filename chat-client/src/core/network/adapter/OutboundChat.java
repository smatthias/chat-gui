/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core.network.adapter;

import core.interfaces.EventObject;
/**
 *
 * @author msczepan
 */
public class OutboundChat {
    
    public static void sendMessage(EventObject obj) {
        byte [] serialized = core.model.Serializer.serialize(obj);
        core.network.adapter.InboundChat.send(serialized, null, core.interfaces.Adapter.port + 1);
    }
}
