/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.components;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import gui.model.Contact;

/**
 *
 * @author msczepan
 */
public class ContactList extends Accordion{
    
    private TitledPane [] tps;
    
    public ContactList(Contact [] contacts) {
        this.tps = new TitledPane[contacts.length];
        initializeAccordion(contacts);
        
        
    }
    
    public void initializeAccordion(Contact [] contacts) {
        for (int i = 0; i < contacts.length; i++) {
           
            if (contacts[i].getMembers() == null) {
                TitledPane tp = new TitledPane();
                tp.setText(contacts[i].getName());
                tp.setCollapsible(false);
                tps[i] = tp;
            } else {
                VBox stp = new VBox();
                stp.setStyle("-fx-padding: 0; -fx-background-color: #3AAACF;");
                Contact [] cons = contacts[i].getMembers();
                TitledPane [] stackedTitledPanes = new TitledPane[cons.length];
                for (int j = 0; j < cons.length; j++) {
                    if (cons[j] != null) {
                        TitledPane tmp = new TitledPane();
                        tmp.setText(cons[j].getName());
                        tmp.setCollapsible(false);
                        tmp.setAnimated(false);
                        tmp.setStyle("-fx-padding:2; -fx-background-color: #3AAACF;");
                        tmp.setId("menu-button");
                        stackedTitledPanes[j] = tmp;
                    }
                }
                stp.getChildren().setAll(stackedTitledPanes);
                TitledPane tp = new TitledPane(contacts[i].getName(), stp);
                tp.setCollapsible(true);
                tp.setAnimated(true);
                tps[i] = tp;
            }
            this.setStyle("-fx-padding: 0; -fx-background-color: #3AAACF;");
            this.setId("accordion");
        }
        this.getPanes().addAll(tps);
    }
}
