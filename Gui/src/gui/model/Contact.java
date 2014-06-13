/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.model;

/**
 *
 * @author msczepan
 */
public class Contact {
    
    private String name;

    private Contact [] members = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact[] getMembers() {
        return members;
    }

    public void setMembers(Contact[] members) {
        this.members = members;
    }
    
    
}
