/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

/**
 *
 * @author Michael W
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Switches {
    static void initKeyswitches () throws IOException
    {
        File keyswitchFile = new File("src\\main\\Resources\\switches.txt");
       if (keyswitchFile.createNewFile())
       {System.out.println("File created");}
       else{System.out.println("File already exists");}
    }
    public String getKeyswitchLinkName (String link) throws IOException
    {
        String repositoryName = "";
        String keyswitchName = "";
        try {
      // Here we create a document object and use JSoup to fetch the website
      Document switchDoc = Jsoup.connect(link).get(); //site for keycap
      // Get the list of repositories
      Elements repositories = switchDoc.getElementsByClass("product-main");

      for (Element repository : repositories) {
         repositoryName = repository.getElementsByClass("product-title").text();         
      }
    // In case of any IO errors, we want the messages written to the console
    } catch (IOException e) {
        System.out.println("ERROR");
      e.printStackTrace();
    }
        catch (IllegalArgumentException e) {
        System.out.println("ERROR: Incorrect Link");
        JOptionPane.showMessageDialog(null,"Error: Incorrect Link!","ERROR",JOptionPane.ERROR_MESSAGE);
    }
       keyswitchName = repositoryName;
        return keyswitchName;
    }
    
    public static void addKeyswitchLink (String link, String name) throws IOException
    {
        String keyswitchLink = link;
        String keyswitchName = name;
        //declare file writer for current keycap
        FileWriter kw = new FileWriter("src\\main\\Resources\\"+keyswitchName+".txt");
        PrintWriter addKeyswitchLink = new PrintWriter(kw);
        //declare file writer to main keycap list
        FileWriter fw = new FileWriter("src\\main\\Resources\\switches.txt");
        PrintWriter addLinkMain = new PrintWriter(fw);
       
        String repositoryName = "";
        String repositoryPrice = "";
        
        try {
      // Here we create a document object and use JSoup to fetch the website
      Document switchDoc = Jsoup.connect(keyswitchLink).get(); //site for cherry switches

      // Get the list of repositories
      Elements repositories = switchDoc.getElementsByClass("product-main");

      for (Element repository : repositories) {
        // Extract the title and price
         repositoryName = repository.getElementsByClass("product-title").text();
         repositoryPrice = repository.getElementsByClass("price__current  ").text();
         
         //write the switch data to individual switch file 
         
         addKeyswitchLink.println(repositoryName);
         addKeyswitchLink.println(repositoryPrice);
         addKeyswitchLink.println(keyswitchLink);
         addLinkMain.println(repositoryName+" "+repositoryPrice);
         
         //close scanner/writer
         fw.close();
         addLinkMain.close();        
         kw.close();
         addKeyswitchLink.close();

         System.out.println("files written!");
      }
    // In case of any IO errors, we want the messages written to the console
    } catch (IOException e) {
        System.out.println("ERROR");
      e.printStackTrace();
    }
        catch (IllegalArgumentException e) {
        System.out.println("ERROR: Incorrect Link");
        JOptionPane.showMessageDialog(null,"Error: Incorrect Link!","ERROR",JOptionPane.ERROR_MESSAGE);
    }
    }
    
    
    public ImageIcon getKeyswitchImage (String keyswitchElement)
    {
        String getName[] = keyswitchElement.split(" $");
        String name = getName[0];
        ImageIcon icon = new ImageIcon("src\\main\\Resources\\"+name+".png");
         return icon;
    }
    
    public String getKeyswitchInfo (String keyswitchElement)
    {
        String listElement = keyswitchElement;
        String getName[] = listElement.split(" \\$");
        String name = getName[0];

        String keyswitchInfo = "";
        int maxIndx = 0;
        String rawKeyswitchData[] = new String [100];
        try {
        File keycapDataFile = new File("src\\main\\Resources\\"+name+".txt");
        //declare file scanner
        Scanner scanFile = new Scanner(keycapDataFile);
        while (scanFile.hasNext()) //attr each element to the next line in the file
        {
            rawKeyswitchData[maxIndx] = scanFile.nextLine();  
            maxIndx++; 
        }
        scanFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int kc = 0 ; kc < maxIndx; kc++)
        {
            keyswitchInfo=keyswitchInfo+" "+rawKeyswitchData[kc];
        }
        return keyswitchInfo;
    }
    
    public void writeKeyswitchImage (String keyswitchLink,String keyswitchName) throws IOException
    {
        String link = keyswitchLink;
        String name = keyswitchName;
        ArrayList<Elements> images = new ArrayList<Elements>();
         String imgLink = "";
        String links;
        String test = "";
        
        try {
      // Here we create a document object and use JSoup to fetch the website
      Document switchDoc = Jsoup.connect(link).get(); //site for cherry switches

      // Get the list of repositories
      Elements repositories = switchDoc.getElementsByClass("product-gallery--image-background");  //product--container layout--two-col
      
      Element bodyElement = switchDoc.getElementsByTag("body").first(); // new
      System.out.println( switchDoc.select("body img").text()); // new     
        links = switchDoc.select("body img").text();
//      images.add(links);
      String imgLinks [] = links.split("img src");
      System.out.println(links);
      for (int i = 0; i<imgLinks.length;i++)
      {
          System.out.println(imgLinks[i]+"wooo in arr");
      }
      } catch (IOException ex) {
        System.err.println("There was an error: " + ex);
        }
        
    }


}
