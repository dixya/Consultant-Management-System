/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scg.domain;

import com.scg.util.Name;

/**
 *
 * @author dixya
 */
public class ClientAccount implements Account{
    private  String name;
    private  Name contact;
    public ClientAccount(String name, Name contact){
        this.name=name;
        this.contact=contact;//Creates a new instance of ClientAccount.
    }

    /**
     * Getter for the name
     * @return name of the account
     */
    @Override
    public String getName() {
        //String cname;
       // cname=clientContact.getLastName() +","+clientContact.getFirstName();        
        return name;
        
    }

    @Override
    public boolean isBillable() {
        return true;
    }
    public Name getContact(){
       
        return contact;
        
    }
    
    
    public void setContact(Name contact){
         String clientContactLastName=this.contact.getLastName();
        String clientContactFirstName=this.contact.getFirstName();
        String clientContactMiddleName=this.contact.getMiddleName();
        
        this.contact=new Name(clientContactLastName,clientContactFirstName,clientContactMiddleName);
        
    }
    
}
