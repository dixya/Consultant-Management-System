/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scg.domain;

import com.scg.util.Name;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dixya
 */
public class ClientAccountTest {
    
    public ClientAccountTest() {
    }

    @Test
    public void testClientAccount() {
        Name n=new Name("Coyote","Wiley");   
        ClientAccount clientAccount=new ClientAccount("Dixya Lamichhane", n);
        Assert.assertEquals(n, clientAccount.getContact()); //tests getName of clientAccount.
       Assert.assertEquals("Dixya Lamichhane", clientAccount.getName());
    }
    @Test
    public void testGetSetClientContact(){
        Name client=new Name("Hello","World");
        client.setFirstName("Hello");
        client.setMiddleName("Everyone");
        client.setLastName("World");
        Assert.assertEquals("World",client.getLastName());
        Assert.assertEquals("Hello",client.getFirstName());
        Assert.assertEquals("Everyone",client.getMiddleName());       
        
        
    }
    
}
