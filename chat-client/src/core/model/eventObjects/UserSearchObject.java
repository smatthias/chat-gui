
package core.model.eventObjects;

/**
 *
 * @author akraskov
 */
public class UserSearchObject implements core.interfaces.EventObject  {
    
    private String alias;
    
    public UserSearchObject(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }
}
