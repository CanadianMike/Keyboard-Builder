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

    
    
    //key switch filter

    
    /**
     * keycap filter 
     */
    DefaultListModel keycapList = new DefaultListModel();
    private ArrayList getKeycaps ()
    {
        ArrayList keycaps = new ArrayList(); 
        
        keycaps.add("GMK White on Black");
        keycaps.add("ePBT Kon Momo");
        keycaps.add("ePBT Cool Kids");
        keycaps.add("ePBT Origami");
        return keycaps;
    }
    //bind data to keycapJList
    private void bindKeycapData () 
    {
        getKeycaps().stream().forEach((keycap) -> 
        {
            keycapList.addElement(keycap);
        });
        keycapJList.setModel(keycapList);
        keycapJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
     //search/filter for keycaps
    private void keycapSearchFilter (String searchTerm)
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
        File switchDataFile = new File("src\\main\\java\\AppPackage\\cherryswitch.txt");
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
 private void scaleIcon() 
 {
//        int iconNumber = 0;
//        String iconLabel = "";
//        int [] iconNumberArr = new int [] {60,65,75,80};//declaration
//        for (int i = 0; i < iconNumberArr.length; i++)
//        {
//            iconNumber = i;
//            iconLabel = "KB"+iconNumber+"Icon";
//        }
        //homeIcon
        ImageIcon homeIMG = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/z70ultra.jpg")));
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
        //to filter keycap list
        this.bindKeycapData();
        //to filter key switch    
        this.bindKeyswitchData();
        //cherry switch webscrape
        cherrySwitch.cherryMethod();
        //init cart file
        Cart.initCart();
  
    }
//    private void setVisibility (String visPanel, boolean visValue)
//    {
//        
//        layoutPanel.setVisible(false);
//        keyswitchPanel.setVisible(false);
//        keycapsPanel.setVisible(false);
//        defaultPanel.setVisible(false);
//        cartPanel.setVisible(false);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        testdiag = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
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
        loadTab = new javax.swing.JPanel();
        loadLabel = new javax.swing.JLabel();
        cartTab = new javax.swing.JPanel();
        cartLabel = new javax.swing.JLabel();
        MainDisplayPanel = new javax.swing.JPanel();
        cartPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cartTextArea = new javax.swing.JTextArea();
        editCartButton = new javax.swing.JButton();
        updateCartButton = new javax.swing.JButton();
        defaultPanel = new javax.swing.JPanel();
        homeIcon = new javax.swing.JLabel();
        layoutPanel = new javax.swing.JPanel();
        KB60Icon = new javax.swing.JLabel();
        KB65Icon = new javax.swing.JLabel();
        KB75Icon = new javax.swing.JLabel();
        KB80Icon = new javax.swing.JLabel();
        keycapsPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        keycapJList = new javax.swing.JList<>();
        keyCapSearch = new javax.swing.JTextField();
        keyswitchPane = new javax.swing.JDesktopPane();
        keyswitchPanel = new javax.swing.JPanel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        keyswitchDisplayPanel = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        linearPanel = new javax.swing.JPanel();
        keyswitchSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        keyswitchJList = new javax.swing.JList<>();
        tactilePanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        clickyPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        keyswitchMenuPanel = new javax.swing.JPanel();
        linearTab = new javax.swing.JPanel();
        linearLabel = new javax.swing.JLabel();
        tactileTab = new javax.swing.JPanel();
        tactileLabel = new javax.swing.JLabel();
        clickyTab = new javax.swing.JPanel();
        clickyLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel6.setText("choose this iption or die");

        jRadioButton1.setText("the bid button");

        javax.swing.GroupLayout testdiagLayout = new javax.swing.GroupLayout(testdiag.getContentPane());
        testdiag.getContentPane().setLayout(testdiagLayout);
        testdiagLayout.setHorizontalGroup(
            testdiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testdiagLayout.createSequentialGroup()
                .addGroup(testdiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(testdiagLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(testdiagLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        testdiagLayout.setVerticalGroup(
            testdiagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testdiagLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel6)
                .addGap(47, 47, 47)
                .addComponent(jRadioButton1)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Keyboard Configurator");
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        MenuPanel.setBackground(new java.awt.Color(255, 51, 102));

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
                .addContainerGap(29, Short.MAX_VALUE)
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
                .addGap(35, 35, 35))
        );
        saveTabLayout.setVerticalGroup(
            saveTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, saveTabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveLabel)
                .addGap(21, 21, 21))
        );

        loadTab.setPreferredSize(new java.awt.Dimension(180, 60));

        loadLabel.setText("Load Configuration");

        javax.swing.GroupLayout loadTabLayout = new javax.swing.GroupLayout(loadTab);
        loadTab.setLayout(loadTabLayout);
        loadTabLayout.setHorizontalGroup(
            loadTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadTabLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(loadLabel)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        loadTabLayout.setVerticalGroup(
            loadTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadTabLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(loadLabel)
                .addGap(18, 18, 18))
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
            .addComponent(loadTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MainDisplayPanel.setLayout(new javax.swing.OverlayLayout(MainDisplayPanel));

        cartPanel.setBackground(new java.awt.Color(0, 204, 204));

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel8.setText("cart");

        cartTextArea.setColumns(20);
        cartTextArea.setRows(5);
        jScrollPane3.setViewportView(cartTextArea);

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
                .addGap(135, 135, 135)
                .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updateCartButton)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCartButton))
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
        );
        cartPanelLayout.setVerticalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartPanelLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editCartButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateCartButton)
                .addContainerGap(140, Short.MAX_VALUE))
            .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cartPanelLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jLabel8)
                    .addContainerGap(501, Short.MAX_VALUE)))
        );

        MainDisplayPanel.add(cartPanel);

        defaultPanel.setBackground(new java.awt.Color(255, 102, 102));
        defaultPanel.setPreferredSize(new java.awt.Dimension(793, 560));

        homeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/z70ultra.jpg"))); // NOI18N

        javax.swing.GroupLayout defaultPanelLayout = new javax.swing.GroupLayout(defaultPanel);
        defaultPanel.setLayout(defaultPanelLayout);
        defaultPanelLayout.setHorizontalGroup(
            defaultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultPanelLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(homeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        defaultPanelLayout.setVerticalGroup(
            defaultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultPanelLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(homeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        MainDisplayPanel.add(defaultPanel);

        layoutPanel.setBackground(new java.awt.Color(51, 255, 255));
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

        javax.swing.GroupLayout layoutPanelLayout = new javax.swing.GroupLayout(layoutPanel);
        layoutPanel.setLayout(layoutPanelLayout);
        layoutPanelLayout.setHorizontalGroup(
            layoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(KB75Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(KB80Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(layoutPanelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(KB60Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KB65Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layoutPanelLayout.setVerticalGroup(
            layoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutPanelLayout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addGroup(layoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layoutPanelLayout.createSequentialGroup()
                        .addComponent(KB65Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layoutPanelLayout.createSequentialGroup()
                        .addComponent(KB60Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)))
                .addGroup(layoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(KB75Icon, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(KB80Icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(83, 83, 83))
        );

        MainDisplayPanel.add(layoutPanel);

        keycapsPanel.setBackground(new java.awt.Color(204, 255, 204));
        keycapsPanel.setPreferredSize(new java.awt.Dimension(793, 560));

        jLabel2.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jLabel2.setText("keycapspanel");

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

        javax.swing.GroupLayout keycapsPanelLayout = new javax.swing.GroupLayout(keycapsPanel);
        keycapsPanel.setLayout(keycapsPanelLayout);
        keycapsPanelLayout.setHorizontalGroup(
            keycapsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keycapsPanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(keycapsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keyCapSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        keycapsPanelLayout.setVerticalGroup(
            keycapsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keycapsPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(keyCapSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(keycapsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MainDisplayPanel.add(keycapsPanel);

        keyswitchPanel.setPreferredSize(new java.awt.Dimension(793, 560));

        keyswitchDisplayPanel.setLayout(new javax.swing.OverlayLayout(keyswitchDisplayPanel));

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

        javax.swing.GroupLayout linearPanelLayout = new javax.swing.GroupLayout(linearPanel);
        linearPanel.setLayout(linearPanelLayout);
        linearPanelLayout.setHorizontalGroup(
            linearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, linearPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(linearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keyswitchSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(209, 209, 209))
        );
        linearPanelLayout.setVerticalGroup(
            linearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(linearPanelLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(keyswitchSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setBackground(new java.awt.Color(153, 255, 153));
        jLabel5.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel5.setText("TACILE");

        javax.swing.GroupLayout tactilePanelLayout = new javax.swing.GroupLayout(tactilePanel);
        tactilePanel.setLayout(tactilePanelLayout);
        tactilePanelLayout.setHorizontalGroup(
            tactilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tactilePanelLayout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );
        tactilePanelLayout.setVerticalGroup(
            tactilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tactilePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(262, 262, 262))
        );

        jLabel7.setBackground(new java.awt.Color(255, 102, 102));
        jLabel7.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout clickyPanelLayout = new javax.swing.GroupLayout(clickyPanel);
        clickyPanel.setLayout(clickyPanelLayout);
        clickyPanelLayout.setHorizontalGroup(
            clickyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clickyPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        clickyPanelLayout.setVerticalGroup(
            clickyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clickyPanelLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel7)
                .addContainerGap(232, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(linearPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(tactilePanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(clickyPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tactilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(linearPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(clickyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tactilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(linearPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(clickyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        keyswitchDisplayPanel.add(jLayeredPane1);

        keyswitchMenuPanel.setBackground(new java.awt.Color(102, 255, 51));

        linearTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linearTabMouseClicked(evt);
            }
        });

        linearLabel.setText("Linear");

        javax.swing.GroupLayout linearTabLayout = new javax.swing.GroupLayout(linearTab);
        linearTab.setLayout(linearTabLayout);
        linearTabLayout.setHorizontalGroup(
            linearTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(linearTabLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(linearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        linearTabLayout.setVerticalGroup(
            linearTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, linearTabLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(linearLabel)
                .addGap(41, 41, 41))
        );

        tactileTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tactileTabMouseClicked(evt);
            }
        });

        tactileLabel.setText("Tactile");

        javax.swing.GroupLayout tactileTabLayout = new javax.swing.GroupLayout(tactileTab);
        tactileTab.setLayout(tactileTabLayout);
        tactileTabLayout.setHorizontalGroup(
            tactileTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tactileTabLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(tactileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tactileTabLayout.setVerticalGroup(
            tactileTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tactileTabLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(tactileLabel)
                .addGap(40, 40, 40))
        );

        clickyTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickyTabMouseClicked(evt);
            }
        });

        clickyLabel.setText("Clicky");

        javax.swing.GroupLayout clickyTabLayout = new javax.swing.GroupLayout(clickyTab);
        clickyTab.setLayout(clickyTabLayout);
        clickyTabLayout.setHorizontalGroup(
            clickyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clickyTabLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(clickyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        clickyTabLayout.setVerticalGroup(
            clickyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clickyTabLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(clickyLabel)
                .addGap(29, 29, 29))
        );

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel3.setText("keyswitch panel");

        javax.swing.GroupLayout keyswitchMenuPanelLayout = new javax.swing.GroupLayout(keyswitchMenuPanel);
        keyswitchMenuPanel.setLayout(keyswitchMenuPanelLayout);
        keyswitchMenuPanelLayout.setHorizontalGroup(
            keyswitchMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyswitchMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(keyswitchMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clickyTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(linearTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tactileTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(keyswitchMenuPanelLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        keyswitchMenuPanelLayout.setVerticalGroup(
            keyswitchMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyswitchMenuPanelLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel3)
                .addGap(46, 46, 46)
                .addComponent(linearTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tactileTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clickyTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jLayeredPane3.setLayer(keyswitchDisplayPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(keyswitchMenuPanel, javax.swing.JLayeredPane.MODAL_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
            .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(keyswitchDisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane3Layout.createSequentialGroup()
                    .addComponent(keyswitchMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 443, Short.MAX_VALUE)))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(keyswitchDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(keyswitchMenuPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout keyswitchPanelLayout = new javax.swing.GroupLayout(keyswitchPanel);
        keyswitchPanel.setLayout(keyswitchPanelLayout);
        keyswitchPanelLayout.setHorizontalGroup(
            keyswitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(keyswitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        keyswitchPanelLayout.setVerticalGroup(
            keyswitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(keyswitchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.Alignment.TRAILING))
        );

        keyswitchPane.setLayer(keyswitchPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout keyswitchPaneLayout = new javax.swing.GroupLayout(keyswitchPane);
        keyswitchPane.setLayout(keyswitchPaneLayout);
        keyswitchPaneLayout.setHorizontalGroup(
            keyswitchPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(keyswitchPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(keyswitchPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(keyswitchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        keyswitchPaneLayout.setVerticalGroup(
            keyswitchPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(keyswitchPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(keyswitchPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(keyswitchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        MainDisplayPanel.add(keyswitchPane);

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
                .addComponent(MainDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
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
        loadTab.setBackground(new Color(128,128,128));
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
        loadTab.setBackground(new Color(128,128,128));
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
        loadTab.setBackground(new Color(128,128,128));
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
        loadTab.setBackground(new Color(128,128,128));
        cartTab.setBackground(new Color(128,128,128));
        //option dialog popup
//        String selectedKeycap = "Keycaps: "+keycapJList.getSelectedValue();
//        System.out.println(selectedKeycap);
        String saveText = "current items";
        int response = JOptionPane.showConfirmDialog(null,saveText, "Add selected item to cart?", JOptionPane.YES_NO_CANCEL_OPTION);
        if (response == JOptionPane.YES_OPTION)
        {   //save cart

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
        loadTab.setBackground(new Color(128,128,128));
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
loadTab.setBackground(new Color(128,128,128));
            
    }//GEN-LAST:event_cartTabMouseClicked

    private void linearTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_linearTabMouseClicked
        // TODO add your handling code here:
        //display linear switch panel
        linearPanel.setVisible(true);
        tactilePanel.setVisible(false);
        clickyPanel.setVisible(false);
        //keyswitchMenuPanel display
        keyswitchMenuPanel.setVisible(true);
        //change current tab colour according to current selection
        linearTab.setBackground(Color.white);
        tactileTab.setBackground(new Color(128,128,128));
        clickyTab.setBackground(new Color(128,128,128));
    }//GEN-LAST:event_linearTabMouseClicked

    private void tactileTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tactileTabMouseClicked
        // TODO add your handling code here:
        //display tactile panel
        linearPanel.setVisible(false);
        tactilePanel.setVisible(true);
        clickyPanel.setVisible(false);
        //keyswitchMenuPanel display
        keyswitchMenuPanel.setVisible(true);
        //change current tab colour according to current selection
        tactileTab.setBackground(Color.white);
        linearTab.setBackground(new Color(128,128,128));
        clickyTab.setBackground(new Color(128,128,128));
    }//GEN-LAST:event_tactileTabMouseClicked

    private void clickyTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickyTabMouseClicked
        // TODO add your handling code here:
        //display clicky panel
        linearPanel.setVisible(false);
        tactilePanel.setVisible(false);
        clickyPanel.setVisible(true);
        //keyswitchMenuPanel display
        keyswitchMenuPanel.setVisible(true);
        //change current tab colour according to current selection
        clickyTab.setBackground(Color.white);
        tactileTab.setBackground(new Color(128,128,128));
        linearTab.setBackground(new Color(128,128,128));
    }//GEN-LAST:event_clickyTabMouseClicked

    private void keycapJListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keycapJListMouseClicked
        // TODO add your handling code here:
//        ImageIcon icon = new ImageIcon("src\\main\\java\\Resources\\apple.png");
//        JPanel keycapPanel = new JPanel (new BorderLayout());
//        keycapPanel.add(textPanel);
//        keycapPanel.add();
        String selectedKeycap = "Keycaps: "+keycapJList.getSelectedValue();
        System.out.println(selectedKeycap);
        String itemLink = keycapJList.getSelectedValue();
        int response = JOptionPane.showConfirmDialog(null,itemLink, "Add selected item to cart?", JOptionPane.YES_NO_CANCEL_OPTION);
        if (response == JOptionPane.YES_OPTION)
        {   //add to cart
//            try {
//            Cart.addCart(selectedKeycap);
            cartObj.addCart(selectedKeycap);
           
//            Cart addKeycap = null; 
//            try {
//                addKeycap = new Cart (selectedKeycap);
//            } catch (IOException ex) {
//                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            addKeycap.addCart(selectedKeycap);
//            } catch (IOException ex) {
//            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
//            } 
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
        String itemLink = keyswitchJList.getSelectedValue()+" on https://shockport.com/";
//        JOptionPane.showMessageDialog(rootPane,itemLink, "Selected switch", JOptionPane.INFORMATION_MESSAGE);
        int response = JOptionPane.showConfirmDialog(null,itemLink, "Add selected item to cart?", JOptionPane.YES_NO_CANCEL_OPTION);
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
//               displayCart();
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
    private javax.swing.JLabel cartLabel;
    private javax.swing.JPanel cartPanel;
    private javax.swing.JPanel cartTab;
    public javax.swing.JTextArea cartTextArea;
    private javax.swing.JLabel clickyLabel;
    private javax.swing.JPanel clickyPanel;
    private javax.swing.JPanel clickyTab;
    private javax.swing.JPanel defaultPanel;
    private javax.swing.JButton editCartButton;
    private javax.swing.JLabel homeIcon;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JPanel homeTab;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField keyCapSearch;
    private javax.swing.JList<String> keycapJList;
    private javax.swing.JLabel keycapsLabel;
    private javax.swing.JPanel keycapsPanel;
    private javax.swing.JPanel keycapsTab;
    private javax.swing.JPanel keyswitchDisplayPanel;
    private javax.swing.JList<String> keyswitchJList;
    private javax.swing.JLabel keyswitchLabel;
    private javax.swing.JPanel keyswitchMenuPanel;
    private javax.swing.JDesktopPane keyswitchPane;
    private javax.swing.JPanel keyswitchPanel;
    private javax.swing.JTextField keyswitchSearch;
    private javax.swing.JPanel keyswitchTab;
    private javax.swing.JPanel layoutPanel;
    private javax.swing.JPanel layoutTab;
    private javax.swing.JLabel linearLabel;
    private javax.swing.JPanel linearPanel;
    private javax.swing.JPanel linearTab;
    private javax.swing.JLabel loadLabel;
    private javax.swing.JPanel loadTab;
    private javax.swing.JLabel saveLabel;
    private javax.swing.JPanel saveTab;
    private javax.swing.JLabel tactileLabel;
    private javax.swing.JPanel tactilePanel;
    private javax.swing.JPanel tactileTab;
    private javax.swing.JDialog testdiag;
    private javax.swing.JButton updateCartButton;
    // End of variables declaration//GEN-END:variables
}
