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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class cherrySwitch {
    static void cherryMethod () throws IOException
    {
        System.out.println("CHERRYTEST");
        File cherryFile = new File("C:\\Users\\Hao\\Documents\\NetBeansProjects\\Keyboard-Builder\\src\\main\\java\\AppPackage\\cherryswitch.txt");
       if (cherryFile.createNewFile())
       {System.out.println("File created");}
       else{System.out.println("File already exists");}
        //declare file writer
        FileWriter fw = new FileWriter("C:\\Users\\Hao\\Documents\\NetBeansProjects\\Keyboard-Builder\\src\\main\\java\\AppPackage\\cherryswitch.txt");
        PrintWriter output = new PrintWriter(fw);
//        String[] webData = new String[100];
        //declare file reader

        String repositoryName = "";
        String repositoryPrice = "";
//        String repositoryLinkName = "";
//        String repositoryLink = "";
        try {
      // Here we create a document object and use JSoup to fetch the website
      Document cherryDoc = Jsoup.connect("https://shockport.com/collections/switches-1/cherry").get(); //site for cherry switches
      // With the cherryDocument fetched, we use JSoup's title() method to fetch the title
      System.out.printf("Title: %s\n", cherryDoc.title());
      // Get the list of repositories
      Elements repositories = cherryDoc.getElementsByClass("collection-grid__wrapper");
      /**
       * For each repository, extract the following information:
       * 1. Name
       * 2. Price
       */
      for (Element repository : repositories) {
        // Extract the title
         repositoryName = repository.getElementsByClass("grid-product__title").text();
         repositoryPrice = repository.getElementsByClass("money").text();
//         repositoryLinkName = repository.getElementsByClass("grid-product__link").text();
//         repositoryLink = "https://shockport.com"+repositoryLinkName;
//         System.out.println(repositoryName);
//         System.out.println("\n");
        //write to file -> split by spaces into array -> keyswitches

        String[] switches  = repositoryName.split("(?i)Pin");
        String[] price = repositoryPrice.split(" ");

        for (int i = 0; i < switches.length; i++) //stepping thru each word
        {      
                output.println(switches[i]+"Pin "+price[i] + " per 10");  
        }
            output.close();
            fw.close();
            System.out.println("files written!");
      }
    // In case of any IO errors, we want the messages written to the console
    } catch (IOException e) {
        System.out.println("ERROR");
      e.printStackTrace();
    }
   
    }
}
