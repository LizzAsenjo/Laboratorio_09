/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.awt.event.KeyEvent;
import javax.swing.JLabel;

/**
 *
 * @author Liz
 */
public class Tanque {
    
    private JLabel lbltanque;
    private JLabel lblmunicion;
    private int x, y, width,height ;
    private boolean disparado;

    public Tanque(JLabel tanque,JLabel municion, int startX, int startY,
            int startWh, int startH ) {
        lbltanque = tanque;
        lblmunicion = municion;
        x = startX;
        y = startY;
        width = startWh;
        height = startH;
        lbltanque.setBounds(x, y, startWh, startH);
        disparado = false; 
    }

     public void moverTanque(int deltaX, int deltaY) {
        lbltanque.setBounds(lbltanque.getX() + deltaX, lbltanque.getY() 
                + deltaY, lbltanque.getWidth(),
                lbltanque.getHeight());
        if (disparado == false){
           lblmunicion.setBounds(lblmunicion.getX() + deltaX, lblmunicion.getY()
                + deltaY, lblmunicion.getWidth(), 
                lblmunicion.getHeight());
        }
  
    }    

    public JLabel getLbltanque() {
        return lbltanque;
    }

    public void setLbltanque(JLabel lbltanque) {
        this.lbltanque = lbltanque;
    }

    public JLabel getLblmunicion() {
        return lblmunicion;
    }

    public void setLblmunicion(JLabel lblmunicion) {
        this.lblmunicion = lblmunicion;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isDisparado() {
        return disparado;
    }

    public void setDisparado(boolean disparado) {
        this.disparado = disparado;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
