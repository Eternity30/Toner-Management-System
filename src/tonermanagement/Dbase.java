/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tonermanagement;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;


public class Dbase extends javax.swing.JFrame {

    /**
     * Creates new form Requests
     */
    public Dbase() {
        initComponents();
        Show_Users_in_Jtable();
    }
Connection con = null;
PreparedStatement pst = null;
ResultSet rs = null;

public void close(){
   WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
  Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);  
}
public ArrayList<Dbs> userList(){
       ArrayList<Dbs> usersList=new ArrayList<>();
       
       try{
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/toner","root", "tarun543");
           String query="SELECT * from rso";
           Statement st=con.createStatement();
           rs=st.executeQuery(query);
           Dbs db;
           while (rs.next())
           {
               db = new Dbs(rs.getInt("sno"),rs.getString("printer_type"),rs.getInt("employee_code"),rs.getString("employee_name"),rs.getString("designation"),rs.getString("department"),rs.getString("floor"));
               usersList.add(db);
           }
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
           //System.out.println("Eror");
       }
        return usersList;
    }
    public void Show_Users_in_Jtable(){
        ArrayList<Dbs> list = userList();
        DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
        Object [] row = new Object[7];
        
        for (int i = 0; i < list.size() ; i++){
            row[0] = list.get(i).getsno();
            row[1]=list.get(i).getp();
            row[2]=list.get(i).getc();
            row[3]=list.get(i).getn();
            row[4]=list.get(i).getdes();
            row[5]=list.get(i).getdep();
            row[6]=list.get(i).getf();
            model.addRow(row);   
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jt_dep = new javax.swing.JLabel();
        jt_des = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jt_flo = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jt1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jt3 = new javax.swing.JTextField();
        jt5 = new javax.swing.JTextField();
        jt_sno = new javax.swing.JLabel();
        jt7 = new javax.swing.JTextField();
        jt_sno_printer = new javax.swing.JLabel();
        jt6 = new javax.swing.JTextField();
        jt8 = new javax.swing.JTextField();
        jt_no = new javax.swing.JLabel();
        jt9 = new javax.swing.JTextField();
        jt_name = new javax.swing.JLabel();
        sch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.No", "Printer_Type", "Employee Number", "Employee Name", "Desigation", "Department", "Floor"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jt_dep.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jt_dep.setText("Department");

        jt_des.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jt_des.setText("Designation");

        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jt_flo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jt_flo.setText("Floor");

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt5ActionPerformed(evt);
            }
        });

        jt_sno.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jt_sno.setText("SNo.");

        jt_sno_printer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jt_sno_printer.setText("Printer");

        jt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt6ActionPerformed(evt);
            }
        });

        jt_no.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jt_no.setText("Emp Number");

        jt_name.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jt_name.setText("Emp Name");

        sch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schActionPerformed(evt);
            }
        });
        sch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                schKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setText("Employee Number");

        jMenu1.setText("Main Menu");

        jMenuItem1.setText("Home");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jt_no)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jt_sno)
                                        .addGap(1, 1, 1))
                                    .addComponent(jt_name)
                                    .addComponent(jt_des, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jt_dep))
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jt_sno_printer)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jt_flo)
                                        .addGap(34, 34, 34)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jt1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jt3)
                            .addComponent(jt5)
                            .addComponent(jt6)
                            .addComponent(jt7)
                            .addComponent(jt8)
                            .addComponent(jt9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(sch, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sch, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jt_sno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jt3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jt_sno_printer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jt5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jt_no, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jt6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jt_des, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jt7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jt8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jt_dep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jt9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jt_flo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i=jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        jt1.setText(model.getValueAt(i,0).toString());
        jt3.setText(model.getValueAt(i,1).toString());
        jt5.setText(model.getValueAt(i,2).toString());
        jt6.setText(model.getValueAt(i,3).toString());
        jt7.setText(model.getValueAt(i,4).toString());
        jt8.setText(model.getValueAt(i,5).toString());
        jt9.setText(model.getValueAt(i,6).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            String sql = "INSERT INTO rso"
            +"(sno,printer_type,employee_code,employee_name,designation,department,floor)"
            +"VALUES (?,?,?,?,?,?,?)";
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/toner","root", "namit123");
            pst = con.prepareStatement(sql);
            pst.setString(1,jt1.getText());
            pst.setString(2,jt3.getText());
            pst.setString(3,jt5.getText());
            pst.setString(4,jt6.getText());
            pst.setString(5,jt7.getText());
            pst.setString(6,jt8.getText());
            pst.setString(7,jt8.getText());
            pst.executeUpdate();
            //DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            //Show_Users_in_Jtable();
            JOptionPane.showMessageDialog(null, "inserted successfully");

        }
        catch(SQLException | ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        showTableData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            String sql = "UPDATE rso SET printer_type=?,employee_code=?,employee_name=?,designation=?,department=?,floor=? WHERE sno=?";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toner","root", "namit123");
            pst = con.prepareStatement(sql);
            pst.setString(7,jt1.getText());
            pst.setString(1,jt3.getText());
            pst.setString(2,jt5.getText());
            pst.setString(3,jt6.getText());
            pst.setString(4,jt7.getText());
            pst.setString(5,jt8.getText());
            pst.setString(6,jt9.getText());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "updated successfully");

        }
        catch(SQLException | ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        showTableData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            String sql = "DELETE FROM rso WHERE sno =?";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toner","root", "namit123");
            pst = con.prepareStatement(sql);
            pst.setString(1,jt1.getText());
            pst.executeUpdate();
            //DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            //Show_Users_in_Jtable();
            JOptionPane.showMessageDialog(null, "deleted successfully");

        }
        catch(SQLException | ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        showTableData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt5ActionPerformed

    private void jt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt6ActionPerformed

    private void schKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_schKeyReleased
        try{    
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toner","root", "namit123");
         String sql = "SELECT * FROM rso where employee_code=?";
         pst = con.prepareStatement(sql);
         pst.setString(1,sch.getText());
         rs=pst.executeQuery();
         if(rs.next())
         {
             String setid = rs.getString("sno");
                     jt1.setText(setid);
                     String setprinter = rs.getString("printer_type");
                     jt3.setText(setprinter);
                     String setempcode = rs.getString("employee_code");
                     jt5.setText(setempcode);
                     String setempname = rs.getString("employee_name");
                     jt6.setText(setempname);
                     String setdes = rs.getString("designation");
                     jt7.setText(setdes);
                     String setdep = rs.getString("department");
                     jt8.setText(setdep);
                     String setfl = rs.getString("floor");
                     jt9.setText(setfl);
         }
        }
        catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);
 
        }// TODO add your handling code here:
    }//GEN-LAST:event_schKeyReleased

    private void schActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_schActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        close();    
        MainActivity obj=new MainActivity();
            obj.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void showTableData(){
        try{    
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toner","root", "namit123");
         String sql = "SELECT * FROM rso";
         pst = con.prepareStatement(sql);
         rs=pst.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);
 
        }
    }
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
            java.util.logging.Logger.getLogger(Dbase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dbase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dbase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dbase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dbase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jt1;
    private javax.swing.JTextField jt3;
    private javax.swing.JTextField jt5;
    private javax.swing.JTextField jt6;
    private javax.swing.JTextField jt7;
    private javax.swing.JTextField jt8;
    private javax.swing.JTextField jt9;
    private javax.swing.JLabel jt_dep;
    private javax.swing.JLabel jt_des;
    private javax.swing.JLabel jt_flo;
    private javax.swing.JLabel jt_name;
    private javax.swing.JLabel jt_no;
    private javax.swing.JLabel jt_sno;
    private javax.swing.JLabel jt_sno_printer;
    private javax.swing.JTextField sch;
    // End of variables declaration//GEN-END:variables
}
