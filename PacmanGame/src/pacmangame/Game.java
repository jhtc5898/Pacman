package pacmangame;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;
public class Game extends JFrame implements   KeyListener
{
  //  private JFrame vent;
   JLabel lblf,lblxy,lbl, lblobs, lblf2;
   JLabel lblObs1;
     int x=0,y=0,l;

    public Game() 
    {
        this.setBackground(Color.BLACK);
        
        this.setBounds(0, 0, 650, 650);
        this.setLocation(120, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.IniciaComponentes();
        
    }
   
    public void IniciaComponentes() 
    { 
        
        lblf=new JLabel(new ImageIcon(getClass().getResource("pacman.gif")));
        lblf.setBounds(300,250,128,128);
        
        lblf2=new JLabel(new ImageIcon(getClass().getResource("fantasma_nuevo.gif")));
        lblf2.setBounds(400,350,228,228);
        
        lblobs=new JLabel(new ImageIcon(getClass().getResource("Pared.jpg")));//PARED DERECHA INFERIOR
        lblobs.setBounds(600,500,90,150); // Diferencia de 120 // 700
        lblObs1=new JLabel(new ImageIcon(getClass().getResource("pared.jpg")));// PARED DERECHA SUPERIOR
        lblObs1.setBounds(600,0,90,150);
        
        this.getContentPane().add(lblObs1);
        this.getContentPane().add(lblf);
        this.getContentPane().add(lblobs);
        this.getContentPane().add(lblf2);
        
        lblObs1=new JLabel(new ImageIcon(getClass().getResource("Obstaculo.jpg")));
        lblObs1.setBounds(300,250,50,50);
        this.getContentPane().add(lblObs1);
        lblxy=new JLabel("x="+x+" y="+y);
        lblxy.setBounds(530,460,128,128);
        lblxy.setForeground(Color.WHITE);
        this.getContentPane().add(lblxy);
        
        lbl=new JLabel(new ImageIcon(getClass().getResource("cuadro.jpg")));
        lbl.setBounds(0,0,700, 700);
        this.getContentPane().add(lbl);
        addKeyListener(this);
        this.setVisible(true);
    }
    Timer t=new Timer(1,new ActionListener() // mientras mayor el tiempo del times mas lento ira el programa 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(l==0)
            {
                y-=1;
                lblf.setBounds(x,y,128,128);
                lblf.setIcon(new ImageIcon(getClass().getResource("pacmanArriba.gif")));
               
            }
            else if(l==1)
            {
                y+=1;
                lblf.setBounds(x,y,128,128);
                lblf.setIcon(new ImageIcon(getClass().getResource("pacmanAbajo.gif")));
            }
            else if(l==2)
            {
                x+=1;
                lblf.setBounds(x,y,128,128);
                lblf.setIcon(new ImageIcon(getClass().getResource("pacman.gif")));
            }
            else
            {
                x-=1;
                lblf.setBounds(x,y,128,128);
                lblf.setIcon(new ImageIcon(getClass().getResource("pacmanIzquierda.gif")));
            }
            if(y>=700)// Lineas del Retorno en el eje y
            {
                y=-128;
                lblf.setBounds(x,y,128,128);
            }
            else if(y<=-128)
            {
                y=700;
                lblf.setBounds(x,y,128,128);
            }
            if(x>=700)// Lineas de retorno en el eje X
            {
                x=-128;
                lblf.setBounds(x,y,128,128);
            }
            else if(x<=-128)
            {
                x=700;
                lblf.setBounds(x,y,128,128);
            }
            lblxy.setText("x="+x+" y="+y);
               if(x ==340 && y == 190)
   {
       t.stop();
       
   }
               if((x>=210 && y >= 160) &&( x<=310 && y<=260) )
               {
                   t.stop();
               }
             
               
              if(x>=508 && y>=415 )
               {
               t.stop();
               }
               if(x>=508  && y <=90)
               {
               t.stop();
               }
               
                       
        }

    });
   
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.err.println(e.getKeyCode());
        if(e.getKeyCode()==38)
        {
         l=0;
            t.start();  
             System.err.println("Arriba");
        }
         if(e.getKeyCode()==40)
        {
         l=1;
            t.start(); 
            System.err.println("Abajo");
        }
          if(e.getKeyCode()==37)
        {
             l=3;
            t.start();
        }
           if(e.getKeyCode()==39)
        {
           l=2;
            t.start(); 
        }
           if(e.getKeyCode()==32)
        {
            t.stop();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        }
    
    protected void paintComponent(Graphics grphcs) {
        //super.paintComponent(grphcs);
        grphcs.fillOval(0, 0, 50, 50);
        grphcs.setColor(Color.GREEN);
        grphcs.fillOval(0, 0, 50, 50);
    }



   


}

