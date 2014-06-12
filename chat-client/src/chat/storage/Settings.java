
package chat.storage;

import chat.storage.SettingsProtos.User;
import core.model.Peer;
import java.io.FileOutputStream;
import java.io.FileInputStream;

/**
 *
 * @author akraskov
 */
public class Settings {
    public Settings() {
        
    }
    
    public static void save(String firstName, String lastName, String alias)
    {
        User user = User.newBuilder()
            .setFirstname(firstName)
            .setLastname(lastName)
            .setAlias(alias)
            .build();
        
        try {
            FileOutputStream output = new FileOutputStream("/tmp/settings.bin");
            user.writeTo(output);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Peer load() {
        try {
            FileInputStream input = new FileInputStream("/tmp/settings.bin");
            User user = User.parseFrom(input);
            input.close();
            Peer peer = new Peer();
            peer.setFirstName(user.getFirstname());
            peer.setLastName(user.getLastname());
            peer.setAlias(user.getAlias());
            return peer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
