/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pantallas;


import entidades.Monstruo;
import entidades.Municion;
import entidades.Tanque;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 *
 * @author Liz
 */
public class JuegoDeTanques extends javax.swing.JFrame {

    public Timer timer;
    private boolean disparando;
    private Tanque tanquecito;
    private Municion bala;
    private Monstruo monstruo;
    private boolean ganaste;
    
    public JuegoDeTanques() {
        initComponents();
        tanquecito = new Tanque(lbltanque,lblmunicion,
                740,680,100,60);
        bala = new Municion(this,lblmunicion,tanquecito,lblmonstruo);
        monstruo = new Monstruo(this,lblmonstruo, lbltanque);
        iniciarMonstruoPerseguirTanque(); 
    }
    
    private void iniciarMonstruoPerseguirTanque() {
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                monstruo.perseguirTanque();     
            }
        });
        this.timer.start();
    }

    public void Perdiste() {
        timer.stop();
        JOptionPane.showMessageDialog(this, 
                "¡Perdiste! El monstruo te atrapó.",
                "Juego Terminado",
                JOptionPane.ERROR_MESSAGE);
    }
        
    public void Ganaste() {
        timer.stop();
        JOptionPane.showMessageDialog(this, 
                "¡Ganaste! Mataste al monstruo.",
                "Juego Terminado",
                JOptionPane.ERROR_MESSAGE); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblmunicion = new javax.swing.JLabel();
        lblmonstruo = new javax.swing.JLabel();
        lbltanque = new javax.swing.JLabel();
        lblfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblmunicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/municion.png"))); // NOI18N
        getContentPane().add(lblmunicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 650, 30, -1));

        lblmonstruo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/monstruo.png"))); // NOI18N
        getContentPane().add(lblmonstruo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, -1, -1));

        lbltanque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tanque.png"))); // NOI18N
        getContentPane().add(lbltanque, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 680, -1, -1));

        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        lblfondo.setText("jLabel2");
        getContentPane().add(lblfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -20, 1630, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_SPACE && !disparando) {
            ganaste = bala.disparar();
            if (ganaste){
                JOptionPane.showMessageDialog(null,
                "¡Venciste al monstruo!", 
                "Juego Terminado", 
                JOptionPane.INFORMATION_MESSAGE);
            
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_UP
                || evt.getKeyCode() == KeyEvent.VK_W) {
            tanquecito.moverTanque(0, -5);
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN
                || evt.getKeyCode() == KeyEvent.VK_S) {
            tanquecito.moverTanque(0, 5);
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT
                || evt.getKeyCode() == KeyEvent.VK_D) {
            tanquecito.moverTanque(5, 0);
        } else if (evt.getKeyCode() == KeyEvent.VK_LEFT
                || evt.getKeyCode() == KeyEvent.VK_A) {
            tanquecito.moverTanque(-5, 0);
        }                                                             
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(JuegoDeTanques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoDeTanques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoDeTanques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoDeTanques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegoDeTanques().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblfondo;
    private javax.swing.JLabel lblmonstruo;
    private javax.swing.JLabel lblmunicion;
    private javax.swing.JLabel lbltanque;
    // End of variables declaration//GEN-END:variables
}
