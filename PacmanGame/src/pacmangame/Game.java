package pacmangame;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;
public class Game extends JFrame implements   KeyListener
{
  //  private JFrame vent;
   JLabel lblf,lblxy,lbl, lblobs, lblf2;
   JLabel lblObs1, lado3, lado4, lado5, lado6, lado7, lado8, lado9, lado10;
     int x=79,y=130,l;
     int x1=0,y1=0;

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
        lblobs.setBounds(600,500,60,130); // Diferencia de 120 // 700
        lblObs1=new JLabel(new ImageIcon(getClass().getResource("pared.jpg")));// PARED DERECHA SUPERIOR
        lblObs1.setBounds(600,0,60,130);
        lado3=new JLabel(new ImageIcon(getClass().getResource("pared.jpg")));// PARED DERECHA CENTRO
        lado3.setBounds(600,250,60,130);
        lado4=new JLabel(new ImageIcon(getClass().getResource("pared.jpg")));// PARED IZQUIERDA SUPERIOR
        lado4.setBounds(0,0,60,130);
        lado5=new JLabel(new ImageIcon(getClass().getResource("pared.jpg")));// PARED IZQUIERDA INFERIOR
        lado5.setBounds(0,500,60,130);
        lado6=new JLabel(new ImageIcon(getClass().getResource("pared.jpg")));// PARED IZQUIERDA CENTRO
        lado6.setBounds(0,250,60,130);
        lado7=new JLabel(new ImageIcon(getClass().getResource("pared.jpg")));// PARED CENTRO SUPERIOR
        lado7.setBounds(400,0,100,50);
        lado8=new JLabel(new ImageIcon(getClass().getResource("pared.jpg")));// PARED CENTRO SUPERIOR
        lado8.setBounds(200,0,100,50);
        lado9=new JLabel(new ImageIcon(getClass().getResource("pared.jpg")));// PARED CENTRO INFERIOR
        lado9.setBounds(400,580,100,50);
        lado10=new JLabel(new ImageIcon(getClass().getResource("pared.jpg")));// PARED CENTRO INFERIOR
        lado10.setBounds(200,580,100,50);
        
        this.getContentPane().add(lblObs1);
        this.getContentPane().add(lblf);
        this.getContentPane().add(lblobs);
        this.getContentPane().add(lblf2);
        this.getContentPane().add(lado3);
        this.getContentPane().add(lado4);
        this.getContentPane().add(lado5);
        this.getContentPane().add(lado6);
        this.getContentPane().add(lado7);
        this.getContentPane().add(lado8);
        this.getContentPane().add(lado9);
        this.getContentPane().add(lado10);
        
        lblObs1=new JLabel(new ImageIcon(getClass().getResource("Obstaculo.jpg")));
        lblObs1.setBounds(300,250,50,50);
        this.getContentPane().add(lblObs1);
        lblxy=new JLabel("x="+x+" y="+y);
        lblxy.setBounds(530,460,128,128);
        lblxy.setForeground(Color.WHITE);
        this.getContentPane().add(lblxy);
        
        lbl=new JLabel(new ImageIcon(getClass().getResource("Pac_1.jpg")));
        lbl.setBounds(0,0,700, 700);
        this.getContentPane().add(lbl);
        tfan.start();
        addKeyListener(this);
        this.setVisible(true);
    }
     Timer tfan=new Timer(1,new ActionListener()
     {
       @Override
       public void actionPerformed(ActionEvent ae) 
       {
           lblf2.setBounds(x1, y1, 228, 228);
             x1++;
             if(x1>=700)// Lineas del Retorno en el eje y
            {
                x1=-128;
                lblf2.setBounds(x1,y1,128,128);
            }
             if(y1>=700)// Lineas del Retorno en el eje y
            {
                y1=-128;
                lblf2.setBounds(x1,y1,128,128);
            }
             if(x1>=300)
             {
             y1++;
             lblf2.setBounds(x1,y1,128,128);
             }
                 
             
           
          }
     });
    
    Timer t=new Timer(3,new ActionListener() // mientras mayor el tiempo del times mas lento ira el programa 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
             
            // Pacman
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
            if(y>=575)// Lineas del Retorno en el eje y
            {
                y=-80;
                lblf.setBounds(x,y,128,128);
            }
            else if(y<=-80)
            {
                y=575;
                lblf.setBounds(x,y,128,128);
            }
            if(x>=575)// Lineas de retorno en el eje X
            {
                x=-80;
                lblf.setBounds(x,y,128,128);
            }
            else if(x<=-80)
            {
                x=575;
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
               if(x>=508  && y >=161 && x>=508 && y<=340)
               {
               t.stop();
               }
               if((x>=310&&y<=11)&& (x<=460)  )
               {
                    t.stop();
               }
               if((x>=113&&y<12)&& (x<=255)) 
               {
                   t.stop();
               }
               if(x<=20&& y<=90  )
               {
                   t.stop();
               }
               if((x<=20 && y>=160)&& y<=345)
               {
                   t.stop();
               }
              
                if(y>=410 && x<=20)
                {
                    t.stop();
                }
                if((x>=110 &&y>=490)&&x<=260)
                {
                    t.stop();
                }
              if ((x>=508 && y>=490) && x<=460 )
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

