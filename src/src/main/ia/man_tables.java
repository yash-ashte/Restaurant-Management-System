package main.ia;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.ia.sql_connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yash
 */
public class man_tables extends javax.swing.JFrame {

    /**
     * Creates new form man_tables
     */
    Connection cin;
    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtm1 = new DefaultTableModel();
      DefaultTableModel dtm2 = new DefaultTableModel();
       DefaultTableModel dtm3 = new DefaultTableModel();
    String sql="",st="",tnt="",sql4,sqlr2,sql5="";
    String un="";
    PreparedStatement ps6,ps7,ps8,ps9,ps10,ps11,ps12,ps46;
    ResultSet rs,rs7,rs8,rs9,rs10,rs11,rs12,rs46,rs50;
    int tn=0;
    
    //pending reservations into table
    public void pen_res(){
        try {//selecting from reservations
            sqlr2="select * from reservations";
            ps11=sql_connection.conneect_DB1().prepareStatement(sqlr2);            
            rs11=ps11.executeQuery();//getting results
            pen_res.setModel(dtm2);//linking table to table-model
            pen_res.setAutoscrolls(true);
            int trow=dtm2.getRowCount();//deleting rows from pending reservations
            for(int j=trow-1;j>=0;j--){
                dtm2.removeRow(j);}
            pen_res.setDefaultEditor(Object.class, null);
            while (rs11.next()){                
                dtm2.addRow(new Object[] { rs11.getString("res_number"),
  rs11.getString("username"), rs11.getString("date"), rs11.getString("time"),
  rs11.getString("people"),rs11.getString("request")});//adding new rows to table
            }} catch (SQLException ex) {
            Logger.getLogger(man_tables.class.getName()).log(Level.SEVERE, null, ex);
        }}
    public void al_res(){
        try {//selecting from reservations
            sqlr2="select * from al_reserved where tab_number= ?";
            ps11=sql_connection.conneect_DB1().prepareStatement(sqlr2); 
            ps11.setString(1, jLabel46.getText());
            rs50=ps11.executeQuery();//getting results
            al_res.setModel(dtm3);//linking table to table-model
            al_res.setAutoscrolls(true);
             
   
            al_res.setDefaultEditor(Object.class, null);
            while (rs50.next()){                
                dtm3.addRow(new Object[] { rs50.getString("res_number"),
  rs50.getString("username"), rs50.getString("date"), rs50.getString("time"),
  rs50.getString("people"),rs50.getString("request")});//adding new rows to table
            }} catch (SQLException ex) {
            Logger.getLogger(man_tables.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    //get table details
    public void man_tableMain(String nt){
     try {
            tnt=nt;//enter parameter as table number
            String sqlt="select * from tables where tab_number = ?";
            ps7=sql_connection.conneect_DB1().prepareStatement(sqlt);
            ps7.setString(1, tnt);//selecting details of particular table
            rs7=ps7.executeQuery();//getting results
            while(rs7.next()){//checking for all results 
                //selecting the radio button acc to status
                if(rs7.getString("status").equalsIgnoreCase("vacant")){
            vacant.setSelected(true);}//for vacant
            if(rs7.getString("status").equalsIgnoreCase("occupied")){
            occupied.setSelected(true);}//for occupied
            if(rs7.getString("status").equalsIgnoreCase("cleaning")){
            cleaning.setSelected(true);}//for cleaning                   
        jLabel7.setText(rs7.getString("max_people"));//setting no,of ppl
            jLabel11.setText(rs7.getString("user"));//setting username
            un=jLabel11.getText();}//getting username in variable
            jLabel46.setText(tnt);//setting table number
          //creating bill table(similar to retreieve in cart form)            
         String sqlu="select * from orders where username=?";
            ps8=sql_connection.conneect_DB1().prepareStatement(sqlu);
            ps8.setString(1, un);
            rs8=ps8.executeQuery();//getting results
            
            bill.setDefaultEditor(Object.class, null);
            while (rs8.next()){//running for all results
      if(rs8.getString("status").equalsIgnoreCase("accepted"))//to display only accepted orders
      dtm.addRow(new Object[] { rs8.getString("ordernum"),rs8.getString("dishname"), 
               rs8.getString("quantity"), rs8.getString("cost")});//adding new rows to table
            }
            jTabbedPane1.setSelectedIndex(1);//opening tab 2            
        } catch (SQLException ex) {
            Logger.getLogger(man_tables.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //colour tables
    public void col_tab(){
         try{ //sql to select details from table
            String sql = "select * from tables";
            ps6 =  sql_connection.conneect_DB().prepareStatement(sql);
            rs = ps6.executeQuery();//result set generated          
            while (rs.next()){//checking for all results
         st=rs.getString("status");//getting status in a variable
	tn=Integer.parseInt(rs.getString("tab_number"));//converting string to int
        //For status is vacant        
        if(st.equalsIgnoreCase("vacant")){
                if(tn==1)//checking is done for all tables
                jLabel19.setBackground(Color.green);
                else if(tn==2)
                jLabel1.setBackground(Color.green);
                else if(tn==3)
                jLabel20.setBackground(Color.green);
                else if(tn==4)
                jLabel21.setBackground(Color.green);
                else if(tn==5)
                jLabel22.setBackground(Color.green);
                else if(tn==6)
                jLabel25.setBackground(Color.green);
                else if(tn==7)
                jLabel26.setBackground(Color.green);
                else if(tn==8)
                jLabel27.setBackground(Color.green);
                else if(tn==9)
                jLabel28.setBackground(Color.green);
                else if(tn==10)
                jLabel29.setBackground(Color.green);
                else if(tn==11)
                jLabel30.setBackground(Color.green);
                else if(tn==12)
                jLabel31.setBackground(Color.green); 
		         
                
                
            }//for status is occupied
            else if(st.equalsIgnoreCase("occupied")){
                if(tn==1)//checking done for all tables
                jLabel19.setBackground(Color.red);
                else if(tn==2)
                jLabel1.setBackground(Color.red);
                else if(tn==3)
               jLabel20.setBackground(Color.red);
                else if(tn==4)
                jLabel21.setBackground(Color.red);
                else if(tn==5)
               jLabel22.setBackground(Color.red);
                else if(tn==6)
                jLabel25.setBackground(Color.red);
                else if(tn==7)
               jLabel26.setBackground(Color.red);
                else if(tn==8)
               jLabel27.setBackground(Color.red);
                else if(tn==9)
                jLabel28.setBackground(Color.red);
                else if(tn==10)
                jLabel29.setBackground(Color.red);
                else if(tn==11)
               jLabel30.setBackground(Color.red);
                else if(tn==12)
                jLabel31.setBackground(Color.red); 
		       
                
                
            }//for status=cleaning
            else if(st.equalsIgnoreCase("cleaning")){
                if(tn==1)//checking done for all tables
                jLabel19.setBackground(Color.yellow);
                else if(tn==2)
                jLabel1.setBackground(Color.yellow);
                else if(tn==3)
                jLabel20.setBackground(Color.yellow);
                else if(tn==4)
                jLabel21.setBackground(Color.yellow);
                else if(tn==5)
                jLabel22.setBackground(Color.yellow);
                else if(tn==6)
               jLabel25.setBackground(Color.yellow);
                else if(tn==7)
                jLabel26.setBackground(Color.yellow);
                else if(tn==8)
              jLabel27.setBackground(Color.yellow);
                else if(tn==9)
                jLabel28.setBackground(Color.yellow);
                else if(tn==10)
                jLabel29.setBackground(Color.yellow);
                else if(tn==11)
                jLabel30.setBackground(Color.yellow);
                else if(tn==12)
                jLabel31.setBackground(Color.yellow); }}}
         catch (SQLException ex) {
            Logger.getLogger(man_tables.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
    }
    public man_tables() {  
        initComponents();
          bill.setModel(dtm);//linking table to table-model
            bill.setAutoscrolls(true);
            dtm.addColumn("Order Number");//adding columns
            dtm.addColumn("Dish Name");
            dtm.addColumn("Quantity");
            dtm.addColumn("Cost");
        al_res.setModel(dtm1);
        dtm1.addColumn("Reservation Number");
            dtm1.addColumn("Username");
            dtm1.addColumn("Date");
            dtm1.addColumn("Time");
            dtm1.addColumn("No. of People");
            dtm1.addColumn("Special Requests");
            pen_res.setModel(dtm2);
        dtm2.addColumn("Reservation Number");
            dtm2.addColumn("Username");
            dtm2.addColumn("Date");//adding colums
            dtm2.addColumn("Time");
            dtm2.addColumn("No. of People");
            dtm2.addColumn("Special Requests");
        col_tab();
                bg.setIcon(sql_connection.scaleimg(bg.getWidth(),bg.getHeight()));
                bg2.setIcon(sql_connection.scaleimg(bg.getWidth(),bg.getHeight()));
                  bg3.setIcon(sql_connection.scaleimg(bg.getWidth(),bg.getHeight()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tab_screen = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();
        tab_deets = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bill = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        vacant = new javax.swing.JRadioButton();
        occupied = new javax.swing.JRadioButton();
        cleaning = new javax.swing.JRadioButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bg2 = new javax.swing.JLabel();
        tab_reserve = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pen_res = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        al_res = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        bg3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab_screen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Table 2");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Table 1");
        jLabel19.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jLabel19.setOpaque(true);
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Table 3");
        jLabel20.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jLabel20.setOpaque(true);
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Table 4");
        jLabel21.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jLabel21.setOpaque(true);
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Table 5");
        jLabel22.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jLabel22.setOpaque(true);
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Table 6");
        jLabel25.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jLabel25.setOpaque(true);
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Table 7");
        jLabel26.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jLabel26.setOpaque(true);
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Table 8");
        jLabel27.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jLabel27.setOpaque(true);
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Table 9");
        jLabel28.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jLabel28.setOpaque(true);
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Table 10");
        jLabel29.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jLabel29.setOpaque(true);
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Table 11");
        jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jLabel30.setOpaque(true);
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Table 12");
        jLabel31.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jLabel31.setOpaque(true);
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });

        jLabel32.setBackground(new java.awt.Color(0, 255, 255));
        jLabel32.setFont(new java.awt.Font("Segoe Script", 1, 48)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Tables");
        jLabel32.setOpaque(true);

        jLabel15.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabel15.setText("Back to Home");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(96, 96, 96)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(99, 99, 99)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(362, 362, 362)
                        .addComponent(jLabel15)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(4, 4, 4))
        );

        tab_screen.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 900, 580));
        tab_screen.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 640));

        jTabbedPane1.addTab("Tables", tab_screen);

        tab_deets.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Table Details");
        jLabel3.setOpaque(true);
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -5, 980, 80));

        jLabel4.setText("Table number:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jLabel46.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 101, 20));

        jLabel6.setText("Maximum Number of People:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 114, 20));

        jLabel10.setText("Being Used by:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, -1));

        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 150, 20));

        jLabel12.setText("Bill:-");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 101, -1));

