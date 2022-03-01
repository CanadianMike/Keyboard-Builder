/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Hao
 */
public class Keycap {
    static void initKeycaps() throws IOException {
        System.out.println("LINKWOOO");
        File keycapFile = new File("src\\main\\Resources\\keycaps.txt");
       if (keycapFile.createNewFile())
       {System.out.println("File created");}
       else{System.out.println("File already exists");}
        
    }
    
    public String getKeycapLinkName (String link) throws IOException
    {
        String repositoryName = "";
        String keycapName = "";
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
       keycapName = repositoryName;
        return keycapName;
    }
    

    public static void addKeycapLink (String link, String name) throws IOException
    {
//        System.out.println("LINKWOOO");
//        File cherryFile = new File("src\\main\\java\\AppPackage\\keycaps.txt");
//       if (cherryFile.createNewFile())
//       {System.out.println("File created");}
//       else{System.out.println("File already exists");}
        //declare file writer
//        FileWriter fw = new FileWriter("src\\main\\java\\AppPackage\\keycaps.txt");
//        PrintWriter outputToKeycaps = new PrintWriter(fw);
        String keycapLink = link;
        String keycapName = name;
        //declare file writer for current keycap
        FileWriter cw = new FileWriter("src\\main\\Resources\\"+keycapName+".txt");
        PrintWriter addKeycapLink = new PrintWriter(cw);
        //declare file writer to main keycap list
        FileWriter fw = new FileWriter("src\\main\\Resources\\keycaps.txt");
        PrintWriter addLinkMain = new PrintWriter(fw);
       
        String repositoryName = "";
        String repositoryPrice = "";
        
        try {
      // Here we create a document object and use JSoup to fetch the website
      Document switchDoc = Jsoup.connect(keycapLink).get(); //site for cherry switches

      // Get the list of repositories
      Elements repositories = switchDoc.getElementsByClass("product-main");

      for (Element repository : repositories) {
        // Extract the title and price
         repositoryName = repository.getElementsByClass("product-title").text();
         repositoryPrice = repository.getElementsByClass("price__current  ").text();
         
         //write the keycap data to individual keycap file 
         
         addKeycapLink.println(repositoryName);
         addKeycapLink.println(repositoryPrice);
         addKeycapLink.println(keycapLink);
         addLinkMain.println(repositoryName+" "+repositoryPrice);
         
         //close scanner/writer
         fw.close();
         addLinkMain.close();        
         cw.close();
         addKeycapLink.close();

          //write name and price to main keycaps file
//            outputToKeycaps.println(repositoryName+" "+repositoryPrice);
//            outputToKeycaps.close();
//            fw.close();
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
 
    public ImageIcon getKeycapImage (String keycapElement)
    {
        String getName[] = keycapElement.split(" $");
        String name = getName[0];
        ImageIcon icon = new ImageIcon("src\\main\\Resources\\"+name+".png");
//        String image = ("src\\main\\java\\Resources\\"+name+".png");
//        String keycapData[] = new String[10]; 
//        int indx = 0;
//        try 
//        {
//           File keycapDataFile = new File("src\\main\\java\\Resources\\"+name+".txt");
//        //declare file scanner
//        Scanner scanFile = new Scanner(keycapDataFile);
//        while (scanFile.hasNext()) //attr each element to the next line in the file
//        {
//            keycapData[indx] = scanFile.nextLine();  
//            indx++; 
//        }
//        scanFile.close(); 
//        }
//        catch (FileNotFoundException ex)
//        {
//            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String keycapLink = keycapData[2];
        return icon;
    }
    
    public String getKeycapInfo (String keycapElement)
    {
        String listElement = keycapElement;
        String getName[] = listElement.split(" \\$");
        String name = getName[0];

        String keycapInfo = "";
        int maxIndx = 0;
        String rawKeycapData[] = new String [100];
        try {
        File keycapDataFile = new File("src\\main\\Resources\\"+name+".txt");
        //declare file scanner
        Scanner scanFile = new Scanner(keycapDataFile);
        while (scanFile.hasNext()) //attr each element to the next line in the file
        {
            rawKeycapData[maxIndx] = scanFile.nextLine();  
            maxIndx++; 
        }
        scanFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int kc = 0 ; kc < maxIndx; kc++)
        {
            keycapInfo=keycapInfo+" "+rawKeycapData[kc];
        }
        return keycapInfo;
    }
        public void writeKeycapImage (String keycapLink,String keycapName) throws IOException
    {
        System.out.println("writeimage used");
        String link = keycapLink;
        String name = keycapName;
        ArrayList<Elements> images = new ArrayList<Elements>();

//        try {
//            
//        //Connect to the website and get the html – take a look at "page/" THis is how teh pages are seperated 
//        //product-gallery--image-background
//        Document doc = Jsoup.connect(link).get();
//        Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
//
//        //Get all elements with img tag ,
//        Elements img = doc.getElementsByTag("img");
//
//        for (Element el : images) {
//
//        //for each element get the srs url
//        String src = el.absUrl("src");
//
//        System.out.println("Image Found!");
//        System.out.println("src attribute is : " + src);
//
//        getImages(src);
//        }
//        } catch (IOException ex) {
//        System.err.println("There was an error: " + ex);
//        }
        
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
        
//      String linkItem[] = images.toArray(String[]::new);
//      test = linkItem.split("<");

//      System.out.println(images+"imageeee");
//                 Element bodyElement = document.getElementsByTag("body").first();
//System.out.println( document.select("body img") );
//                 Element bodyElement = switchDoc.getElementsByTag("body").first();
//            //this will only selct direct child of body element, notice > sign
//            System.out.println( switchDoc.select("body > img") );

//        
//      for (Element repository : repositories) {
//        // Extract the link
//         imgLink = repository.getElementsByClass("product-gallery--image-background").text();
//         System.out.println(imgLink+"WWWOWO");
//        }
      } catch (IOException ex) {
        System.err.println("There was an error: " + ex);
        }
        
//        BufferedImage image =null;
//        try{
//           URL url =new URL(link);
//           // read the url
//          image = ImageIO.read(url);
//           // for png
//           ImageIO.write(image, "png",new File("src\\main\\Resources\\"+name+".png")); 
//           // for jpg
//           // ImageIO.write(image, "jpg",new File("/tmp/have_a_question.jpg"));
//       }catch(IOException e){
//           e.printStackTrace();
//       }

    }
        
        private static void getImages(String src) throws IOException {

int indexname = src.lastIndexOf("/");

if (indexname == src.length()) {
src = src.substring(1, indexname);
}

indexname = src.lastIndexOf("/");
String name = src.substring(indexname, src.length());

System.out.println(name+"name of image");

//Open a URL Stream
URL url = new URL(src);
InputStream in = url.openStream();

OutputStream out = new BufferedOutputStream(new FileOutputStream("src\\main\\Resources\\" + name));

for (int b; (b = in.read()) != -1;) {
out.write(b);
}
out.close();
in.close();
}
        
        //remove prolly
    public static void linkImage(String keycapName) //indv. files for eah switch? getkeycap name -> link or like all in one file but 
            //write to switches for name/price and seperate own file link, refer to this file when gettig th image 
    {
        
        String imgLink = "";
        int maxIndx = 0;
        String keycapImageData[] = new String [100];
        try {
        File keycapDataFile = new File("src\\main\\Resources\\"+keycapName+".txt");
        //declare file scanner
        Scanner scanFile = new Scanner(keycapDataFile);
        while (scanFile.hasNext()) //attr each element to the next line in the file
        {
            keycapImageData[maxIndx] = scanFile.nextLine();  
            maxIndx++; 
        }
        scanFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int sw = 0 ; sw < maxIndx; sw++)
        {
            imgLink = keycapImageData[sw]; //split by name, price etc. 
        }
    }
        
}
