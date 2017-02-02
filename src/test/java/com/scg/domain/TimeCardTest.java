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
public class TimeCardTest {
    
    public TimeCardTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    /**
     * Test of addConsultantTime method, of class TimeCard.
     */
    @Test
    public void testAddConsultantTime() {
        System.out.println("addConsultantTime");
        ConsultantTime consultantTime = null;
        TimeCard instance = null;
        instance.addConsultantTime(consultantTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsultant method, of class TimeCard.
     */
    @Test
    public void testGetConsultant() {
        System.out.println("getConsultant");
        TimeCard instance = null;
        Consultant expResult = null;
        Consultant result = instance.getConsultant();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalBillableHours method, of class TimeCard.
     */
    @Test
    public void testGetTotalBillableHours() {
        System.out.println("getTotalBillableHours");
        TimeCard instance = null;
        int expResult = 0;
        int result = instance.getTotalBillableHours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalHours method, of class TimeCard.
     */
    @Test
    public void testGetTotalHours() {
        System.out.println("getTotalHours");
        TimeCard instance = null;
        int expResult = 0;
        int result = instance.getTotalHours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalNonBillableHours method, of class TimeCard.
     */
    @Test
    public void testGetTotalNonBillableHours() {
        System.out.println("getTotalNonBillableHours");
        TimeCard instance = null;
        int expResult = 0;
        int result = instance.getTotalNonBillableHours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeekStartingDay method, of class TimeCard.
     */
    @Test
    public void testGetWeekStartingDay() {
        System.out.println("getWeekStartingDay");
        TimeCard instance = null;
        LocalDate expResult = null;
        LocalDate result = instance.getWeekStartingDay();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toReportString method, of class TimeCard.
     */
    @Test
    public void testToReportString() {
        System.out.println("toReportString");
        TimeCard instance = null;
        String expResult = "";
        String result = instance.toReportString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class TimeCard.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TimeCard instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
