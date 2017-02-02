/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scg.domain;

import java.util.Objects;

/**
 *
 * @author dixya
 */
public class ConsultantTime extends Object{
    int hours;
    java.time.LocalDate date;
    Skill skillType;
    private Account account;
    public ConsultantTime(java.time.LocalDate date, Account account, Skill skillType, int hours){
        if(hours>0) 
        {
            this.hours=hours;
            this.date=date;
            this.skillType=skillType;//Creates a new instance of ConsultantTime.
            }
        else
            throw new IllegalArgumentException("Hour cannot be less than 0");
    }

   
    @Override
    public int hashCode(){
        int hash = 5;
        hash = 37 * hash + this.hours;
        hash = 37 * hash + Objects.hashCode(this.date);
       return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConsultantTime other = (ConsultantTime) obj;
        if (this.hours != other.hours) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    public Account getAccount() {
        return account;//Getter for property account.
    }
    public java.time.LocalDate getDate(){
        return date;
        
    }
    public int getHours(){
        return hours;//Getter for property hours.
    }
    public Skill getSkill(){
        return skillType;//Getter for property skill.
    }
    public boolean isBillable(){
        if(hours>0)
            return true;
        else
            return false;
        
        //Determines if the time is billable.
    }
    public void setAccount(Account account){
        this.account=account;//Setter for property account.
    }
    public void setDate(java.time.LocalDate date){  
       this.date=date; //Setter for property date.
    }
    public void setHours(int hours){
        if(hours>0)
        this.hours=hours;
        else 
        throw new IllegalArgumentException("hours should be grater than zero");//Setter for property hours.hours should be greater than 0.
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(hours);
        return sb.toString();//Creates a string representation of the consultant time.
    }
    
}
