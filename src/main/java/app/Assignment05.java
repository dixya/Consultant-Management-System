/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.scg.domain.ClientAccount;
import com.scg.domain.Invoice;
import com.scg.domain.TimeCard;
import com.scg.util.DateRange;
import com.scg.util.TimeCardListUtil;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import static java.lang.Math.log;
import static java.rmi.server.LogStream.log;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dixya
 */
public class Assignment05 {
        private static final Month INVOICE_MONTH = Month.MARCH;
        private static final int INVOICE_YEAR = 2006;
        private static final Logger log = LoggerFactory.getLogger("Assignment05");



    
    
       /**
     * Create invoices for the clients from the timecards.
     *
     * @param accounts the accounts to create the invoices for
     * @param timeCards the time cards to create the invoices from
     *
     * @return the created invoices
     */
    private static List<Invoice> createInvoices(final List<ClientAccount> accounts,
                                            final List<TimeCard> timeCards) {
        final List<Invoice> invoices = new ArrayList<>();

        final List<TimeCard> timeCardList = TimeCardListUtil
                .getTimeCardsForDateRange(timeCards, new DateRange(INVOICE_MONTH, INVOICE_YEAR));
        accounts.stream().map((account) -> new Invoice(account, INVOICE_MONTH, INVOICE_YEAR)).map((invoice) -> {
            invoices.add(invoice);
            return invoice;
        }).forEach((invoice) -> {
            timeCardList.stream().forEach((currentTimeCard) -> {
                invoice.extractLineItems(currentTimeCard);
            });
        });

        return invoices;
    }
    
     /**
     * Print the invoice to a PrintStream.
     *
     * @param invoices the invoices to print
     * @param out The output stream; can be System.out or a text file.
     */
    private static void printInvoices(final List<Invoice> invoices, final PrintStream out) throws IOException {
        invoices.stream().forEach((invoice) -> {
            out.println(invoice.toReportString());
        });
    }

    
    
    
    
    
    
    
    public static void main(String[] args) throws IOException{
        
        List<ClientAccount> clientList;
        List<TimeCard> timeCardList;
        
        try {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("ClientList.ser"))) {
                Object o = in.readObject();
                 clientList = (List<ClientAccount>) o;
            }
                
             try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("TimeCardList.ser"))){
                Object o = in.readObject();
                timeCardList = (List<TimeCard>) o;                
            }
                     // Create the Invoices
                     final List<Invoice> invoices = createInvoices(clientList, timeCardList);
                     
                     
                      // Print them
        System.out.println();
        System.out.println("==================================================================================");
        System.out.println("=============================== I N V O I C E S ==================================");
        System.out.println("==================================================================================");
        System.out.println();
        printInvoices(invoices, System.out);
        // Now print it to a file
        PrintStream writer;
        try {
            writer = new PrintStream(new FileOutputStream("invoice.txt"));
            printInvoices(invoices, writer);
        } catch (final IOException ex) {
            log.error("Unable to print invoice.", ex);
        }

             
             
}
catch(ClassNotFoundException ex) {
ex.printStackTrace();
}
        
        
        
        
        
    }
        
     
    
}

