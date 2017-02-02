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

public enum Skill {
    //For now, set rate to zero for all skill
    PROJECT_MANAGER(0),
    SYSTEM_ARCHITECT(0),
    SOFTWARE_ENGINEER(0),
    SOFTWARE_TESTER(0),
    UNKNOWN_SKILL(0);
    
    private final int rate;
    
    private Skill(int rate) {
        this.rate = rate;
    }
    
    
    public int getRate() {
        return rate;
    }
    @Override
    public String toString(){
        return name();
        
    }
}
