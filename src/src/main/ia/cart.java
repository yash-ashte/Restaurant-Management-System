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
public class cart extends javax.swing.JFrame {

    

    /**
     * Creates new form cart
     * @param dn
     * @param c
     * @param vnv
     * @param dt
     */
    //Initializing variables for dish name, cost, veg/non-veg, dish type and quantity
String dname,cost,vegnv,dtype,quant,user,u1;
DefaultTableModel dtm = new DefaultTableModel();
    Statement smt;
    PreparedStatement pst,ps1;
    ResultSet rs1,rs;
    
    
    public void retrieve(){//Retrieve data from databse into table
try
    {
            cart.setModel(dtm);//link table to table-model
            cart.setAutoscrolls(true);
            dtm.addColumn("Order Number");//Adding columns to table
            dtm.addColumn("Dish Name");
            dtm.addColumn("Quantity");
            dtm.addColumn("Cost");           
            dtm.addColumn("Veg/Non-Veg");
            dtm.addColumn("Type");
            dtm.addColumn("Status"); 
            //Defining sql statement
            String sql = "select * from orders where username=? ";
            pst =  sql_connection.conneect_DB().prepareStatement(sql);
            pst.setString(1, user);//setting parameter
            rs1 = pst.executeQuery();//creating result set
            cart.setDefaultEditor(Object.class, null);
            if(rs1.next()==false){//checking if cart has any orders 
                JOptionPane.showMessageDialog(null,"Your Cart is Empty:(");}
            //running for all results
                dtm.addRow(new Object[] { rs1.getString("ordernum"),//adding results to table
        rs1.getString("dishname"), rs1.getString("quantity"), rs1.getString("cost"),
        rs1.getString("veg_nonveg"),rs1.getString("dish_type"),rs1.getString("status")});           
    }    catch (SQLException ex)    {
        System.out.println(ex);
    }
}
    public cart() {
        initComponents();
         retrieve();
         //back is jLabel in background
         back.setIcon(sql_connection.scaleimg(back.getWidth(),back.getHeight()));
    }
    public cart(String un) {
        initComponents();
         
         user=un;
        
         
        u1=un;
         retrieve();
         
         //back is jLabel in background
         back.setIcon(sql_connection.scaleimg(back.getWidth(),back.getHeight()));
    }
   
        
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cart = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        ordernum = new javax.swing.JLabel();
        dishname = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        bill = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        back = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CART");
        jLabel1.setOpaque(true);

        cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        cart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cart);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 16)); // NOI18N
        jLabel3.setText("Your Selection:");

        jButton1.setBackground(new java.awt.Color(0, 204, 0));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton1.setText("Delete");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ordernum, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dishname, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bill, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ordernum, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dishname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bill, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 770, 500));
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 590));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 590));

        jMenu1.setBackground(new java.awt.Color(0, 0, 0));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Menu");
        jMenu1.setOpaque(true);
        jMenu1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu1MenuSelected(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(0, 0, 0));
        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Reserve Table");
        jMenu2.setOpaque(true);
        jMenu2.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu2MenuSelected(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("View Cart");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           //delete from orders using ordernum as criteria
        try{           
            String on=ordernum.getText();//getting order number
            //creating sql statement
            String sql1= "SELECT  `status` FROM `orders` WHERE ordernum='"+on+"'";
            ps1=sql_connection.conneect_DB1().prepareStatement(sql1);
            rs=ps1.executeQuery();//getting result set
        while(rs.next()){//running for all values in result 
            if(rs.getString("status").equals("Accepted")){//checking if order is accepted
                 JOptionPane.showMessageDialog(null,"Already Accepted Order!");}
            else{//if order is not accepted      
                //sql for deleting order from database
                String sql = "Delete From orders Where ordernum='"+on+"'";
                pst = sql_connection.conneect_DB1().prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record has been Deleted!");
                int i=0;
                while(i<dtm.getRowCount()){
                dtm.removeRow(i);//removing all rows from database    
            }
             sql = "select * from orders where username=?";
           
            pst =  sql_connection.conneect_DB().prepareStatement(sql);
            pst.setString(1,user );
            rs1 = pst.executeQuery();
            
            cart.setDefaultEditor(Object.class, null);
             if(rs1.next()==false)
                JOptionPane.showMessageDialog(null,"Your Cart is Empty :(");
             else{
            while (rs1.next())
            {
                  
                dtm.addRow(new Object[] { rs1.getString("ordernum"),rs1.getString("dishname"), rs1.getString("quantity"), rs1.getString("cost"),rs1.getString("veg_nonveg"),rs1.getString("dish_type"),rs1.getString("status")});
            }
            ordernum.setText("");
            dishname.setText("");
            quantity.setText("");
            status.setText("");
            bill.setText("");
           }}
           }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(cart.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected
        // TODO add your handling code here:
        //Go to Menu Form
        menu mn=new menu(u1);
        mn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MenuSelected

    private void jMenu2MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu2MenuSelected
        // TODO add your handling code here:
        //Go to reserve form
        reserve rv=new reserve(user);
        rv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu2MenuSelected

    private void cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartMouseClicked
        //Display selected data from table into textbox
        try{
            cart.setModel(dtm);//linking table to table-model
            int selcrow = cart.getSelectedRow();//getting selected row
            cart.setEnabled(true);
            //setting text by getting value and converting to string
            ordernum.setText(dtm.getValueAt(selcrow,0).toString());
            dishname.setText(dtm.getValueAt(selcrow,1).toString());
            quantity.setText(dtm.getValueAt(selcrow,2).toString());
            bill.setText(dtm.getValueAt(selcrow,3).toString());
            status.setText(dtm.getValueAt(selcrow,6).toString());
        }
         catch(Exception ex)
        {

        }
    }//GEN-LAST:event_cartMouseClicked

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
            java.util.logging.Logger.getLogger(cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new cart().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel bill;
    private javax.swing.JTable cart;
    private javax.swing.JLabel dishname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel ordernum;
    private javax.swing.JLabel quantity;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
