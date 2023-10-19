/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import pantallas.JuegoDeTanques;
/**
 *
 * @author Liz
 */
public class Monstruo {
    
    private JLabel lblmonstruo;
    private JLabel lbltanque;
    private JuegoDeTanques padre;

    public Monstruo(JuegoDeTanques padre,JLabel lblmonstruo,
            JLabel lbltanque) {
        this.padre = padre;
        this.lblmonstruo = lblmonstruo;
        this.lbltanque = lbltanque;
    }

    public void perseguirTanque() {
        int tanqueX = lbltanque.getX();
        int tanqueY = lbltanque.getY();
        int monstruoX = lblmonstruo.getX();
        int monstruoY = lblmonstruo.getY();

     
        if (tanqueX > monstruoX) {
            lblmonstruo.setBounds(monstruoX + 5, monstruoY, 
                    lblmonstruo.getWidth(),
                    lblmonstruo.getHeight());
        } else if (tanqueX < monstruoX) {
            lblmonstruo.setBounds(monstruoX - 5, monstruoY,
                    lblmonstruo.getWidth(),
                    lblmonstruo.getHeight());
        }

        if (tanqueY > monstruoY) {
            lblmonstruo.setBounds(monstruoX, monstruoY + 5, 
                    lblmonstruo.getWidth(), 
                    lblmonstruo.getHeight());
        } else if (tanqueY < monstruoY) {
            lblmonstruo.setBounds(monstruoX, monstruoY - 5, 
                    lblmonstruo.getWidth(), 
                    lblmonstruo.getHeight());
        }
        
        if (lbltanque.getBounds().intersects(lblmonstruo.getBounds())) {
            
            padre.Perdiste();
        }
   }

    
    public JLabel getLblmonstruo() {
        return lblmonstruo;
    }

    public void setLblmonstruo(JLabel lblmonstruo) {
        this.lblmonstruo = lblmonstruo;
    }

    public JLabel getLbltanque() {
        return lbltanque;
    }

    public void setLbltanque(JLabel lbltanque) {
        this.lbltanque = lbltanque;
    }

}