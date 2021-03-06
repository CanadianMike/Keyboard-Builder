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
import javax.swing.JOptionPane;

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
    }
    public void saveCart (String name) throws IOException
    {
        String fileName = name;
        //spcify save file
        File saveFile = new File("src\\main\\Resources\\"+fileName+".txt");
        if (saveFile.createNewFile())
       {JOptionPane.showMessageDialog(null, fileName + " successfully saved");}
       else{System.out.println("File already exists");}
        FileWriter fw = new FileWriter("src\\main\\Resources\\"+fileName+".txt");
        PrintWriter saveConfig = new PrintWriter(fw);
        String cart[] = cartItems.toArray(String[]::new);
        System.out.print(cartItems);
        for (int i = 0; i<cart.length;i++)
        {
            saveConfig.println(cart[i]);
        }
        fw.close();
        saveConfig.close();
        
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
            
      
        }
    return inputValue;
}


}