        bill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(bill);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 820, 185));

        jButton14.setText("Reserve Table");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, -1, -1));

        jButton15.setText("Assign to be cleaned");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, -1, -1));

        buttonGroup1.add(vacant);
        vacant.setText("Vacant");
        jPanel4.add(vacant, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, -1, -1));

        buttonGroup1.add(occupied);
        occupied.setText("Occupied");
        jPanel4.add(occupied, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, -1, -1));

        buttonGroup1.add(cleaning);
        cleaning.setText("Cleaning");
        jPanel4.add(cleaning, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, -1, -1));

        jLabel34.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Current Status\n\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 16))); // NOI18N
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 370, 70));

        jLabel16.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabel16.setText("Back to All tables");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 530, -1, -1));

        jButton1.setText("Assign as vacant/occupied");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, -1, -1));

        tab_deets.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 970, 560));
        tab_deets.add(bg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 670));

        jTabbedPane1.addTab("Table Details", tab_deets);

        tab_reserve.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(0, 255, 255));
        jLabel13.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Assign reservation table");
        jLabel13.setOpaque(true);
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -1, 1000, 70));

        jLabel14.setText("Table number:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, -1, -1));

        jLabel17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 101, 20));

        jLabel18.setText("Pending Reservations:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 326, -1, -1));

        pen_res.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        pen_res.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pen_resMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(pen_res);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 355, 903, 172));

        jButton18.setText("Reserve Table");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 540, -1, -1));

        jLabel24.setText("Already reserved for:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        al_res.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(al_res);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 903, 142));

        jLabel8.setText("Reservation Number");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, -1, -1));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 94, 29));

        jLabel23.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabel23.setText("Back to All tables");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 550, -1, -1));

        jLabel33.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabel33.setText("Back to Table Details");
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 550, -1, 30));

        tab_reserve.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 990, 630));
        tab_reserve.add(bg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 670));

        jTabbedPane1.addTab("Reservations", tab_reserve);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1077, 669));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        
            // TODO add your handling code here:
           man_tableMain("1");
           al_res.setModel(dtm2);
           int trow=dtm2.getRowCount();//deleting rows from pending reservations
            for(int j=trow-1;j>=0;j--){
                dtm2.removeRow(j);}
            al_res();
        
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try {
            // TODO add your handling code here:
            //view reservations and assign table
            pen_res();
            tnt=jLabel46.getText();
            jLabel17.setText(tnt);
            
           sql4="select * from tables where tab_number = ?";
            
            String rn1="", sqlr=""; 
            cin=sql_connection.conneect_DB1();
            ps10=cin.prepareStatement(sql4);
           ps10.setString(1, tnt);
            rs10=ps10.executeQuery();
            System.out.println(ps10);
            while(rs10.next()){
                
            if(rs10.getString("reserved").equalsIgnoreCase("not reserved")){
                
            }
            else
            {
               rn1= rs10.getString("reserved");
               sqlr="select * from al_reserved where res_number= ?";
               ps9=sql_connection.conneect_DB1().prepareStatement(sqlr);
               ps9.setString(1, rn1);
               rs9=ps9.executeQuery();
               al_res.setModel(dtm1);
            al_res.setAutoscrolls(true);
            
                             
                                
            al_res.setDefaultEditor(Object.class, null);
            while (rs9.next())
            {                
                dtm1.addRow(new Object[] { rs9.getString("res_number"),rs9.getString("username"), rs9.getString("date"), rs9.getString("time"),rs9.getString("people"),rs9.getString("request")});
            }
               
            }
                       }jTabbedPane1.setSelectedIndex(2);
            
        } catch (SQLException ex) {
            Logger.getLogger(man_tables.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void pen_resMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pen_resMouseClicked
        // TODO add your handling code here:
        //table to label
        try{
            pen_res.setModel(dtm2);
            int selcrow = pen_res.getSelectedRow();
            pen_res.setEnabled(true);

            jLabel9.setText(dtm2.getValueAt(selcrow,0).toString());
            
        }
         catch(Exception ex)
        {

        }
    }//GEN-LAST:event_pen_resMouseClicked

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        try {
            //assign table
            String rno=jLabel9.getText();//getting reservation number
            tnt=jLabel17.getText();//getting table number
            sql5="UPDATE tables SET reserved=? WHERE tab_number=?";
            ps12=sql_connection.conneect_DB1().prepareStatement(sql5);
            ps12.setString(1, rno);//setting parameter
            ps12.setString(2, tnt);
            int i=ps12.executeUpdate();
            if(i==1)//checking if update takes place
                JOptionPane.showMessageDialog(null, "Succesfully reserved");
/*transferring the reservation details from reservations table in database 
to al_reservations table in database*/
            sql5="select * from reservations where res_number=?";
            ps12=sql_connection.conneect_DB1().prepareStatement(sql5);
            ps12.setString(1, rno);//setting parameter
            ResultSet rs25=ps12.executeQuery();//getting result
            while(rs25.next()){//for all results
            String sql89="INSERT INTO al_reserved VALUES (?,?,?,?,?,?,?)";//inserting in other table
            PreparedStatement ps89=sql_connection.conneect_DB1().prepareStatement(sql89);
            ps89.setString(1, tnt);//table number
            ps89.setString(2, rno);//reservation number
            ps89.setString(3, rs25.getString("username"));//username
            ps89.setString(4, rs25.getString("date"));//date
            ps89.setString(5, rs25.getString("time"));//time
            ps89.setString(6, rs25.getString("people"));//no. of people
            ps89.setString(7, rs25.getString("request"));//special request
            ps89.executeUpdate();}//make the updates         
            //deleting the record from the reservations table
            sql5="DELETE FROM reservations WHERE res_number=?";
            ps12=sql_connection.conneect_DB1().prepareStatement(sql5);
            ps12.setString(1, rno);
            ps12.executeUpdate();
            pen_res.setModel(dtm2);
            int trow=dtm2.getRowCount();//deleting rows from pending reservations
            for(int j=trow-1;j>=0;j--){
                dtm2.removeRow(j);}  
            //refreshing pending reservation
            sqlr2="select * from reservations";
            ps11=sql_connection.conneect_DB1().prepareStatement(sqlr2);            
            rs11=ps11.executeQuery();//getting results
            while (rs11.next()){                
                dtm2.addRow(new Object[] { rs11.getString("res_number"),
  rs11.getString("username"), rs11.getString("date"), rs11.getString("time"),
  rs11.getString("people"),rs11.getString("request")});//adding new rows to table
            }
            //refreshing already reserved
            
           sqlr2="select * from al_reserved where tab_number= ?";
            ps11=sql_connection.conneect_DB1().prepareStatement(sqlr2); 
            ps11.setString(1, jLabel46.getText());
            rs50=ps11.executeQuery();//getting results
            al_res.setModel(dtm3);//linking table to table-model
            al_res.setAutoscrolls(true);
             
        dtm3.addColumn("Reservation Number");
            dtm3.addColumn("Username");
            dtm3.addColumn("Date");
            dtm3.addColumn("Time");
            dtm3.addColumn("No. of People");
            dtm3.addColumn("Special Requests");
            al_res.setDefaultEditor(Object.class, null);
            while (rs50.next()){                
                dtm3.addRow(new Object[] { rs50.getString("res_number"),
  rs50.getString("username"), rs50.getString("date"), rs50.getString("time"),
  rs50.getString("people"),rs50.getString("request")});//adding new rows to table
            }
            
            
            } catch (SQLException ex) {
            Logger.getLogger(man_tables.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
          man_tableMain("2");
        al_res.setModel(dtm2);
           int trow=dtm2.getRowCount();//deleting rows from pending reservations
            for(int j=trow-1;j>=0;j--){
                dtm2.removeRow(j);}
            al_res();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
         man_tableMain("3");
         al_res.setModel(dtm2);
           int trow=dtm2.getRowCount();//deleting rows from pending reservations
            for(int j=trow-1;j>=0;j--){
                dtm2.removeRow(j);}
            al_res();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
          man_tableMain("4");
          al_res.setModel(dtm2);
           int trow=dtm2.getRowCount();//deleting rows from pending reservations
            for(int j=trow-1;j>=0;j--){
                dtm2.removeRow(j);}
            al_res();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
          man_tableMain("5");
          al_res.setModel(dtm2);
           int trow=dtm2.getRowCount();//deleting rows from pending reservations
            for(int j=trow-1;j>=0;j--){
                dtm2.removeRow(j);}
            al_res();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
          man_tableMain("6");
          al_res.setModel(dtm2);
           int trow=dtm2.getRowCount();//deleting rows from pending reservations
            for(int j=trow-1;j>=0;j--){
                dtm2.removeRow(j);}
            al_res();
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
         man_tableMain("7");
         al_res.setModel(dtm2);
           int trow=dtm2.getRowCount();//deleting rows from pending reservations
            for(int j=trow-1;j>=0;j--){
                dtm2.removeRow(j);}
            al_res();
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
          man_tableMain("8");
          al_res.setModel(dtm2);
           int trow=dtm2.getRowCount();//deleting rows from pending reservations
            for(int j=trow-1;j>=0;j--){
                dtm2.removeRow(j);}
            al_res();
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
          man_tableMain("9");
          al_res.setModel(dtm2);
           int trow=dtm2.getRowCount();//deleting rows from pending reservations
            for(int j=trow-1;j>=0;j--){
                dtm2.removeRow(j);}
            al_res();
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
          man_tableMain("10");
          al_res.setModel(dtm2);
           int trow=dtm2.getRowCount();//deleting rows from pending reservations
            for(int j=trow-1;j>=0;j--){
                dtm2.removeRow(j);}
            al_res();
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        // TODO add your handling code here:
          man_tableMain("11");
          al_res.setModel(dtm2);
           int trow=dtm2.getRowCount();//deleting rows from pending reservations
            for(int j=trow-1;j>=0;j--){
                dtm2.removeRow(j);}
            al_res();
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        // TODO add your handling code here:
         man_tableMain("12");
         al_res.setModel(dtm2);
           int trow=dtm2.getRowCount();//deleting rows from pending reservations
            for(int j=trow-1;j>=0;j--){
                dtm2.removeRow(j);}
            al_res();
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        try {
            //update table status
            tnt=jLabel46.getText();//getting table number
            String sql67="update tables set status=? where tab_number =?";//sql
            PreparedStatement psty=sql_connection.conneect_DB1().prepareStatement(sql67);
            psty.setString(1, "cleaning");//setting parameters for prepared statement
            psty.setString(2, tnt);
            int i=psty.executeUpdate();
            if(i==1)//checking if update took place
                JOptionPane.showMessageDialog(null, "Table Being cleaned");
             col_tab();
             cleaning.setSelected(true);
        } catch (SQLException ex) {
            Logger.getLogger(man_tables.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        //go to home
        man_home mh=new man_home();
        mh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
        col_tab();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        // TODO add your handling code here:
        //go to home
         jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jLabel33MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {//selecting table details
            String sql = "select * from tables where tab_number=?";
            ps46 =  sql_connection.conneect_DB().prepareStatement(sql);
            ps46.setString(1, jLabel46.getText());//setting parameters
            rs46 = ps46.executeQuery();//getting set of results
            tnt=jLabel46.getText();//getting table number
            rs46.next();//going to next result
            if(rs46.getString("status").equalsIgnoreCase("vacant"))
            {//for status that is vacant               
            String sql67="update tables set status=? where tab_number =?";
            PreparedStatement psty=sql_connection.conneect_DB1().prepareStatement(sql67);
            psty.setString(1, "occupied");//setting status as occupied
            psty.setString(2, tnt);
            int i=psty.executeUpdate();
            if(i==1){//checking if update happens
                JOptionPane.showMessageDialog(null, "Table Occupied");
             col_tab();}
            occupied.setSelected(true);
            man_tableMain(jLabel46.getText());
            }
            else if(rs46.getString("status").equalsIgnoreCase("occupied"))
            {//for status is occupied
            String sql67="update tables set status=? where tab_number =?";
            PreparedStatement psty=sql_connection.conneect_DB1().prepareStatement(sql67);
            psty.setString(1, "vacant");//setting status as vacant
            psty.setString(2, tnt);
            int i=psty.executeUpdate();
            if(i==1){//checking if update took place
                JOptionPane.showMessageDialog(null, "Table vacant");
             col_tab();}
            vacant.setSelected(true);
            jLabel11.setText("");
            }
            else//for status is cleaning
                {
            String sql67="update tables set status=? where tab_number =?";
            PreparedStatement psty=sql_connection.conneect_DB1().prepareStatement(sql67);
            psty.setString(1, "vacant");//set status as vacant 
            psty.setString(2, tnt);
            int i=psty.executeUpdate();
            if(i==1){
                JOptionPane.showMessageDialog(null, "Table vacant");
             col_tab();}
            vacant.setSelected(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(man_tables.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(man_tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(man_tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(man_tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(man_tables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new man_tables().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable al_res;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg2;
    private javax.swing.JLabel bg3;
    private javax.swing.JTable bill;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton cleaning;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton18;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton occupied;
    private javax.swing.JTable pen_res;
    private javax.swing.JPanel tab_deets;
    private javax.swing.JPanel tab_reserve;
    private javax.swing.JPanel tab_screen;
    private javax.swing.JRadioButton vacant;
    // End of variables declaration//GEN-END:variables
}
