
package core.controller;

import core.interfaces.Controller;
import core.interfaces.EventObject;
import core.interfaces.View;
import core.model.MessageQueue;
import core.model.eventObjects.*;

/**
 *
 * @author akraskov
 */
public class Frontend extends Thread implements Controller {
    
    private MessageQueue inboundQueue = core.controller.Bootstrap.getInboundQueue();
    
    private View view;
    
    public Frontend(View view) {
        this.view = view;
    }
    
    public void run() {
        
        while(true) {
            try {
                synchronized(this) {
                    if (this.inboundQueue.isEmpty() == false) {
                        EventObject obj = this.inboundQueue.get(0);
                        this.inboundQueue.remove(0);
                        this.process(obj);
                    }
                    wait(MAX_SLEEP_TIME);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
    
    public void push(EventObject obj) {
        this.inboundQueue.add(obj);
    }
    
    private void process(EventObject obj) {
        String cls = obj.getClass().toString();

        if (cls.equals("class core.model.eventObjects.MessageObject")) {
            MessageObject msg = (MessageObject) obj;
            this.view.addMessage(msg);
        }
    }
}
