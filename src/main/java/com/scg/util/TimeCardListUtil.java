/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scg.util;

import com.scg.domain.TimeCard;
import java.util.ArrayList;
import java.util.List;
import com.scg.domain.Consultant;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 *
 * @author dixya
 */
public class TimeCardListUtil {
    static List<TimeCard> timeCard=new ArrayList<>();
    
    
    /**
     * Get a list of TimeCards for the specified consultant.
     * @param timeCards the list of time cards to extract the sub set from
     * @param consultant the consultant whose TimeCards will be obtained.
     * @return 
     */
    public static List<TimeCard> getTimeCardsForConsultant(List<TimeCard> timeCards, Consultant consultant){
        timeCards.stream().filter((t) -> (t.getConsultant()== consultant)).forEach((t) -> {
            timeCard.add(t);
        });
        return timeCard;
    }
    /**
     * Get a list of TimeCards that cover dates that fall within a date range.
     * @param timeCards the list of time cards to extract the sub set from.
     * @param dateRange The DateRange within which the dates of the returned TimeCards must fall.
     * @return 
     */
    public static List<TimeCard> getTimeCardsForDateRange(List<TimeCard> timeCards, DateRange dateRange){
        List<TimeCard> timeCardWithinDateRange;
        timeCardWithinDateRange = new ArrayList<>();
        timeCards.stream().forEach((TimeCard t) -> {
            LocalDate timeCardDate=t.getWeekStartingDay();
            if((timeCardDate.isEqual(dateRange.startingDate)||timeCardDate.isAfter(dateRange.startingDate))&& (timeCardDate.isEqual(dateRange.endingDate)||timeCardDate.isBefore(dateRange.endingDate)));
            timeCardWithinDateRange.add(t);
        });
        return timeCardWithinDateRange;
    }
    /**
     * Sorts this list into ascending order by consultant name..
     * @param timeCards the list of time cards to sort
     */
    public static void sortByConsultantName(List<TimeCard> timeCards){
        List<String> consultantName = null;
        Collections.sort(timeCards, new Comparator<TimeCard>() {
            @Override
            public int compare(TimeCard t, TimeCard t1) {
                Collections.sort(timeCards);
            }
            
        });
        timeCards.stream().forEach((t) -> {
            consultantName.add(t.getConsultant().getName().toString());
        });
        
        
    }
    /**
     * Sorts this list into ascending order, by the start date.
     * @param timeCards the list of time cards to sort
     */
    public static void sortByStartDate(List<TimeCard> timeCards){
        List<LocalDate> startDate=null;
        timeCards.stream().forEach((t) -> {
            startDate.add(t.getWeekStartingDay());
        });
        Collections.sort(startDate);
        
    }
    
}
