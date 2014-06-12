
package core.model.events;

import core.model.eventObjects.UserSearchObject;

/**
 *
 * @author akraskov
 */
public class UserSearch implements core.interfaces.Event {
    
    private UserSearchObject userSearchObject;
    
    public UserSearch(UserSearchObject userSearchObject) {
        this.userSearchObject = userSearchObject;
        this.send();
    }

    @Override
    public void send() {
        this.queue.add(userSearchObject);
    }
    
    @Override
    public void process() {
        
    }    
}
