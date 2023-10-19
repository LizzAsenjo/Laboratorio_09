/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import pantallas.JuegoDeTanques;

/**
 *
 * @author Liz
 */
public class Municion {
    
    private JLabel lblmunicion;  
    private JLabel lblmonstruo;
    private Timer timer;
    private Tanque tanquecito;
    private boolean disparando;
    private boolean ganaste = false;
    private JuegoDeTanques padre;

    public Municion(JuegoDeTanques padre,JLabel lblmunicion, Tanque tanquecito,
            JLabel lblmonstruo) {
        this.padre = padre;
        this.lblmunicion = lblmunicion;
        this.tanquecito = tanquecito;
        this.lblmonstruo = lblmonstruo;
      
        disparando = false;
    }
    

    public boolean disparar() {
        if (!disparando) {
        lblmunicion.setBounds(tanquecito.getX() + tanquecito.getWidth()
                / 2 - lblmunicion.getWidth() / 2, tanquecito.getY(),
                lblmunicion.getWidth(), lblmunicion.getHeight());
        
        lblmunicion.setVisible(true);
        disparando = true;
        tanquecito.setDisparado(disparando);  
        
        Timer disparoTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblmunicion.setBounds(lblmunicion.getX(), lblmunicion.getY() 
                        - 10, lblmunicion.getWidth(), 
                        lblmunicion.getHeight());
                if (lblmunicion.getY() < 0) {
                    lblmunicion.setVisible(false);
                    disparando = false;
                    ((Timer) e.getSource()).stop();
                }
                if (lblmunicion.getBounds().intersects
                                (lblmonstruo.getBounds())) {
                    lblmonstruo.setVisible(false);
                   padre.Ganaste(); 

                    lblmunicion.setVisible(false);
                    disparando = false;
                    ((Timer) e.getSource()).stop();
                    ganaste = true;
                }
            }
       });

        disparoTimer.start();
        }
        return ganaste;
    }
}