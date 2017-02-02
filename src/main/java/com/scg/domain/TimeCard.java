/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scg.domain;
import com.scg.util.Name;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author dixya
 */
public class TimeCard extends Object{
    Consultant consultant=new Consultant(new Name("Lamichhane","Dixya","Kumari"));
    ConsultantTime consultantTime;
    ClientAccount clientName=new ClientAccount("Acme Industries",new Name("hello","hi"));
    java.time.LocalDate weekStartingDay;
    int totalHours=0;
    int hours=0;
    int totalBillableHours=0;
    int totalNonBillableHours=0;
    LocalDate std_work_day;
    
    int total_time_cards=0;
    public TimeCard(Consultant consultant, java.time.LocalDate weekStartingDay){
        this.consultant=consultant;
        this.weekStartingDay=weekStartingDay;
        //Creates a new instance of TimeCard
    }
    public TimeCard(int no_of_time_cards){
        this.total_time_cards=no_of_time_cards;
    }
    public void addConsultantTime(ConsultantTime consultantTime){
        this.consultantTime=consultantTime;
           // totalHours=0;
           // totalBillableHours=0;
            //totalNonBillableHours=0;
            std_work_day=consultantTime.getDate();
             hours=consultantTime.getHours();
            //LocalDate currentDay=consultantTime.getDate();
            Account account=consultantTime.getAccount();
            Skill skilltype=consultantTime.getSkill();
            
            if(consultantTime.getAccount().isBillable()==true){        
                 totalBillableHours+=hours;
            }
            else{
                for (NonBillableAccount c : NonBillableAccount.values())
                  
                totalNonBillableHours+= hours;
            }
            totalHours=totalBillableHours+totalNonBillableHours;
        //Add a ConsultantTime object to this TimeCard.
    }
//    public List<ConsultantTime> getConsultingHours(){
//        //Getter for property consultingHours.
//        List<ConsultantTime> l=new ArrayList<>();
//        l.add(consultantTime);
//        return l;
//
//    }

//   public List<ConsultantTime> getBillableHoursForClient(String clientName){
//        
//        List<ConsultantTime> billableHours = new ArrayList<>();
//        billableHours.add(ConsultantTime.class.hours);
//            
//        
//        
//        //Returns the billable hours (if any) in this TimeCard for the specified Client.
//    }
    public Consultant getConsultant(){
        return consultant;//Getter for property consultant.
    }
   // List<ConsultantTime> getConsultingHours(){
        
         //Getter for property consultingHours.
    //}
    public int getTotalBillableHours(){
        return totalBillableHours;//Getter for property billableHours.
    }
    public int getTotalHours(){
        return totalHours;//Getter for property totalHours.
    }
    public int getTotalNonBillableHours(){
        return totalNonBillableHours;//Getter for property totalNonBillableHours.
    }
    public java.time.LocalDate getWeekStartingDay(){
        return weekStartingDay;//Getter for property weekStartingDay.
    }
    public String toReportString(){
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.print("Consultant:" +consultant.getName()+"             "+ "Week Starting:");
        //StringBuilder card1=new StringBuilder();
        //card1.append("Consultant:");
        // card1.append(consultant.getName());
        // card1.append("                   Week Starting: ");
         DateTimeFormatter formatter =DateTimeFormatter.ofPattern("MMM dd, yyyy");
         System.out.print(std_work_day.format(formatter));
        System.out.printf("%1$tb %1$td, %1$tY%n", std_work_day);
        System.out.println("Billable Time:");
        //System.out.println( "Account"     "date"    "hours"     "skill");
        System.out.println( "-----------------------------------------------------");     

        

        System.out.printf("%1$acc %1$d %1$h %1$s", "account","date","hours","skill");
        StringBuilder card1=new StringBuilder();
        card1.append(consultantTime.getDate());
        card1.append(consultantTime.getAccount());
        card1.append(consultantTime.getSkill());
        card1.append(consultantTime.hours);
        return card1.toString();



        
        
        

        // card1.append(std_work_day);
        // System.out.println("/n/n");
        // card1.append("Billable Time:/n");
        // card1.append("Account")
        // return card1.toString();
        //Create a string representation of this object, suitable for printing the entire time card.
    }
    @Override
    public String toString(){
        return "test";
        //Create a string representation of this object, consisting of the consultant name and the time card week starting day.
    }
    
}
