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
 *
 * @author dixya
 */
public class TimeCard {
    private final Consultant consultant;
    private final LocalDate weekStartingDay;
    private final List<ConsultantTime> consultingHours;
    
    public TimeCard(Consultant consultant, LocalDate weekStartingDay){
        this.consultant=consultant;
        this.weekStartingDay=weekStartingDay;
        // start empty consulting hours for this consultant
        this.consultingHours = new ArrayList<>();
    }
    
    public void addConsultantTime(ConsultantTime consultantTime){
        consultingHours.add(consultantTime);
    }
    
    public List<ConsultantTime> getBillableHoursForClient(String clientName) {
        List<ConsultantTime> clientHours = new ArrayList<>();
        for(ConsultantTime c : consultingHours) {
            if(c.getAccount().getName().equals(clientName) && c.isBillable()) {
                clientHours.add(c);
            }
        }
        return clientHours;
    }
    
    public Consultant getConsultant() {
        return consultant;
    }
    
    public int getTotalBillableHours() {
        int billableHours = 0;
        for(ConsultantTime c : consultingHours) {
            if(c.isBillable()) {
                billableHours += c.getHours();
            }
        }
        return billableHours;
    }
    
    public int getTotalHours() {
        int totalHours = 0;
        for (ConsultantTime c : consultingHours) {
            totalHours += c.getHours();
        }
        return totalHours;
    }
    
    public int getTotalNonBillableHours() {
        return getTotalHours() - getTotalBillableHours();
    }
    
    public LocalDate getWeekStartingDay() {
        return weekStartingDay;
    }
    
    public String toReportString() {
        StringBuffer sb = new StringBuffer();
        sb.append("===============================================================\n");
        sb.append("Consultant: " + consultant.getName() + "\t\t" + " Week Starting: " + weekStartingDay);
        sb.append("\n");
        sb.append("Billable Time:\n");
        sb.append("Account:\t\tDate\tHours\tSkill\n");
        sb.append("--------\t\t-----\t-----\t------\n");
        for(ConsultantTime c : consultingHours) {
            if(c.isBillable()) {
                sb.append(c.getAccount().getName() + "\t\t" + c.getDate() + "\t" + c.getHours() + "\t" + c.getSkill());
                sb.append("\n");
            }
        }
        for(ConsultantTime c : consultingHours) {
            if(! c.isBillable()) {
                sb.append(c.getAccount().getName() + "\t\t" + c.getDate() + "\t" + c.getHours() + "\t" + c.getSkill());
                sb.append("\n");
            }
        } 
        sb.append("===============================================================\n");
        return sb.toString();
    }
}
