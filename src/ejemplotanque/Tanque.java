/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplotanque;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author ESTUDIANTE
 */
public class Tanque {
   private int x;
   private int y;
   private int angulo;
   private String[] Imagenes;
    
    
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    public Tanque() {
       
        this.angulo = 1;
        this.Imagenes= new String [18];
        for(int i=0; i<18; i++){
        this.Imagenes[i] = i + ".png";
    }
        
    }
    
    
    public void mover (){
        
    }

    public String[] getImagenes() {
        return Imagenes;
    }

    public void setImagenes(String[] Imagenes) {
        this.Imagenes = Imagenes;
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

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }
   
    
    
   
}
