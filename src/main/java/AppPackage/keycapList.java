/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Hao
 */
public class keycapList {
    /**
     * keycap filter 
     */
    private javax.swing.JList<String> keycapJList;
    DefaultListModel keycapList = new DefaultListModel();
    private ArrayList getKeycaps ()
    {
        ArrayList keycaps = new ArrayList(); 
        
//        keycaps.add("GMK White on Black");
//        keycaps.add("ePBT Kon Momo");
//        keycaps.add("ePBT Cool Kids");
//        keycaps.add("ePBT Origami");
        int maxIndx = 0;
        String rawKeycapData[] = new String [100];
        try {
        File keycapDataFile = new File("src\\main\\java\\Resources\\keycaps.txt");
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
            keycaps.add(rawKeycapData[kc]);
        }
        return keycaps;
    }
    //bind data to keycapJList
    void bindKeycapData () 
    {
        getKeycaps().stream().forEach((keycap) -> 
        {
            keycapList.addElement(keycap);
        });
        keycapJList.setModel(keycapList);
        keycapJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
     //search/filter for keycaps
    void keycapSearchFilter (String searchTerm)
    {
        DefaultListModel filteredKeycaps = new DefaultListModel();
        ArrayList keycaps = getKeycaps();
        
        keycaps.stream().forEach((keycap) -> 
        {
            String keycapName=keycap.toString().toLowerCase();
            if (keycapName.contains(searchTerm.toLowerCase()))
            {
                filteredKeycaps.addElement(keycap);
            }
        });
        keycapList = filteredKeycaps;
        keycapJList.setModel(keycapList);
    }
}
