/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scg.util;

import static java.lang.Byte.hashCode;
import static java.lang.Character.hashCode;

/**
 *
 * @author dixya
 */
public final class Name extends Object{
    private String fname;
    private String lname;
    private String mname;
   public Name(){
         //Creates a new instance of Name
    }
    public Name(String lastName, String firstName){
        this.lname=lastName;
        this.fname=firstName;//Construct a Name.
  }
    public Name(String lastName, String firstName, String middleName){
             this.fname=firstName;
             this.lname=lastName;
             this.mname=middleName;// this.hashcode=calchashcode();        
//Construct a Name.
    }

    
    public boolean equals(Object other){
         if(!(other instanceof Name)){
            return false;
         }
            final Name o=(Name)other;
            return ((lname==null&&o.lname==null)||
                     ((lname!=null&& o.lname!=null)&&
                      lname.equals(o.lname))) &&
                       ((fname==null&&o.fname==null)||
                     ((fname!=null&& o.fname!=null)&&
                      fname.equals(o.fname)))&&
                        ((mname==null&&o.mname==null)||
                     ((mname!=null&& o.mname!=null)&&
                      mname.equals(o.mname)));
    }//Compare names for equivalence.
  
    public String getFirstName(){
        return fname;//Getter for property firstName.
    }
    public String getLastName(){
        return lname;//Getter for property lastName.
    }
    public String getMiddleName(){
       return mname; //Getter for property middleName.
    }
    public int hashCode(){
        return hashCode;
    }
    public void setFirstName(String firstName){
        this.fname=firstName;
        //Setter for property first.


    }
    void setLastName(String lastName){
        this.lname=lastName;
//setter for last name.
    }
    void setMiddleName(String middleName){
        this.mname=middleName;//Setter for property middleName.
    }
    public String toString(){
            final StringBuilder namepattern=new StringBuilder();
           namepattern.append(lname);
           namepattern.append(fname);
           namepattern.append(mname);
           String output=namepattern.toString();
           return output;
        //Create string representation of this object in the format
    //"LastName, FirstName MiddleName".
    }

    
}
