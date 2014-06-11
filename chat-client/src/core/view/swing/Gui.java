/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.view.swing;

import core.model.GroupChat;
import core.model.Message;
import core.view.View;

/**
 *
 * @author msczepan
 */
public class Gui implements View {
    @Override
    public void start() {
        MainWindow window = new MainWindow();
    }

    @Override
    public void addGroupChat(GroupChat group) {
        
    }

    @Override
    public void clearGroupChats() {
        
    }

    @Override
    public void addMessage(Message message) {
        
    }
}
