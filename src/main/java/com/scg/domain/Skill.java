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
    PROJECT_MANAGER,
    SYSTEM_ARCHITECT,
    SOFTWARE_ENGINEER,
    SOFTWARE_TESTER,
    UNKNOWN_SKILL;
    
    private final int rate=0;
    
    
    public int getRate() {
        return rate;
    }
    @Override
    public String toString(){
        return "no skill";
        
    }
}
