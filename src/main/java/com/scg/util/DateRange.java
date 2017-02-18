/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scg.util;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author dixya
 */
public class DateRange {
    LocalDate startingDate;
    LocalDate endingDate;
    Month month;
    int year;
    String start;
    String end;
    /**
     * Construct a DateRange given two dates.
     * @param startDate
     * @param endDate 
     */
    DateRange(LocalDate startDate, LocalDate endDate){
        this.startingDate=startDate;
        this.endingDate=endDate;
    }
    
    /**
     * Construct a DateRange for the given month.
     * @param month
     * @param year 
     */
    DateRange(Month month, int year){
        this.month=month;
        this.year=year;
        
    }
    
    /**
     * Construct a DateRange given two date strings in the correct format.
     * @param start     the start date for this DateRange.     
     * @param end the end date for this DateRange.
     */
    DateRange(String start, String end){
        this.start=start;
        this.end=end;
        
        
    }
    
    /**
     * Returns the end date for this DateRange.
     * @return 
     */
   public LocalDate getEndDate(){
       return endingDate;
       
   }
   
   /**
    * Returns the start date for this DateRange.
    * @return 
    */
   LocalDate getStartDate(){
       return startingDate;
       
   }
   /**
    * Returns true if the specified date is within the range start date <= date <= end date.
    * @param date the date to check for being within this DateRange.
    * @return true if the specified date is within this DateRange.
    */
   
   boolean isInRange(LocalDate date){
        return ((date.isEqual(startingDate)||date.isAfter(startingDate))&& (date.isEqual(endingDate)||date.isBefore(endingDate)));
       
   }
    
}
