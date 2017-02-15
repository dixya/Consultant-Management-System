/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scg.domain;

import com.scg.util.Address;
import com.scg.util.StateCode;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

/**
 *
 * @author dixya
 */
public class Invoice {

    final private ClientAccount client;
    final private Month invoiceMonth;
    final private int invoiceYear;
    private int itemsPerPage = 5;
    private int itemsPrinted = 0;
    private int totHours;
    private int totCharges;

//     final String bizName=null;
//     final String bizStreet;
//     final String bizCity;
//     final String bizState;
//     final String bizZip;
    public String bizName;
    Address bizAddress;
    private final static String propFileName = "invoice.properties";
    final List<InvoiceLineItem> lineItems;
    final List<ConsultantTime> billableHours;
    int nonBillableHours;
    LocalDate invoiceDate;
    LocalDate startDate;

//    static{
//         Properties prop = new Properties();
//            InputStream inputStream=Invoice.class.getResourceAsStream(propFileName);
//            try{	
//            if (inputStream != null) {
//				prop.load(inputStream);
//			} else {
//				throw new FileNotFoundException("property file " + propFileName + " not found in the classpath");
//			}  
//
//            }
//            
//             catch (Exception e) {
//			System.out.println("Exception: " + e);
//		} 
//             bizName=prop.getProperty("businessName");
//            final String bizStreet=prop.getProperty("businessStreet");
//            final String bizCity=prop.getProperty("bizCity");
//            final String bizState=prop.getProperty("bizState");
//            final String bizZip=prop.getProperty("bizZip");
//            bizAddress=new Address(bizStreet,bizCity,StateCode.valueOf(bizState),bizZip);            
//        
//        
//    }
    /**
     * Construct an Invoice for a client.
     *
     * @param client
     * @param invoiceMonth
     * @param invoiceYear
     */
    public Invoice(ClientAccount client, Month invoiceMonth, int invoiceYear) {
        this.client = client;
        this.invoiceMonth = invoiceMonth;
        this.invoiceYear = invoiceYear;
        lineItems = new ArrayList<>();
        billableHours = new ArrayList<>();
        this.invoiceDate = LocalDate.now();
        startDate = LocalDate.of(invoiceYear, invoiceMonth, 1);
        totHours=0;
        totCharges=0;
        
    }

    /**
     * Add an invoice line item to this Invoice.
     *
     * @param lineItem
     */
    public void addLineItem(InvoiceLineItem lineItem) {
        lineItems.add(lineItem);
        totCharges+=lineItem.getCharge();
        totHours+=lineItem.getHours();

    }

    /**
     * Extract the billable hours for this Invoice's client from the input
     * TimeCard and add them to the line items.
     *
     * @param timeCard
     */
    public void extractLineItems(TimeCard timeCard) {
        billableHours.addAll(timeCard.getBillableHoursForClient(client.getName()));
        totHours=0;
        totCharges=0;
        for (ConsultantTime ct : billableHours) {
            final LocalDate currentDate = ct.getDate();
            if (currentDate.getMonth() == startDate.getMonth()) {
                InvoiceLineItem item = new InvoiceLineItem(currentDate, timeCard.getConsultant(), ct.getSkill(), ct.getHours());
                addLineItem(item);
                //lineItems.add(item);
            }
            
        }
        
    }

    /**
     * Get the client for this Invoice.
     */
    public ClientAccount getClientAccount() {
        return this.client;

    }

    /**
     * Get the invoice month.
     */
    public Month getInvoiceMonth() {
        return startDate.getMonth();
    }

    /**
     * Get the start date for this Invoice, this is the earliest date/time a
     * ConsultantTime instance may have and still be billed on this invoice.
     *
     * @return
     */
    public LocalDate getStartDate() {

        return startDate;

    }

    /**
     * Get the total charges for this Invoice.
     *
     * @return
     */
    public int getTotalCharges() {
        
        return totCharges;
    }

    /**
     * Get the total hours for this Invoice.
     *
     * @return
     */
    public int getTotalHours() {
        
        return totHours;

    }

    /**
     * Create a formatted string containing the printable invoice.
     *
     * @return
     * @throws java.io.IOException
     */
    public String toReportString() throws IOException {
        Invoice invoice;
        Properties prop = new Properties();
        String propFileName = "invoice.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        try {
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        bizName = prop.getProperty("businessName");
        final String bizStreet = prop.getProperty("businessStreet");
        final String bizCity = prop.getProperty("businessCity");
        final String bizState = prop.getProperty("businessState");
        final String bizZip = prop.getProperty("businessZip");
        bizAddress = new Address(bizStreet, bizCity, StateCode.valueOf(bizState), bizZip);

        InvoiceHeader header = new InvoiceHeader(bizName, bizAddress, client, this.getStartDate(), this.getInvoiceMonth());
        InvoiceFooter footer = new InvoiceFooter(bizName);

        StringBuilder sb = new StringBuilder();
        final Formatter formatter = new Formatter(sb, Locale.US);
        formatter.format("%s", header);
        int i = 0;
        for (i = 0, itemsPrinted =itemsPrinted- 1; i < lineItems.size(); i++, itemsPrinted++) {
            final InvoiceLineItem invoiceLineItem = lineItems.get(i);
            formatter.format("%s%n", invoiceLineItem);
            
            if (itemsPrinted % itemsPerPage == 0) {
                footer.incrementPageNumber();
                
                formatter.format("%s%n%s", footer, header);
                
            }
            
        }
        footer.incrementPageNumber();
        formatter.format("%n Total: %50d %10.2f", getTotalHours(), (double)getTotalCharges()).format("%s", footer);
        
        final String s = formatter.toString();
        formatter.close();
        return s;
//        for(InvoiceLineItem l:lineItems){
//            sb.append(l.date+"\t\t\t");
//            sb.append(l.getConsultant()+"\t\t\t\t");
//            sb.append(l.getSkill()+"\t\t\t");
//            sb.append(l.getHours()+"\t\t");
//            sb.append(l.getCharge()+"\n\n");
//        }

    }

    /**
     * Create a string representation of this object, suitable for printing.
     *
     * @return
     */
    public String toString() {
        String last = "=======";
        return last;

    }

}
