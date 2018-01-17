/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmangame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;



public class Controles  implements KeyListener {
    
private Game game ;
    @Override
    public void keyTyped(KeyEvent e) {
      //  System.err.println(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
         int res = e.getKeyCode();
      if (res == 38)
      {
          
      
      }
        System.err.println(res +",");
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

}