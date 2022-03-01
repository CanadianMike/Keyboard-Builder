/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.lang.*;
import java.io.*;
//imports for jsoup
import java.io.IOException;  
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.jsoup.Jsoup;  
//import org.jsoup.nodes.Document; 
//import org.jsoup.nodes.Element; 
//import org.jsoup.select.Elements; 
// imports for list filter
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//for icons
//import javax.swing.JFrame;
//import java.awt.image.BufferedImage;
//import java.awt.image;
//import java.io.File;
//import javax.imageio.ImageIO;


/**
 *
 * @author Hao
 */
public class MainGUI extends javax.swing.JFrame {
Cart cartObj = new Cart(); //declare Cart object instance
Switches switchObj = new Switches();
Keycap keycapObj = new Keycap();
String keycapLink;
String keyswitchLink;

    
    
    //key switch filter

    

    /**
    * keyswitch filtered list
    */ 
   
    DefaultListModel keySwitchList = new DefaultListModel();
    private ArrayList getSwitches ()
    {   
        ArrayList switches = new ArrayList();  
        int maxIndx = 0;
        String rawSwitchData[] = new String [100];
        try {
        File switchDataFile = new File("src\\main\\Resources\\switches.txt");
        //declare file scanner
        Scanner scanFile = new Scanner(switchDataFile);
        while (scanFile.hasNext()) //attr each element to the next line in the file
        {
            rawSwitchData[maxIndx] = scanFile.nextLine();  
            maxIndx++; 
        }
        scanFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int sw = 0 ; sw < maxIndx; sw++)
        {
            switches.add(rawSwitchData[sw]);
        }
        return switches;
    }
    private void bindKeyswitchData () 
    {
        getSwitches().stream().forEach((currentSwitch) -> 
        {
            keySwitchList.addElement(currentSwitch);
        });
        keyswitchJList.setModel(keySwitchList);
        keyswitchJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
 private void keyswitchSearchFilter (String keyswitchSearchTerm)
    {
        DefaultListModel filteredKeyswitches = new DefaultListModel();
        ArrayList switches = getSwitches();
        
        switches.stream().forEach((currentswitch) -> 
        {
            String switchName=switches.toString().toLowerCase();
            if (switchName.contains(keyswitchSearchTerm.toLowerCase()))
            {
                filteredKeyswitches.addElement(currentswitch);
            }
        });
        keySwitchList = filteredKeyswitches;
        keyswitchJList.setModel(keySwitchList);
    }
 /// keycaps filter
 DefaultListModel keycapList = new DefaultListModel();
    private ArrayList getKeycaps ()
    {
        ArrayList keycaps = new ArrayList(); 
        
        int maxIndx = 0;
        String rawKeycapData[] = new String [100];
        try {
        File keycapDataFile = new File("src\\main\\Resources\\keycaps.txt");
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
 private void scaleIcon() 
 {
       
        //homeIcon
        ImageIcon homeIMG = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Logo.png")));
        Image getHomeImg = homeIMG.getImage();
        Image scaleHomeImg = getHomeImg.getScaledInstance(homeIcon.getWidth(),homeIcon.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon finalHomeImg = new ImageIcon(scaleHomeImg);
        homeIcon.setIcon(finalHomeImg);
        //KB60 icon
        ImageIcon KB60Img = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/60_KBIcon.png")));
        Image getKB60Img = KB60Img.getImage();
        Image scaleKB60Img = getKB60Img.getScaledInstance(KB60Icon.getWidth(),KB60Icon.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon finalKB60Img = new ImageIcon(scaleKB60Img);
        KB60Icon.setIcon(finalKB60Img);
        //KB65 icon
        ImageIcon KB65Img = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/65_KBIcon.png")));
        Image getKB65Img = KB65Img.getImage();
        Image scaleKB65Img = getKB65Img.getScaledInstance(KB65Icon.getWidth(),KB65Icon.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon finalKB65Img = new ImageIcon(scaleKB65Img);
        KB65Icon.setIcon(finalKB65Img);
        //KB75 icon
        ImageIcon KB75Img = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/75_KBIcon.png")));
        Image getKB75Img = KB75Img.getImage();
        Image scaleKB75Img = getKB75Img.getScaledInstance(KB75Icon.getWidth(),KB75Icon.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon finalKB75Img = new ImageIcon(scaleKB75Img);
        KB75Icon.setIcon(finalKB75Img);
        //KB80 icon
        ImageIcon KB80Img = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/80_KBIcon.png")));
        Image getKB80Img = KB80Img.getImage();
        Image scaleKB80Img = getKB80Img.getScaledInstance(KB80Icon.getWidth(),KB80Icon.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon finalKB80Img = new ImageIcon(scaleKB80Img);
        KB80Icon.setIcon(finalKB80Img);
        //Cart icon
        ImageIcon CartImg = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Cart.png")));
        Image getCartImg = CartImg.getImage();
        Image scaleCartImg = getCartImg.getScaledInstance(cartIcon.getWidth(),cartIcon.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon finalCartImg = new ImageIcon(scaleCartImg);
        cartIcon.setIcon(finalCartImg);
        //Layout icon
        ImageIcon LayoutImg = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Layout.png")));
        Image getLayoutImg = LayoutImg.getImage();
        Image scaleLayoutImg = getLayoutImg.getScaledInstance(layoutIcon.getWidth(),layoutIcon.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon finalLayoutImg = new ImageIcon(scaleLayoutImg);
        layoutIcon.setIcon(finalLayoutImg);
        //Keyswitch icon
        ImageIcon KeyswitchImg = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Keyswitch.png")));
        Image getKeyswitchImg = KeyswitchImg.getImage();
        Image scaleKeyswitchImg = getKeyswitchImg.getScaledInstance(keyswitchIcon.getWidth(),keyswitchIcon.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon finalKeyswitchImg = new ImageIcon(scaleKeyswitchImg);
        keyswitchIcon.setIcon(finalKeyswitchImg);
        //Keycap Icon
        ImageIcon keycapImg = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Keycap.png")));
        Image getkeycapImg = keycapImg.getImage();
        Image scalekeycapImg = getkeycapImg.getScaledInstance(keycapIcon.getWidth(),keycapIcon.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon finalkeycapImg = new ImageIcon(scalekeycapImg);
        keycapIcon.setIcon(finalkeycapImg);
 }
 
 
    /**
     * Creates new form MainGUI
     */
    public MainGUI() throws IOException{
        initComponents();
        defaultPanel.setVisible(true);
        layoutPanel.setVisible(false);
        cartPanel.setVisible(false);
        keyswitchPanel.setVisible(false);
        keycapsPanel.setVisible(false);
        homeTab.setBackground(Color.WHITE);
        scaleIcon();
        //adding in some starting keycaps
        keycapObj.addKeycapLink("https://www.deskhero.ca/collections/keycap-sets/products/gmk-hammerhead-extras","GMK Hammerhead - Extras");
        //adding in some starting switches
        switchObj.addKeyswitchLink("https://www.deskhero.ca/collections/switches/products/seal-switch","Seal Switch");


        // keycap list
        this.bindKeycapData();
        //key switch    
        this.bindKeyswitchData();
        //switch webscrape
        Switches.initKeyswitches();
        //keycaps webscrape
        Keycap.initKeycaps();
        //init cart file
        Cart.initCart();
        

  
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopPane = new javax.swing.JDesktopPane();
        MenuPanel = new javax.swing.JPanel();
        homeTab = new javax.swing.JPanel();
        homeLabel = new javax.swing.JLabel();
        layoutTab = new javax.swing.JPanel();
        LayoutLabel = new javax.swing.JLabel();
        keyswitchTab = new javax.swing.JPanel();
        keyswitchLabel = new javax.swing.JLabel();
        keycapsTab = new javax.swing.JPanel();
        keycapsLabel = new javax.swing.JLabel();
        saveTab = new javax.swing.JPanel();
        saveLabel = new javax.swing.JLabel();
        cartTab = new javax.swing.JPanel();
        cartLabel = new javax.swing.JLabel();
        MainDisplayPanel = new javax.swing.JPanel();
        cartPanel = new javax.swing.JPanel();
        cartText = new javax.swing.JLabel();
        cartTextScrollPane = new javax.swing.JScrollPane();
        cartTextArea = new javax.swing.JTextArea();
        editCartButton = new javax.swing.JButton();
        updateCartButton = new javax.swing.JButton();
        cartIcon = new javax.swing.JLabel();
        defaultPanel = new javax.swing.JPanel();
        homeIcon = new javax.swing.JLabel();
        layoutPanel = new javax.swing.JPanel();
        KB60Icon = new javax.swing.JLabel();
        KB65Icon = new javax.swing.JLabel();
        KB75Icon = new javax.swing.JLabel();
        KB80Icon = new javax.swing.JLabel();
        layoutIcon = new javax.swing.JLabel();
        layoutText = new javax.swing.JLabel();
        keycapsPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        keycapJList = new javax.swing.JList<>();
        keyCapSearch = new javax.swing.JTextField();
        addKeycapLink = new javax.swing.JTextField();
        addKeycapLinkButton = new javax.swing.JButton();
        keycapText = new javax.swing.JLabel();
        keycapIcon = new javax.swing.JLabel();
        keyswitchPanel = new javax.swing.JPanel();
        keyswitchSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        keyswitchJList = new javax.swing.JList<>();
        addKeyswitchLink = new javax.swing.JTextField();
        addKeyswitchButton = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        keyswitchText = new javax.swing.JLabel();
        keyswitchIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Keyboard Configurator");
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        MenuPanel.setBackground(new java.awt.Color(204, 204, 255));

        homeTab.setPreferredSize(new java.awt.Dimension(180, 60));
        homeTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeTabMouseClicked(evt);
            }
        });

        homeLabel.setText("Home");

        javax.swing.GroupLayout homeTabLayout = new javax.swing.GroupLayout(homeTab);
        homeTab.setLayout(homeTabLayout);
        homeTabLayout.setHorizontalGroup(
            homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeTabLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(homeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        homeTabLayout.setVerticalGroup(
            homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeTabLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(homeLabel)
                .addGap(17, 17, 17))
        );

        layoutTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                layoutTabMouseClicked(evt);
            }
        });

        LayoutLabel.setText("Layout");

        javax.swing.GroupLayout layoutTabLayout = new javax.swing.GroupLayout(layoutTab);
        layoutTab.setLayout(layoutTabLayout);
        layoutTabLayout.setHorizontalGroup(
            layoutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutTabLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(LayoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layoutTabLayout.setVerticalGroup(
            layoutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutTabLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(LayoutLabel)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        keyswitchTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyswitchTabMouseClicked(evt);
            }
        });

        keyswitchLabel.setText("Key Switches");

        javax.swing.GroupLayout keyswitchTabLayout = new javax.swing.GroupLayout(keyswitchTab);
        keyswitchTab.setLayout(keyswitchTabLayout);
        keyswitchTabLayout.setHorizontalGroup(
            keyswitchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyswitchTabLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(keyswitchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        keyswitchTabLayout.setVerticalGroup(
            keyswitchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyswitchTabLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(keyswitchLabel)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        keycapsTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keycapsTabMouseClicked(evt);
            }
        });

        keycapsLabel.setText("Key Caps");

        javax.swing.GroupLayout keycapsTabLayout = new javax.swing.GroupLayout(keycapsTab);
        keycapsTab.setLayout(keycapsTabLayout);
        keycapsTabLayout.setHorizontalGroup(
            keycapsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keycapsTabLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(keycapsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        keycapsTabLayout.setVerticalGroup(
            keycapsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keycapsTabLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(keycapsLabel)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        saveTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveTabMouseClicked(evt);
            }
        });

        saveLabel.setText("Save Configuration");

        javax.swing.GroupLayout saveTabLayout = new javax.swing.GroupLayout(saveTab);
        saveTab.setLayout(saveTabLayout);
        saveTabLayout.setHorizontalGroup(
            saveTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saveTabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveLabel)
                .addGap(36, 36, 36))
        );
        saveTabLayout.setVerticalGroup(
            saveTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saveTabLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(saveLabel)
                .addGap(21, 21, 21))
        );

        cartTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTabMouseClicked(evt);
            }
        });

        cartLabel.setText("Cart");

        javax.swing.GroupLayout cartTabLayout = new javax.swing.GroupLayout(cartTab);
        cartTab.setLayout(cartTabLayout);
        cartTabLayout.setHorizontalGroup(
            cartTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartTabLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(cartLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cartTabLayout.setVerticalGroup(
            cartTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartTabLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cartLabel)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(saveTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(keycapsTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(keyswitchTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(layoutTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(homeTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(cartTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(homeTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(layoutTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keyswitchTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keycapsTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(cartTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        MainDisplayPanel.setBackground(new java.awt.Color(204, 204, 255));
        MainDisplayPanel.setLayout(new javax.swing.OverlayLayout(MainDisplayPanel));

        cartPanel.setBackground(new java.awt.Color(204, 204, 255));

        cartText.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        cartText.setForeground(new java.awt.Color(255, 255, 255));
        cartText.setLabelFor(cartIcon);
        cartText.setText("Cart ");

        cartTextArea.setColumns(20);
        cartTextArea.setRows(5);
        cartTextScrollPane.setViewportView(cartTextArea);

        editCartButton.setText("Edit Cart");
        editCartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editCartButtonMouseClicked(evt);
            }
        });

        updateCartButton.setText("Update Cart");
        updateCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cartPanelLayout = new javax.swing.GroupLayout(cartPanel);
        cartPanel.setLayout(cartPanelLayout);
        cartPanelLayout.setHorizontalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartPanelLayout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updateCartButton)
                    .addComponent(editCartButton)
                    .addComponent(cartTextScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(170, Short.MAX_VALUE))
            .addGroup(cartPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cartText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cartPanelLayout.setVerticalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cartText, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115)
                .addComponent(cartTextScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editCartButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateCartButton)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        MainDisplayPanel.add(cartPanel);

        defaultPanel.setBackground(new java.awt.Color(204, 204, 255));
        defaultPanel.setPreferredSize(new java.awt.Dimension(793, 560));

        javax.swing.GroupLayout defaultPanelLayout = new javax.swing.GroupLayout(defaultPanel);
        defaultPanel.setLayout(defaultPanelLayout);
        defaultPanelLayout.setHorizontalGroup(
            defaultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultPanelLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(homeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        defaultPanelLayout.setVerticalGroup(
            defaultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultPanelLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(homeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        MainDisplayPanel.add(defaultPanel);

        layoutPanel.setBackground(new java.awt.Color(204, 204, 255));
        layoutPanel.setPreferredSize(new java.awt.Dimension(793, 560));

        KB60Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KB60Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/60_KBIcon.png"))); // NOI18N
        KB60Icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KB60IconMouseClicked(evt);
            }
        });

        KB65Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KB65Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/60_KBIcon.png"))); // NOI18N
        KB65Icon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        KB65Icon.setIconTextGap(1);
        KB65Icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KB65IconMouseClicked(evt);
            }
        });

        KB75Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KB75Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/75_KBIcon.png"))); // NOI18N
        KB75Icon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        KB75Icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KB75IconMouseClicked(evt);
            }
        });

        KB80Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/80_KBIcon.png"))); // NOI18N
        KB80Icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KB80IconMouseClicked(evt);
            }
        });

        layoutText.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        layoutText.setForeground(new java.awt.Color(255, 255, 255));
        layoutText.setText("Layout");

        javax.swing.GroupLayout layoutPanelLayout = new javax.swing.GroupLayout(layoutPanel);
        layoutPanel.setLayout(layoutPanelLayout);
        layoutPanelLayout.setHorizontalGroup(
            layoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layoutPanelLayout.createSequentialGroup()
                        .addComponent(layoutText, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(layoutIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(KB75Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layoutPanelLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(KB60Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(KB65Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KB80Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layoutPanelLayout.setVerticalGroup(
            layoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(layoutText)
                    .addComponent(layoutIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KB65Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layoutPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(KB60Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layoutPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(KB75Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layoutPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(KB80Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(181, Short.MAX_VALUE))
        );

        MainDisplayPanel.add(layoutPanel);

        keycapsPanel.setBackground(new java.awt.Color(204, 204, 255));
        keycapsPanel.setPreferredSize(new java.awt.Dimension(793, 560));

        keycapJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        keycapJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keycapJListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(keycapJList);

        keyCapSearch.setText("search keycaps");
        keyCapSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyCapSearchMouseClicked(evt);
            }
        });
        keyCapSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keyCapSearchKeyReleased(evt);
            }
        });

        addKeycapLink.setText("link");
        addKeycapLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addKeycapLinkMouseClicked(evt);
            }
        });
        addKeycapLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addKeycapLinkActionPerformed(evt);
            }
        });
        addKeycapLink.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                addKeycapLinkKeyReleased(evt);
            }
        });

        addKeycapLinkButton.setText("Add");
        addKeycapLinkButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addKeycapLinkButtonMouseClicked(evt);
            }
        });

        keycapText.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        keycapText.setForeground(new java.awt.Color(255, 255, 255));
        keycapText.setText("Keycaps");

        keycapIcon.setText("jLabel1");

        javax.swing.GroupLayout keycapsPanelLayout = new javax.swing.GroupLayout(keycapsPanel);
        keycapsPanel.setLayout(keycapsPanelLayout);
        keycapsPanelLayout.setHorizontalGroup(
            keycapsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keycapsPanelLayout.createSequentialGroup()
                .addGroup(keycapsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(keycapsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(keycapText, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keycapIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(keycapsPanelLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(keycapsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(keycapsPanelLayout.createSequentialGroup()
                                .addComponent(addKeycapLink, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addKeycapLinkButton))
                            .addGroup(keycapsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(keyCapSearch, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        keycapsPanelLayout.setVerticalGroup(
            keycapsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keycapsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(keycapsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keycapText, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(keycapsPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(keycapIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(107, 107, 107)
                .addComponent(keyCapSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(keycapsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addKeycapLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addKeycapLinkButton))
                .addContainerGap(248, Short.MAX_VALUE))
        );

        MainDisplayPanel.add(keycapsPanel);

        keyswitchPanel.setBackground(new java.awt.Color(204, 204, 255));
        keyswitchPanel.setPreferredSize(new java.awt.Dimension(793, 560));

        keyswitchSearch.setText("search key switches");
        keyswitchSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyswitchSearchMouseClicked(evt);
            }
        });
        keyswitchSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyswitchSearchActionPerformed(evt);
            }
        });
        keyswitchSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keyswitchSearchKeyReleased(evt);
            }
        });

        keyswitchJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        keyswitchJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keyswitchJListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(keyswitchJList);

        addKeyswitchLink.setText("link");
        addKeyswitchLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addKeyswitchLinkMouseClicked(evt);
            }
        });
        addKeyswitchLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addKeyswitchLinkActionPerformed(evt);
            }
        });
        addKeyswitchLink.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                addKeyswitchLinkKeyReleased(evt);
            }
        });

        addKeyswitchButton.setText("Add");
        addKeyswitchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addKeyswitchButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 285, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        keyswitchText.setFont(new java.awt.Font("Berlin Sans FB", 0, 48)); // NOI18N
        keyswitchText.setForeground(new java.awt.Color(255, 255, 255));
        keyswitchText.setText("Keyswitch");

        javax.swing.GroupLayout keyswitchPanelLayout = new javax.swing.GroupLayout(keyswitchPanel);
        keyswitchPanel.setLayout(keyswitchPanelLayout);
        keyswitchPanelLayout.setHorizontalGroup(
            keyswitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyswitchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(keyswitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(keyswitchPanelLayout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(keyswitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keyswitchSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addKeyswitchLink, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(addKeyswitchButton)
                        .addGap(422, 422, 422))
                    .addGroup(keyswitchPanelLayout.createSequentialGroup()
                        .addComponent(keyswitchText)
                        .addGap(18, 18, 18)
                        .addComponent(keyswitchIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        keyswitchPanelLayout.setVerticalGroup(
            keyswitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyswitchPanelLayout.createSequentialGroup()
                .addGroup(keyswitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(keyswitchPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(keyswitchText, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(keyswitchPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(keyswitchIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(keyswitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(keyswitchPanelLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(keyswitchPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(keyswitchSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(keyswitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addKeyswitchLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addKeyswitchButton))))
                .addContainerGap(220, Short.MAX_VALUE))
        );

        MainDisplayPanel.add(keyswitchPanel);

        DesktopPane.setLayer(MenuPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(MainDisplayPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                .addContainerGap())
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DesktopPaneLayout.createSequentialGroup()
                        .addComponent(MainDisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(DesktopPane, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void layoutTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_layoutTabMouseClicked
        // TODO add your handling code here:
        //display layout panel
        layoutPanel.setVisible(true);
        keyswitchPanel.setVisible(false);
        keycapsPanel.setVisible(false);
        defaultPanel.setVisible(false);
        cartPanel.setVisible(false);
        //change current tab colour according to current selection
        layoutTab.setBackground(Color.white);
        keyswitchTab.setBackground(new Color(128,128,128));
        keycapsTab.setBackground(new Color(128,128,128));
        saveTab.setBackground(new Color(128,128,128));
        homeTab.setBackground(new Color(128,128,128));
        cartTab.setBackground(new Color(128,128,128));

    }//GEN-LAST:event_layoutTabMouseClicked

    private void keyswitchTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keyswitchTabMouseClicked
        // TODO add your handling code here:
        //display keyswitch panel
        layoutPanel.setVisible(false);
        keyswitchPanel.setVisible(true);
        keycapsPanel.setVisible(false);
        defaultPanel.setVisible(false);
        cartPanel.setVisible(false);
        //change current tab colour according to current selection
        keyswitchTab.setBackground(Color.white);
        saveTab.setBackground(new Color(128,128,128));
        keycapsTab.setBackground(new Color(128,128,128));
        layoutTab.setBackground(new Color(128,128,128));
        homeTab.setBackground(new Color(128,128,128));
        cartTab.setBackground(new Color(128,128,128));
    }//GEN-LAST:event_keyswitchTabMouseClicked

    private void keycapsTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keycapsTabMouseClicked
        // TODO add your handling code here:
        //display keycaps panel
        layoutPanel.setVisible(false);
        keyswitchPanel.setVisible(false);
        keycapsPanel.setVisible(true);
        defaultPanel.setVisible(false);
        cartPanel.setVisible(false);
        //change current tab colour according to current selection
        keycapsTab.setBackground(Color.white);
        saveTab.setBackground(new Color(128,128,128));
        keyswitchTab.setBackground(new Color(128,128,128));
        layoutTab.setBackground(new Color(128,128,128));
        homeTab.setBackground(new Color(128,128,128));
        cartTab.setBackground(new Color(128,128,128));
    }//GEN-LAST:event_keycapsTabMouseClicked

    private void saveTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveTabMouseClicked
        // TODO add your handling code here:
        //save to file
        //display home panel
        defaultPanel.setVisible(true);
        layoutPanel.setVisible(false);
        keyswitchPanel.setVisible(false);
        keycapsPanel.setVisible(false);
        cartPanel.setVisible(false);
        //save to file 
        //change current tab colour according to current selection
        saveTab.setBackground(Color.white);
        keyswitchTab.setBackground(new Color(128,128,128));
        keycapsTab.setBackground(new Color(128,128,128));
        layoutTab.setBackground(new Color(128,128,128));
        homeTab.setBackground(new Color(128,128,128));
        cartTab.setBackground(new Color(128,128,128));
        //option dialog popup
        
        String saveText = "Save your current configuration?";
        int response = JOptionPane.showConfirmDialog(null,saveText, "Save configuration", JOptionPane.YES_NO_CANCEL_OPTION);
        if (response == JOptionPane.YES_OPTION)
        {   //save cart
            String name = JOptionPane.showInputDialog("Please input name of configuration");
            try {
            cartObj.saveCart(name);
            }
            catch (IOException e)
            {
                
            }
        }
        else
        {} 
    }//GEN-LAST:event_saveTabMouseClicked

    private void homeTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeTabMouseClicked
        // TODO add your handling code here:
        //display home panel
        defaultPanel.setVisible(true);
        layoutPanel.setVisible(false);
        keyswitchPanel.setVisible(false);
        keycapsPanel.setVisible(false);
        cartPanel.setVisible(false);
        //change current tab colour according to current selection
        homeTab.setBackground(Color.white);
        keyswitchTab.setBackground(new Color(128,128,128));
        keycapsTab.setBackground(new Color(128,128,128));
        layoutTab.setBackground(new Color(128,128,128));
        saveTab.setBackground(new Color(128,128,128));
        cartTab.setBackground(new Color(128,128,128));
        
    }//GEN-LAST:event_homeTabMouseClicked

    private void cartTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTabMouseClicked

        String cartArr[] = cartObj.displayCart();
        cartTextArea.setText("");
        for(String a : cartArr)
        cartTextArea.append(a+"\n");

         
//display cart panel
cartPanel.setVisible(true);
defaultPanel.setVisible(false);
layoutPanel.setVisible(false);
keyswitchPanel.setVisible(false);
keycapsPanel.setVisible(false);
//save to file
//change current tab colour according to current selection
cartTab.setBackground(Color.white);
homeTab.setBackground(new Color(128,128,128));
keyswitchTab.setBackground(new Color(128,128,128));
keycapsTab.setBackground(new Color(128,128,128));
layoutTab.setBackground(new Color(128,128,128));
saveTab.setBackground(new Color(128,128,128));
            
    }//GEN-LAST:event_cartTabMouseClicked

    private void keycapJListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keycapJListMouseClicked
        // TODO add your handling code here:

        String selectedKeycap = "Keycaps: "+keycapJList.getSelectedValue();
        System.out.println(selectedKeycap);
        String keycapName = keycapJList.getSelectedValue();
        Keycap showKeycap = new Keycap();
        ImageIcon icon = showKeycap.getKeycapImage(keycapName); //use for icon
        String info = showKeycap.getKeycapInfo(keycapName);
        int response = JOptionPane.showConfirmDialog(null,info, "Add selected item to cart?", JOptionPane.YES_NO_CANCEL_OPTION);
        if (response == JOptionPane.YES_OPTION)
        {   //add to cart
            cartObj.addCart(selectedKeycap);

        }
        else
        {}       
    }//GEN-LAST:event_keycapJListMouseClicked

    private void keyCapSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyCapSearchKeyReleased
        // TODO add your handling code here:
        keycapSearchFilter(keyCapSearch.getText());
    }//GEN-LAST:event_keyCapSearchKeyReleased

    private void keyCapSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keyCapSearchMouseClicked
        // TODO add your handling code here:
        keyCapSearch.setText("");
    }//GEN-LAST:event_keyCapSearchMouseClicked

    private void KB60IconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KB60IconMouseClicked
        // TODO add your handling code here:     
        String selectedLayout = "Layout: 60%"; 
        System.out.println(selectedLayout+" clicked");//test cart value
        int response = JOptionPane.showConfirmDialog(null,selectedLayout, "Add selected item to cart?", JOptionPane.YES_NO_CANCEL_OPTION);
        if (response == JOptionPane.YES_OPTION)
        {   
         //add to cart
            cartObj.addCart(selectedLayout);

            }
        else
        {}   
        
    }//GEN-LAST:event_KB60IconMouseClicked

    private void keyswitchJListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keyswitchJListMouseClicked
        // TODO add your handling code here:
        String selectedSwitch = "Key switch: "+keyswitchJList.getSelectedValue();
        System.out.println(selectedSwitch);
        String switchName = keyswitchJList.getSelectedValue();
        Switches showSwitch = new Switches();
        ImageIcon icon = showSwitch.getKeyswitchImage(switchName); //use for icon
        String info = showSwitch.getKeyswitchInfo(switchName);
        int response = JOptionPane.showConfirmDialog(null,info, "Add selected item to cart?", JOptionPane.YES_NO_CANCEL_OPTION);
        if (response == JOptionPane.YES_OPTION)
        {  
            cartObj.addCart(selectedSwitch);
        }
        else
        {}       


    }//GEN-LAST:event_keyswitchJListMouseClicked

    private void keyswitchSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyswitchSearchKeyReleased
        // TODO add your handling code here:
        keyswitchSearchFilter(keyswitchSearch.getText());
    }//GEN-LAST:event_keyswitchSearchKeyReleased

    private void keyswitchSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyswitchSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keyswitchSearchActionPerformed

    private void keyswitchSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keyswitchSearchMouseClicked
        // TODO add your handling code here:
        keyswitchSearch.setText("");
    }//GEN-LAST:event_keyswitchSearchMouseClicked

    private void KB65IconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KB65IconMouseClicked
        // TODO add your handling code here:
        String selectedLayout = "Layout: 65%";
        System.out.println(selectedLayout+" clicked");//test cart value
        int response = JOptionPane.showConfirmDialog(null,selectedLayout, "Add selected item to cart?", JOptionPane.YES_NO_CANCEL_OPTION);
        if (response == JOptionPane.YES_OPTION)
        {  
         //add to cart
            cartObj.addCart(selectedLayout);
            }
        else
        {} 
    }//GEN-LAST:event_KB65IconMouseClicked

    private void KB75IconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KB75IconMouseClicked
        // TODO add your handling code here:
        String selectedLayout = "Layout: 75%";
        System.out.println(selectedLayout+" clicked");//test cart value
        int response = JOptionPane.showConfirmDialog(null,selectedLayout, "Add selected item to cart?", JOptionPane.YES_NO_CANCEL_OPTION);
        if (response == JOptionPane.YES_OPTION)
        {   
         //add to cart
            cartObj.addCart(selectedLayout);
            }
        else
        {} 
    }//GEN-LAST:event_KB75IconMouseClicked

    private void KB80IconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KB80IconMouseClicked
        String selectedLayout = "Layout: 80%";
        System.out.println(selectedLayout+"clicked"); //test cart value
        int response = JOptionPane.showConfirmDialog(null,selectedLayout, "Add selected item to cart?", JOptionPane.YES_NO_CANCEL_OPTION);
        if (response == JOptionPane.YES_OPTION)
        {   
         //add to cart
            cartObj.addCart(selectedLayout);
            }
        else
        {} 
    }//GEN-LAST:event_KB80IconMouseClicked

    private void editCartButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editCartButtonMouseClicked
        // TODO add your handling code here:
