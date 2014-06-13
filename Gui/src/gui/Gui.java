/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import gui.components.ContactList;
import gui.model.Contact;
import javafx.scene.control.*;

/**
 *
 * @author msczepan
 */
public class Gui extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ZLChat");

        this.initialize(primaryStage);

    }
    
    private void initialize(Stage primaryStage) {
        StackPane root = new StackPane();
        BorderPane bp = new BorderPane();
        Contact [] con = getTestData();
        MenuBar menu = this.getMenuBar();
        ContactList contacts = new ContactList(con);
        bp.setRight(contacts);
        root.getChildren().add(bp);
        Scene scene = new Scene(root, 500, 450);
        ((VBox) scene.getRoot()).getChildren().addAll(menu);
        scene.getStylesheets().add("gui/layout/styles.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Contact[] getTestData() {
        Contact [] contacts = new Contact[5];
        Contact [] members = new Contact[3];
        String [] names = {"Matthias", "Alex", "Micha"};
        String [] groups = {"Deploy", "Lounge"};
        
        for (int i = 0; i < names.length; i++) {
            Contact contact = new Contact();
            contact.setName(names[i]);
            contacts[i] = contact;
            members[i] = contact;
        }
        
        Contact contact = new Contact();
        contact.setName(groups[0]);
        contact.setMembers(members);
        
        Contact contact2 = new Contact();
        contact2.setName(groups[1]);
        contact2.setMembers(members);
        
        contacts[3] = contact;
        contacts[4] = contact2;
        return contacts;
    }
    
    private MenuBar getMenuBar() {
        MenuBar menu = new MenuBar();
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");
        
        menu.getMenus().addAll(file, edit, help);
        return menu;
    }
}
