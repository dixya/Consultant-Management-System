/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scg.util;

import com.scg.domain.TimeCard;
import java.util.Comparator;

/**
 * Compares two TimeCard objects by ascending consultant, timecard week, totalHours, totalBillableHours and totalNonBillableHours.
 * @author dixya
 */
public class TimeCardConsultantComparator implements Comparator<TimeCard>{
    public TimeCardConsultantComparator() {
        
    }
    /**
     * Compares its two arguments for order.
     * @param firstTimeCard     the first object to be compared.
    
     * @param secondTimeCard  the second object to be compared.
     * @return 
     */
    public int compare(TimeCard firstTimeCard, TimeCard secondTimeCard){
        
    }
    
}
