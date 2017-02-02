/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scg.domain;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author dixya
 */
public class ConsultantTime {
    private LocalDate date;
    private Account account;
    private final Skill skillType;
    private int hours;

    public ConsultantTime(LocalDate date, Account account, Skill skillType, int hours){
        this.date=date;
        this.account = account;
        this.skillType=skillType;
        setHours(hours);
    }

    public Account getAccount() {
        return account;//Getter for property account.
    }
    public LocalDate getDate(){
        return date;
        
    }
    
    /**
     * Getter for property hours.
     * @return Value of property hours.
     */
    public int getHours() {
        return hours;
    }
    
    /**
     * Getter for property skill.
     * @return  Value of property skill.
     */
    public Skill getSkill(){
        return skillType;
    }
    public boolean isBillable(){
        return account.isBillable();
    }
    public void setAccount(Account account){
        this.account=account;//Setter for property account.
    }
    public void setDate(LocalDate date){  
       this.date=date; //Setter for property date.
    }

    /**
     * Setter for property hours.
     * @param hours New value of property hours must be > 0.
     * @throws IllegalArgumentException if the hours are <= 0. 
     */
    public void setHours(int hours) throws IllegalArgumentException{
        if(hours<=0)
            throw new IllegalArgumentException("New value of property hours must be > 0.");
        this.hours=hours;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.date);
        hash = 67 * hash + Objects.hashCode(this.account);
        hash = 67 * hash + Objects.hashCode(this.skillType);
        hash = 67 * hash + this.hours;
        return hash;
    }

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
        if (!Objects.equals(this.account, other.account)) {
            return false;
        }
        if (this.skillType != other.skillType) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("ConsultantTime(" + date + ", " + account.getName() + ", " + skillType + ", " + hours + ")");
        return sb.toString();//Creates a string representation of the consultant time.
    }
    
}
