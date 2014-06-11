
package core.interfaces;

import core.model.MessageQueue;

/**
 *
 * @author msczepan
 */
public interface Event {

    public MessageQueue queue = core.controller.Bootstrap.getOutboundQueue();
    
    public void process();
    
    public void send();
}
