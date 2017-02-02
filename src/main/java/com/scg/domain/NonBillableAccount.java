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
public enum NonBillableAccount implements Account {

//Encapsulates the concept of a non-billable account. 

    /**
     *
     */
      SICK_LEAVE,
      VACATION,
      BUSINESS_DEVELOPMENT;


    @Override
    public String getName() {
        
        return this.name();
        
        
    }

    @Override
    public boolean isBillable() {
        return false;
    }
      @Override
    public String toString(){
        return this.name();//Returns the friendly name for this enumerated value.
    }
    
    





}