/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scg.domain;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Timecard creates timecard for each consultant.
 * @author dixya
 */
public class TimeCard {
    private final Consultant consultant;
    private final LocalDate weekStartingDay;
    private final List<ConsultantTime> consultingHours;
    int billableHours=0;
    int nonBillableHours=0;
    int totalHours=0;
    
    /**
     * Two parameter constructor of timecard
     * @param consultant instance of consultant
     * @param weekStartingDay starting date
     */
    public TimeCard(Consultant consultant, LocalDate weekStartingDay){
        this.consultant=consultant;
        this.weekStartingDay=weekStartingDay;
        // start empty consulting hours for this consultant
        this.consultingHours = new ArrayList<>();
    }
    
    /**
     * Add a ConsultantTime object to this TimeCard.
     * @param consultantTime 
     */
    public void addConsultantTime(ConsultantTime consultantTime){
        consultingHours.add(consultantTime);
    }
    /**
     * Getter for week starting date
     * @return week starting day.
     */
    public LocalDate getWeekStartingDay(){
        return weekStartingDay;
    }
    
    /**
     * Returns the billable hours (if any) in this TimeCard for the specified Client.
     * @param clientName
     * @return billable hours for clientName
     */
    public List<ConsultantTime> getBillableHoursForClient(String clientName) {
        List<ConsultantTime> clientHours = new ArrayList<>();
        for(ConsultantTime c : consultingHours) {
            if(c.getAccount().getName().equals(clientName) && c.isBillable()) {
                clientHours.add(c);
            }
        }
        return clientHours;
    }
    
    /**
     * Getter for property consultant.
     * @return consultant
     */
    public Consultant getConsultant() {
        return consultant;
    }
    /**
     * Getter for consulting hours.
     * @return 
     */
    public List<ConsultantTime> getConsultingHours(){
        return consultingHours;
    }
    /**
     * Getter for property billableHours.
     * @return billable hours.
     */
    
    public int getTotalBillableHours() {
         billableHours = 0;
        for(ConsultantTime c : consultingHours) {
            if(c.isBillable()) {
                billableHours += c.getHours();
            }
        }
        return billableHours;
    }
    /**
     * Getter for property totalHours.
     * @return total hours
     */
    public int getTotalHours() {
         totalHours = 0;
        for (ConsultantTime c : consultingHours) {
            totalHours += c.getHours();
        }
        return totalHours;
    }
    /**
     * Getter for property totalNonBillableHours.
     * @return non billable hours
     */
    
    public int getTotalNonBillableHours() {
        nonBillableHours= getTotalHours() - getTotalBillableHours();
        return nonBillableHours;
    }
    /**
     * Getter for property weekStartingDay.
     * @return week starting day
     */
    
    /**
     * Create a string representation of this object, suitable for printing the entire time card.
     * @return String value
     */
    
    public String toReportString() {
        StringBuffer sb = new StringBuffer();
        sb.append("===============================================================\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        sb.append("Consultant: " + consultant.getName() + "\t\t\t\t\t" + " Week Starting: " + weekStartingDay.format(formatter));
        sb.append("\n");
        sb.append("Billable Time:\n");
        sb.append("Account:\t\t\tDate\t\t\tHours\t\t\t\t\tSkill\n");
        sb.append("--------\t\t\t------------\n");
        for(ConsultantTime c : consultingHours) {
            if(c.isBillable()) {
                sb.append(c.getAccount().getName() + "\t\t" + c.getDate() + "\t\t" + c.getHours() + "\t\t\t\t" + c.getSkill());
                sb.append("\n");
            }
        }
        sb.append("NonBillable Time:\n");

        for(ConsultantTime c : consultingHours) {
            if(!c.isBillable()) {
                sb.append(c.getAccount().getName() + "\t\t" + c.getDate() + "\t\t" + c.getHours() + "\t\t\t\t" + c.getSkill());
                sb.append("\n");
            }
        }  
        sb.append("Summary:\n");
        sb.append("Total Billable:\t\t\t\t"+billableHours+"\n");
        sb.append("Total non-Billable-hours:\t\t"+nonBillableHours+"\n");
        sb.append("Total Hours:\t\t\t\t"+totalHours+"\n\n");
        return sb.toString();
    }
    /**
     * Create a string representation of this object, consisting of the consultant name and the time card week starting day.
     * @return string
     */
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(consultant.getName());
        sb.append(weekStartingDay);
        return sb.toString();
        
    }
}
