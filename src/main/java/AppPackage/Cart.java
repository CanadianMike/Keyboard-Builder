/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hao
 */
public class Cart {
    public ArrayList<String> cartItems = new ArrayList<String>();
    String item = "";
    Cart (String additem)
    {
        item = additem;
    }
    static void initCart () throws IOException  
    {   
        //specify file for creation
        File cartFile = new File("src\\main\\java\\AppPackage\\cart.txt");
       if (cartFile.createNewFile())
       {System.out.println("File created");}
       else{System.out.println("File already exists");}
        System.out.println("files written!");  
    }
    public void addCart (String cartItem) 
    {
        cartItems.add(cartItem);
        
        //declare file writer
//        FileWriter cartfw = new FileWriter("src\\main\\java\\AppPackage\\cart.txt");
//        cartfw.write(cartItem);
//        PrintWriter cartOutput = new PrintWriter(cartfw);
//        cartOutput.println(cartItem);
//        cartOutput.close();
//        cartfw.close();
    }
    public void showCart ()
    {
        System.out.print(cartItems);
    }

    //change to return string to be used in main cart method in future
//    static void switchAddCart (String cartItem)
//    {
//        String switchItem = cartItem;
//    }
//    static void layoutAddCart (String cartItem)
//    {
//        String layoutSelection = cartItem;
//    }
//    static void keycapAddCart (String cartName)
//    {
//        String keycapItem = cartItem;
//    }
}
