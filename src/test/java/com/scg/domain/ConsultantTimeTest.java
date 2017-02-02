/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scg.domain;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dixya
 */
public class ConsultantTimeTest {
    
    public ConsultantTimeTest() {
    }

    /**
     * Test of equals method, of class ConsultantTime.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        ConsultantTime instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class ConsultantTime.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ConsultantTime instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccount method, of class ConsultantTime.
     */
    @Test
    public void testGetAccount() {
        System.out.println("getAccount");
        ConsultantTime instance = null;
        Account expResult = null;
        Account result = instance.getAccount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class ConsultantTime.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        ConsultantTime instance = null;
        LocalDate expResult = null;
        LocalDate result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHours method, of class ConsultantTime.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        ConsultantTime instance = null;
        int expResult = 0;
        int result = instance.getHours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSkill method, of class ConsultantTime.
     */
    @Test
    public void testGetSkill() {
        System.out.println("getSkill");
        ConsultantTime instance = null;
        Skill expResult = null;
        Skill result = instance.getSkill();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBillable method, of class ConsultantTime.
     */
    @Test
    public void testIsBillable() {
        System.out.println("isBillable");
        ConsultantTime instance = null;
        boolean expResult = false;
        boolean result = instance.isBillable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccount method, of class ConsultantTime.
     */
    @Test
    public void testSetAccount() {
        System.out.println("setAccount");
        Account account = null;
        ConsultantTime instance = null;
        instance.setAccount(account);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class ConsultantTime.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        LocalDate date = null;
        ConsultantTime instance = null;
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHours method, of class ConsultantTime.
     */
    @Test
    public void testSetHours() {
        System.out.println("setHours");
        int hours = 0;
        ConsultantTime instance = null;
        instance.setHours(hours);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ConsultantTime.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ConsultantTime instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
