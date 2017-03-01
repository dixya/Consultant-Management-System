/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scg.domain;
import com.scg.util.Name;

/**
 * A consultant.
 * @author dixya
 */
public class Consultant implements Comparable<Consultant>{
    String ConsultantFirstName;
    String ConsultantMiddleName;
    String ConsultantLastName;

    /**
     * Creates a new instance of Consultant.
     * @param name 
     */
    public Consultant(Name name){
       this.ConsultantFirstName= name.getFirstName();
       this.ConsultantMiddleName= name.getMiddleName();
       this.ConsultantLastName= name.getLastName();
    }
    
    /**
     * Getter for property name.
     * @return consultant name
     */
    public Name getName(){
        Name ConsultantName=new Name(ConsultantLastName,ConsultantFirstName,ConsultantMiddleName);
        return ConsultantName;       
        
    }
    /**
     * Returns the string representation of the consultant's name.
     * @return string value.
     */
    @Override
    public String toString(){
        StringBuilder ConsName=new StringBuilder();
        ConsName.append(ConsultantLastName);
        ConsName.append(",");
        ConsName.append(ConsultantFirstName);
        if(ConsultantMiddleName!=null){
             ConsName.append(" ");
        ConsName.append(ConsultantMiddleName);

        }
        return ConsName.toString();
    }

    @Override
    public int compareTo(Consultant t) {
        //return name.compareTo(t.name);
        int consultantResult=(this.getName()).compareTo(t.getName());
        return consultantResult;
    }
    
}
