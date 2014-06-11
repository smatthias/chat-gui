/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.view.swing;

import core.model.GroupChat;
import core.model.eventObjects.MessageObject;
import core.interfaces.*;

/**
 *
 * @author msczepan
 */
public class Gui implements View {

    private MainWindow mainWindow;
    
    @Override
    public void start() {
        this.mainWindow = new MainWindow();
    }

    @Override
    public void addGroupChat(GroupChat group) {
        
    }

    @Override
    public void clearGroupChats() {
        
    }

    @Override
    public void addMessage(MessageObject message) {
        String text = this.mainWindow.getMainPanel().getChat().getText();
        if (text.length() > 0) {
            text = text + "\n";
        }
        text = text + "[" + message.getDate().toString() + "] ";
        text = text + message.getText();
        this.mainWindow.getMainPanel().getChat().setText(text);
    }
}
