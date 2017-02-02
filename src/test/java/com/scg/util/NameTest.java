/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scg.util;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dixya
 */
public class NameTest {
    
    public NameTest() {
    }
    @Test
    public void testGetterSetter(){
        Name newName=new Name("first","second","third");
        Assert.assertEquals("first",newName.getLastName());
        newName.setFirstName("Hello");
        newName.setMiddleName("Arjun");
        newName.setLastName("Kumar");        
        assertEquals("Hello", newName.getFirstName());
        assertEquals("Arjun", newName.getMiddleName());
        assertEquals("Kumar", newName.getLastName());        
        
    }
    @Test
    public void testToString(){
        Name newName=new Name("last","first","middle");
        assertEquals("last,first,middle",newName.toString());
        
    }

    
}