//        String removeItem = JOptionPane.showInputDialog(null, "Enter name of item you want to remove:");
        Cart editCart = new Cart();
        String removeItem = editCart.showInputDialog();

        try {
String editConfirm = "Confirm Changes?";
            int response = JOptionPane.showConfirmDialog(null,editConfirm,"Edit Cart",JOptionPane.YES_NO_CANCEL_OPTION);
            if (response == JOptionPane.YES_OPTION)
            {
        cartObj.removeCart(removeItem);
            }        }
        catch(ArrayIndexOutOfBoundsException e)        
        {
           editCart.showInputDialog();
        }
           
        
           
        
    }//GEN-LAST:event_editCartButtonMouseClicked

    private void updateCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCartButtonActionPerformed
        // TODO add your handling code here:
        String cartArr[] = cartObj.displayCart();
        cartTextArea.setText("");
        for(String a : cartArr)
        cartTextArea.append(a+"\n");
    }//GEN-LAST:event_updateCartButtonActionPerformed

    private void addKeycapLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addKeycapLinkMouseClicked
        // TODO add your handling code here:
        addKeycapLink.setText(""); // clear default text
    }//GEN-LAST:event_addKeycapLinkMouseClicked

    private void addKeycapLinkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeycapLinkKeyReleased
        // TODO add your handling code here:
        keycapLink = addKeycapLink.getText();
    }//GEN-LAST:event_addKeycapLinkKeyReleased

    private void addKeycapLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addKeycapLinkActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_addKeycapLinkActionPerformed

    private void addKeycapLinkButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addKeycapLinkButtonMouseClicked
        // TODO add your handling code here:
        String getName = "";
        String getLink = keycapLink;
        Keycap addKeycapLink = new Keycap();
          try {
          getName = keycapObj.getKeycapLinkName(keycapLink);
        addKeycapLink.addKeycapLink(getLink,getName);
        addKeycapLink.writeKeycapImage(getLink,getName);
        this.bindKeycapData();
        
    } catch (IOException ex) {
        Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_addKeycapLinkButtonMouseClicked

    private void addKeyswitchLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addKeyswitchLinkMouseClicked
        // TODO add your handling code here:
        addKeyswitchLink.setText(""); // clear default text

    }//GEN-LAST:event_addKeyswitchLinkMouseClicked

    private void addKeyswitchLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addKeyswitchLinkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addKeyswitchLinkActionPerformed

    private void addKeyswitchLinkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyswitchLinkKeyReleased
        // TODO add your handling code here:
        keyswitchLink = addKeyswitchLink.getText();

    }//GEN-LAST:event_addKeyswitchLinkKeyReleased

    private void addKeyswitchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addKeyswitchButtonMouseClicked
        // TODO add your handling code here:
        String getName = "";
        String getLink = keyswitchLink;
        Switches addNewKeyswitchLink = new Switches();
          try {
          getName = switchObj.getKeyswitchLinkName(keyswitchLink);
        addNewKeyswitchLink.addKeyswitchLink(getLink,getName);
        addNewKeyswitchLink.writeKeyswitchImage(getLink,getName);
        this.bindKeyswitchData();
    }//GEN-LAST:event_addKeyswitchButtonMouseClicked
     catch (IOException ex) {
        Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException{
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //        WebScraper scrape = new WebScraper();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainGUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JLabel KB60Icon;
    private javax.swing.JLabel KB65Icon;
    private javax.swing.JLabel KB75Icon;
    private javax.swing.JLabel KB80Icon;
    private javax.swing.JLabel LayoutLabel;
    private javax.swing.JPanel MainDisplayPanel;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JTextField addKeycapLink;
    private javax.swing.JButton addKeycapLinkButton;
    private javax.swing.JButton addKeyswitchButton;
    private javax.swing.JTextField addKeyswitchLink;
    private javax.swing.JLabel cartIcon;
    private javax.swing.JLabel cartLabel;
    private javax.swing.JPanel cartPanel;
    private javax.swing.JPanel cartTab;
    private javax.swing.JLabel cartText;
    public javax.swing.JTextArea cartTextArea;
    private javax.swing.JScrollPane cartTextScrollPane;
    private javax.swing.JPanel defaultPanel;
    private javax.swing.JButton editCartButton;
    private javax.swing.JLabel homeIcon;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JPanel homeTab;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField keyCapSearch;
    private javax.swing.JLabel keycapIcon;
    private javax.swing.JList<String> keycapJList;
    private javax.swing.JLabel keycapText;
    private javax.swing.JLabel keycapsLabel;
    private javax.swing.JPanel keycapsPanel;
    private javax.swing.JPanel keycapsTab;
    private javax.swing.JLabel keyswitchIcon;
    private javax.swing.JList<String> keyswitchJList;
    private javax.swing.JLabel keyswitchLabel;
    private javax.swing.JPanel keyswitchPanel;
    private javax.swing.JTextField keyswitchSearch;
    private javax.swing.JPanel keyswitchTab;
    private javax.swing.JLabel keyswitchText;
    private javax.swing.JLabel layoutIcon;
    private javax.swing.JPanel layoutPanel;
    private javax.swing.JPanel layoutTab;
    private javax.swing.JLabel layoutText;
    private javax.swing.JLabel saveLabel;
    private javax.swing.JPanel saveTab;
    private javax.swing.JButton updateCartButton;
    // End of variables declaration//GEN-END:variables
}
