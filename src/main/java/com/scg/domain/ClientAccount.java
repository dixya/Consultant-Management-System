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
public class ClientAccount extends Object implements Account{
    private  String clientAccountName;
    private  Name clientContact;
    public ClientAccount(String name, Name contact){
        this.clientAccountName=name;
        this.clientContact=contact;//Creates a new instance of ClientAccount.
    }

    @Override
    /* gets account name */
    public String getName() {
        //String cname;
       // cname=clientContact.getLastName() +","+clientContact.getFirstName();        
        return clientAccountName;
        
    }

    @Override
    public boolean isBillable() {
        return true;
    }
    public Name getContact(){
       
        return clientContact;
        
    }
    
    
    public void setContact(Name contact){
         String clientContactLastName=clientContact.getLastName();
        String clientContactFirstName=clientContact.getFirstName();
        String clientContactMiddleName=clientContact.getMiddleName();
        
        this.clientContact=new Name(clientContactLastName,clientContactFirstName,clientContactMiddleName);
        
    }
    
}
