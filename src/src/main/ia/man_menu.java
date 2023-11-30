/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.ia;

import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yash
 */
public class man_menu extends javax.swing.JFrame {

    /**
     * Creates new form man_menu
     */
     DefaultTableModel dtm = new DefaultTableModel();
     Statement smt;
    PreparedStatement pst,ps,ps1;
    String sql="", dish_name="",cost="",veg_nonveg="",dish_type="";
    ResultSet rs1,rs4,rs3,rs,rs5;
    //bg img
    public final void scaleimg()
    {
    
    ImageIcon icon1=new ImageIcon("C:\\Users\\Yash\\Documents\\NetBeansProjects\\Main IA\\src\\main\\ia\\search icon.png");
   
      Image  img1 = icon1.getImage();
    Image iscl1=img1.getScaledInstance(search_icon.getWidth(),search_icon.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon scl1=new ImageIcon(iscl1);
    search_icon.setIcon(scl1);
    }
    //extract menu card from database to table
    public void retrieve(){
try
    {
            
        
       smt=( sql_connection.conneect_DB().createStatement());
            menuTable.setModel(dtm);
            menuTable.setAutoscrolls(true);
            dtm.addColumn("Dish Name");
            dtm.addColumn("Cost");           
            dtm.addColumn("Dish_Type");
            dtm.addColumn("Veg/ Non-Veg");
            dtm.addColumn("Quantity");
           
          
            String sql = "select * from menu";
           
            pst =  sql_connection.conneect_DB().prepareStatement(sql);
            rs1 = pst.executeQuery();
            
            menuTable.setDefaultEditor(Object.class, null);
            while (rs1.next())
            {
                         
                dtm.addRow(new Object[] { rs1.getString("dish_name"),rs1.getString("cost"), rs1.getString("dish_type"),rs1.getString("veg_nonveg"),rs1.getString("quantity")});
            }
        
    }
    catch (SQLException ex)
    {
        System.out.println(ex);
    }
    }
    public man_menu() {
        initComponents();
        bg.setIcon(sql_connection.scaleimg(bg.getWidth(),bg.getHeight()));
        bg2.setIcon(sql_connection.scaleimg(bg2.getWidth(),bg2.getHeight()));
        scaleimg();
        retrieve();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Menu = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        search_icon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        search_box = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        filters = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        vegonly = new javax.swing.JCheckBox();
        ordernum = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();
        edit = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        type = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        vnvt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        quant = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bg2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setBorder(new javax.swing.border.MatteBorder(null));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_iconMouseClicked(evt);
            }
        });
        menu.add(search_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 50, 40));

        jLabel2.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel2.setText("Menu");
        menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        search_box.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        search_box.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        menu.add(search_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 148, 388, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel3.setText("Search");
        menu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 123, -1, -1));

        filters.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "starter", "Main Course", "Dessert", "" }));
        filters.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filtersItemStateChanged(evt);
            }
        });
        menu.add(filters, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 145, 225, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel4.setText("Add Filters");
        menu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 123, -1, -1));

        vegonly.setText("Show Veg Only");
        vegonly.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                vegonlyItemStateChanged(evt);
            }
        });
        vegonly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vegonlyActionPerformed(evt);
            }
        });
        menu.add(vegonly, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 210, -1, -1));
        menu.add(ordernum, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 45, 98, 20));

        menuTable.setBorder(new javax.swing.border.MatteBorder(null));
        menuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        menuTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(menuTable);

        menu.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 257, 812, 170));

        jButton1.setText("Add Dish");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        menu.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, -1, -1));

        jLabel5.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabel5.setText("Back to Home");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        menu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, -1, -1));

        jLabel12.setText("Reset Table");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        menu.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 100, -1));

        Menu.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 840, 540));
        Menu.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 640));

        jTabbedPane1.addTab("Menu", Menu);

        edit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(0, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Edit Selection");
        jLabel6.setOpaque(true);

        jLabel7.setText("Dish name");

        dname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dnameKeyTyped(evt);
            }
        });

        jLabel8.setText("Dish Type");

        jLabel9.setText("Veg/Non-veg");

        jLabel10.setText("Cost");

        jLabel11.setText("Quantity");

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete Dish");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("Add Dish");
        jButton2.setEnabled(isEnabled());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Back to Menu");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quant)
                                    .addComponent(price)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vnvt, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(type, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(dname)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jButton4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(34, 34, 34)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(142, 142, 142))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(vnvt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(quant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(41, 41, 41)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        edit.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 380, 580));
        edit.add(bg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 640));

        jTabbedPane1.addTab("Dish", edit);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 669));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filtersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filtersItemStateChanged
        //add filters to menu
         try{
             if(String.valueOf(filters.getSelectedItem()).equals("-select-")){}
             else{
             vegonly.setSelected(false);
            //Connection establishment
            menuTable.setModel(dtm);//linking to table-model
            pst=sql_connection.conneect_DB().prepareStatement("SELECT * FROM menu WHERE dish_type=?");
            pst.setString(1,String.valueOf(filters.getSelectedItem()));
            rs4=pst.executeQuery();//getting result set of filtered values
            if(rs4.next()==false){//If result set is empty
                JOptionPane.showMessageDialog(this,"Dish not available");}
            int trow=dtm.getRowCount();//getting no. of rows
            for(int i=trow-1;i>=0;i--){
                dtm.removeRow(i);}//Deleting all rows
            while(rs4.next()){//running for all results          
                menuTable.setDefaultEditor(Object.class, null);
                dtm.addRow(new Object[] { rs4.getString("dish_name"),
                rs4.getString("cost"),rs4.getString("dish_type"), //Adding filtered dishes 
                rs4.getString("veg_nonveg"), rs4.getString("quantity") });           
        }}}
        catch(SQLException ex){}
    }//GEN-LAST:event_filtersItemStateChanged

    private void vegonlyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_vegonlyItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_vegonlyItemStateChanged

    private void vegonlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vegonlyActionPerformed
        // TODO add your handling code here:
        //show veg only in menu
        try
        {
filters.setSelectedItem("-select-");
            menuTable.setModel(dtm);
            if(vegonly.isSelected()){

                sql = "select * from menu where Veg_Nonveg='veg'";
            }
            else{
                sql= "select * from menu";
            }
            int trow=dtm.getRowCount();

            for(int i=trow-1;i>=0;i--){
                dtm.removeRow(i);
            }
            pst = sql_connection.conneect_DB().prepareStatement(sql);
            rs3 = pst.executeQuery();

            menuTable.setDefaultEditor(Object.class, null);

            while (rs3.next())
            {

                dtm.addRow(new Object[] { rs3.getString("Dish_Name"),rs3.getString("Cost"), rs3.getString("Dish_Type"), rs3.getString("Veg_Nonveg"), rs3.getString("quantity")});

            }

        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
    }//GEN-LAST:event_vegonlyActionPerformed

    private void menuTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTableMouseClicked
        // TODO add your handling code here:
        //select dish from table
        try{
            menuTable.setModel(dtm);
            int selcrow = menuTable.getSelectedRow();
            menuTable.setEnabled(true);

            
            jTabbedPane1.setSelectedIndex(1); 
           dname.setText(dtm.getValueAt(selcrow,0).toString());
           type.setText(dtm.getValueAt(selcrow,3).toString());
           vnvt.setText(dtm.getValueAt(selcrow,2).toString());
            price.setText(dtm.getValueAt(selcrow,1).toString());
             quant.setText(dtm.getValueAt(selcrow,4).toString());
            jTabbedPane1.setSelectedIndex(1);
        }
        catch(Exception ex)
        {

        }
    }//GEN-LAST:event_menuTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //go to add dish
         dname.setText("");
           type.setText("");
           vnvt.setText("");
            price.setText("");
             quant.setText("");
        jTabbedPane1.setSelectedIndex(1);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //update dish
        try{
            if(dname.getText().equals("")||type.getText().equals("")||vnvt.getText().equals("")||price.getText().equals("")||quant.getText().equals(""))
            {JOptionPane.showMessageDialog(this,"Enter valid details");
            }
            else{
           String vnv=vnvt.getText();//getting values from textboxes for veg-nonve
           String dn=dname.getText();//dish name
           String dt=type.getText();//dish type
           String c=price.getText();//cost
           String q=quant.getText();//quantity            
           //sql statement for Updating a record using dish name as criteria
           String sql = "UPDATE menu SET cost=?,veg_nonveg=?, dish_type=?, quantity=? Where dish_name=?";
           pst = sql_connection.conneect_DB1().prepareStatement(sql);
           pst.setString(1, c);//updating cost
           pst.setString(3, vnv);
           pst.setString(2, dt);//dish type
           //veg/non-veg
           pst.setString(4, q);//quantity
           pst.setString(5, dn);//dishname
           int i=pst.executeUpdate();
           if(i==1){
                JOptionPane.showMessageDialog(null,"Record added successfully");}
        }}        catch (SQLException ex)    {
            Logger.getLogger(man_menu.class.getName()).log(Level.SEVERE, null, ex);     }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //delete dish
         try{           
            String dn=dname.getText();//getting dish name           
            //swl fr deleting using dishname as parameter
            String sql = "Delete From menu Where dish_name='"+dn+"'";
            pst = sql_connection.conneect_DB().prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record has been Deleted!");
            dname.setText("");//setting dishname textboxes to blank
            type.setText("");//dish type
            vnvt.setText("");//veg non veg
            price.setText("");//price
            quant.setText("");//quantity            
            try {
            int trow=dtm.getRowCount();//getting row count
             for(int i=trow-1;i>=0;i--){
                 dtm.removeRow(i);}//deleting all rows
             String sql1 = "select * from menu";
             
             pst =  sql_connection.conneect_DB().prepareStatement(sql1);
             rs1 = pst.executeQuery();
             
             menuTable.setDefaultEditor(Object.class, null);
             
             while (rs1.next())
             {
                 
                 dtm.addRow(new Object[] { rs1.getString("Dish_Name"),rs1.getString("Cost"), rs1.getString("veg_nonveg"), rs1.getString("dish_type"),rs1.getString("quantity")});
             }
              jTabbedPane1.setSelectedIndex(0);
            
         } catch (SQLException ex) {
             Logger.getLogger(man_menu.class.getName()).log(Level.SEVERE, null, ex);
         }
            jTabbedPane1.setSelectedIndex(0);
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         try {
             //defining sql to check if dish exists already
             String sql ="SELECT * FROM menu WHERE dish_name = '"+dname.getText()+"'";
              ps1 = sql_connection.conneect_DB().prepareStatement(sql);
             rs5=ps1.executeQuery();//getting result for existence of dish
             if(rs5.next()==false){//if dish doesn't exist
            ps=sql_connection.conneect_DB().prepareStatement("insert into menu values(?,?,?,?,?)");
            ps.setString(1, dname.getText());//adding dish name to menu
            ps.setString(2,price.getText() );//cost
            
            ps.setString(4, vnvt.getText());//veg or non-veg
            ps.setString(3, type.getText());//dish type
            ps.setString(5, quant.getText());//quantity available in the restaurant
            int i=ps.executeUpdate();//updating the database
            if(i==1){//checking if update happened
               JOptionPane.showMessageDialog(null,"Record added successfully");}}
             else
                 JOptionPane.showMessageDialog(null,"Dish Already Exists");
           dname.setText("");//setting textboxes to blank again
           type.setText("");
           vnvt.setText("");
           price.setText("");
           quant.setText("");
         } catch (SQLException ex) {
             Logger.getLogger(man_menu.class.getName()).log(Level.SEVERE, null, ex);
         }            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void dnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dnameKeyTyped
        // TODO add your handling code here:
        //enable add dish
        jButton2.isEnabled();
    }//GEN-LAST:event_dnameKeyTyped

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
         try {
             // TODO add your handling code here:
             //view menu
             int trow=dtm.getRowCount();
             for(int i=trow-1;i>=0;i--){
                 dtm.removeRow(i);
             }
             String sql = "select * from menu";
             
             pst =  sql_connection.conneect_DB().prepareStatement(sql);
             rs1 = pst.executeQuery();
             
             menuTable.setDefaultEditor(Object.class, null);
             
             while (rs1.next())
             {
                 
                 dtm.addRow(new Object[] { rs1.getString("Dish_Name"),rs1.getString("Cost"), rs1.getString("veg_nonveg"), rs1.getString("dish_type"),rs1.getString("quantity")});
             }
              jTabbedPane1.setSelectedIndex(0);
            
         } catch (SQLException ex) {
             Logger.getLogger(man_menu.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        //go to home
        man_home mh=new man_home();
        mh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void search_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_iconMouseClicked
        // TODO add your handling code here:
        try {            
            String xp2 = search_box.getText();//Getting searched dishname
            //creating sql statement
            String sql1 ="SELECT * FROM `menu` WHERE `Dish_Name` = '"+xp2+"'";
            PreparedStatement ps1 = sql_connection.conneect_DB().prepareStatement(sql1);
            rs5 = ps1.executeQuery();//Getting result set from database
            int trow=dtm.getRowCount();//getting no. of rows in table            
            menuTable.setModel(dtm);//linking table to table-model
            menuTable.setAutoscrolls(true);          
            menuTable.setDefaultEditor(Object.class, null);
            for(int i=trow-1;i>=0;i--){
                dtm.removeRow(i);//Removing all rows
            }
            
            while (rs5.next()){//running for all results           
                dtm.addRow(new Object[] { rs5.getString("dish_name"),
                rs5.getString("cost"),rs5.getString("dish_type"),//Adding result rows
                rs5.getString("veg_nonveg"),rs5.getString("quantity")});
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_search_iconMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
         try {
             filters.setSelectedItem("-select-");
             vegonly.setSelected(false);
             // TODO add your handling code here:
             int trow=dtm.getRowCount();
             for(int i=trow-1;i>=0;i--){
                 dtm.removeRow(i);
             }
             String sql = "select * from menu";
             
             pst =  sql_connection.conneect_DB().prepareStatement(sql);
             rs1 = pst.executeQuery();
             
             menuTable.setDefaultEditor(Object.class, null);
             
             while (rs1.next())
             {
                 
                 dtm.addRow(new Object[] { rs1.getString("Dish_Name"),rs1.getString("Cost"),  rs1.getString("dish_type") ,rs1.getString("veg_nonveg"),rs1.getString("quantity") });
             }
         } catch (SQLException ex) {
             Logger.getLogger(man_menu.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jLabel12MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(man_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(man_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(man_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(man_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new man_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg2;
    private javax.swing.JTextField dname;
    private javax.swing.JPanel edit;
    private javax.swing.JComboBox<String> filters;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel menu;
    private javax.swing.JTable menuTable;
    private javax.swing.JLabel ordernum;
    private javax.swing.JTextField price;
    private javax.swing.JTextField quant;
    private javax.swing.JTextField search_box;
    private javax.swing.JLabel search_icon;
    private javax.swing.JTextField type;
    private javax.swing.JCheckBox vegonly;
    private javax.swing.JTextField vnvt;
    // End of variables declaration//GEN-END:variables
}

