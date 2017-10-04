/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplotanque;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Estudiante
 * Jpanel dado que voy a pintar en el Canvas
 * ActionListener: Para poder ejecutar el escenario cada ciertos milisegundos
 */
public class Tablerot extends JPanel implements ActionListener,MouseListener{
    private Timer timer ;
    private int pox = 30;
    private int poy= 30;
    private Tanque tanque;
    
    public Tablerot(){
        //Lanza un evento de tipo ActionListener cada 25 Milisegundo
        //Se hace referencia a this porque la misma clase (Tablero) procesa el evento
        this.timer = new Timer(25, this);
        //Registrar evento del Teclado
        setFocusable(true); //Debe estar en modo Focus para que puede detectar el evento
        addKeyListener(new EventosTeclado()); //Inner class que procesa los eventos del teclado
        addMouseListener (this );
        this.timer.start(); //Inicio con el escenario
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      
        Point mp= e.getPoint();
        Rectangle rect  = new Rectangle(this.pox,this.poy ,WIDTH+30, HEIGHT+30);

        if(rect.contains(mp)){
            System.out.println("Click sobre el cuadrado:");
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
        
    //Inner class Que captura los eventos del teclado
     private class EventosTeclado extends KeyAdapter {
        //Cuando se suelta una tecla
         @Override
        public void keyReleased(KeyEvent e) {
           int key = e.getKeyCode();
           if (key == KeyEvent.VK_SPACE) {
            System.out.println("VK_SPACE"); //Se  va usar posteriormente
           
             
            
           }
        }
        //Cuando se presiona una tecla
        @Override
        public void keyPressed(KeyEvent e) {
             int key = e.getKeyCode();
            if (key ==KeyEvent.VK_LEFT){
                System.out.println("VK_left");
                pox--;
            }
            if (key == KeyEvent.VK_RIGHT){
                System.out.println("VK_RIGHT");
                pox++;
            }
             if (key ==KeyEvent.VK_UP){
                System.out.println("VK_UP");
                poy-=10;
            }
              if (key ==KeyEvent.VK_DOWN){
                System.out.println("VK_DOWN");
                poy+=10;
            }
        }
    }
    
    //Metodo donde se pintan los objetos 
     @Override
    public void paintComponent(Graphics g){
       super.paintComponent(g);
      Image imgTanqye = 
              loadImage (tanque.getImagenes()[tanque.getAngulo()]);
      g.drawImage(imgTanqye, tanque.getX(), tanque.getY(), this);
      
    }

    
    //Metodo que se ejecuta cada vez que se lanza un ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
       
       
        repaint();
    }
     public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
   
}
