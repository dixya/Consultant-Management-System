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
public class Consultant extends Object {
    String ConsultantFirstName;
    String ConsultantMiddleName;
    String ConsultantLastName;

    public Consultant(Name name){
       this.ConsultantFirstName= name.getFirstName();
       this.ConsultantMiddleName= name.getMiddleName();
       this.ConsultantLastName= name.getLastName();
    }
    public Name getName(){
        Name ConsultantName=new Name(ConsultantLastName,ConsultantFirstName,ConsultantMiddleName);
        return ConsultantName;       
        
    }
    @Override
    public String toString(){
        StringBuilder ConsName=new StringBuilder();
        ConsName.append(ConsultantLastName);
        ConsName.append(",");
        ConsName.append(ConsultantFirstName);
        if(ConsultantMiddleName!=null){
             ConsName.append(",");
        ConsName.append(ConsultantMiddleName);

        }
        return ConsName.toString();
    }
    
}
