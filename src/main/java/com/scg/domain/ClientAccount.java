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
    private  String clientName;
    private  Name clientContact;
    ClientAccount(String name, Name contact){
        this.clientName=name;
        this.clientContact=contact;//Creates a new instance of ClientAccount.
    }

    @Override
    public String getName() {
        Name cname=new Name();
        clientName=cname.getFirstName() +","+cname.getLastName();        
        return clientName;
        
    }

    @Override
    public boolean isBillable() {
        return true;
    }
    public Name getContact(){
        return clientContact;
        
    }
    
    
    public void setContact(Name contact){
        this.clientContact=contact;
        
    }
    
}
