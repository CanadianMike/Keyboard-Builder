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
import java.util.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Hao
 */
    public class Cart {
    public ArrayList<String> cartItems = new ArrayList<String>();

    public static void initCart () throws IOException  
    {   
        //specify file for creation
        File cartFile = new File("src\\main\\Resources\\cart.txt");
       if (cartFile.createNewFile())
       {System.out.println("File created");}
       else{System.out.println("File already exists");}
        System.out.println("files written!");  
    }
    public void addCart (String addItem) 
    {
        cartItems.add(addItem);
    }
    public void removeCart (String removeItem)
    {
        int index = Integer.parseInt(removeItem)-1;
        System.out.println("index "+index);
        try {
       cartItems.remove(index);
        }
        catch (IndexOutOfBoundsException e)
        {
            JOptionPane.showMessageDialog(null,"Error: incorrect value");
        }
    }
    public String[] displayCart ()
    {
        String cart[] = cartItems.toArray(String[]::new);
        return (cart);
    }
    public String showInputDialog()
{
    String inputValue = JOptionPane.showInputDialog("Please input position of item in cart:");
    

        if (inputValue == null || inputValue.isEmpty() || inputValue.matches("[A-Za-z]*"))
        {
            JOptionPane.showMessageDialog(null,"Error: incorrect value");
            inputValue = showInputDialog();
        }
        else if (Integer.parseInt(inputValue)==JOptionPane.CANCEL_OPTION)
        {
            System.out.println("cancelled");
        }
        else 
        {
//            try 
//            {
//            int input = Integer.parseInt(inputValue);
//            
//            }
//            catch (NumberFormatException e)
//            {
//                JOptionPane.showMessageDialog(null,"Error: incorrect int value");
//                showInputDialog();
//            }
            
      
        }
    return inputValue;
}
//    public void editConfirm (String configName)
//    {
//       
//    }

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
