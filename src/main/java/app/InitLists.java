/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;
import com.scg.util.ListFactory;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 *
 * @author dixya
 */
public class InitLists implements Serializable {

    public static void main(String[] args) {
        final List<Consultant> consultants = new ArrayList<>();
        final List<TimeCard> timeCards = new ArrayList<>();
        final List<ClientAccount> accounts = new ArrayList<>();
        ListFactory.populateLists(accounts, consultants, timeCards);     
    

    // serialization for client account
    
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ClientList.ser"));
            out.writeObject(accounts);
            out.close();
//            ByteArrayOutputStream bos=new ByteArrayOutputStream();
//            out=new ObjectOutputStream(bos);
//            out.writeObject(accounts);
//            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        //serialization for timecard
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("TimeCardList.ser"));
            out.writeObject(timeCards);
            out.close();
//            ByteArrayOutputStream bos=new ByteArrayOutputStream();
//            out=new ObjectOutputStream(bos);
//            out.writeObject(timeCards);
//            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    

}
