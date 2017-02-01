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
public class ConsultantTime extends Object{
    ConsultantTime(java.time.LocalDate date, Account account, Skill skillType, int hours){
        //Creates a new instance of ConsultantTime.
    }
    @Override
    public boolean equals(Object obj){
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    public Account getAccount(){
    //Getter for property account.
    }
    public java.time.LocalDate getDate(){
        
    }
    public int getHours(){
        //Getter for property hours.
    }
    public Skill getSkill(){
        //Getter for property skill.
    }
    public boolean isBillable(){
        //Determines if the time is billable.
    }
    public void setAccount(Account account){
        //Setter for property account.
    }
    public void setDate(java.time.LocalDate date){  
        //Setter for property date.
    }
    public void setHours(int hours){
        //Setter for property hours.
    }
    @Override
    public String toString(){
        //Creates a string representation of the consultant time.
    }
    
}
