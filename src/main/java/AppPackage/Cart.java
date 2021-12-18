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

/**
 *
 * @author Hao
 */
public class Cart {
    static void initCart () throws IOException  
    {   
        //specify file for creation
        File cartFile = new File("C:\\Users\\Hao\\Documents\\NetBeansProjects\\Keyboard-Builder\\src\\main\\java\\AppPackage\\cart.txt");
       if (cartFile.createNewFile())
       {System.out.println("File created");}
       else{System.out.println("File already exists");}
        System.out.println("files written!");  
    }
    static void addCart (String cartItem) throws IOException
    {
        //declare file writer
        FileWriter cartfw = new FileWriter("C:\\Users\\Hao\\Documents\\NetBeansProjects\\Keyboard-Builder\\src\\main\\java\\AppPackage\\cart.txt");
        PrintWriter cartOutput = new PrintWriter(cartfw);
        cartOutput.println(cartItem);
        cartOutput.close();
        cartfw.close();
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
