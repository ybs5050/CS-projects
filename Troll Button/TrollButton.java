
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin
 */
public class TrollButton extends javax.swing.JFrame {

    /**
     * Creates new form TrollButton
     */
     int count;
    public TrollButton() {
        initComponents();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Troll Mouse by Youngmin Son");
        setFocusable(false);
        setFocusableWindowState(false);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jButton1.setText("CLICK ME!");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jButton1)
                .addContainerGap(212, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(251, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(226, 226, 226))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           JOptionPane.showMessageDialog(null, "Congrats You Clicked the Button!" + "It Took You" + " " + count + " clicks!");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
           MoveButton();         //  When mouse enters the area of the button, the button moves 
    }//GEN-LAST:event_jButton1MouseEntered

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
            JOptionPane.showMessageDialog(null, "YOU SUCK! YOU ONLY TRIED " + count + " clicks!");       // when user closes the program shows message
    }//GEN-LAST:event_formWindowClosing

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
             count++;        // add mouse click counter
             MoveButton();
         //    jLabel1.setText(Integer.toString(count)); <- causes bug 
    }//GEN-LAST:event_formMousePressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
              jButton1.disable();        //  CHEAT PREVENT
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrollButton().setVisible(true);
            }
        });
    }
      public static void MoveButton ()
    {
     
        
        int x = (int) (Math.random()*470 ); // random x axis coordinate
        int y = (int) (Math.random()*470 );// random y  axis coordinate
        
        if( x != MouseInfo.getPointerInfo().getLocation().x && y != MouseInfo.getPointerInfo().getLocation().y) // if x and y coordinate is not same as the coordinates of jButton1; 
        {
            jButton1.setLocation(x,y); // moves to random location
        }
        if( x == MouseInfo.getPointerInfo().getLocation().x && y == MouseInfo.getPointerInfo().getLocation().y) // if it is same
        {
            jButton1.setLocation(x - (int) (Math.random()*100+1),y-(int) (Math.random()*100+1)); // moves to random location that is less than 100 pixels away 
        }
       
     
        
    }
  
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}