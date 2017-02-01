/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scg.domain;

/**
 *
 * @author dixya
 */
public enum NonBillableAccount extends Enum<NonBillableAccount> implements Account{

//Encapsulates the concept of a non-billable account. 

    /**
     *
     */
    public static final NonBillableAccount SICK_LEAVE;
    public static final NonBillableAccount VACATION;
    public static final NonBillableAccount BUSINESS_DEVELOPMENT;


    @Override
    public String getName() {
        
        
    }

    @Override
    public boolean isBillable() {
        return false;
    }
    public String toString(){
        //Returns the friendly name for this enumerated value.
    }
    public static NonBillableAccount valueOf(String name){
        if(name.equals(Null)) throw new NullPointerException;
        for (NonBillableAccount c : NonBillableAccount.values()){
        if(c.equals(name))
            System.out.println(name);
        }
        else throw new illegalArgumentException;

//Returns the enum constant of this type with the specified name.
    }
    public static NonBillableAccount[] values(){
        for (NonBillableAccount c : NonBillableAccount.values())
        System.out.println(c);
        

//Returns an array containing the constants of this enum type, in the order they are declared.
    }   





}