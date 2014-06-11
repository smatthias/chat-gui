
package core.view;

import core.model.*;

/**
 *
 * @author akraskov
 */
public interface View {
    
    public void start();
    
    public void addGroupChat(GroupChat group);
    
    public void clearGroupChats();
    
    public void addMessage(Message message);
}
