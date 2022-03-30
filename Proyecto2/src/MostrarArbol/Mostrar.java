/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MostrarArbol;

import javax.swing.JPanel;
import DecisionTree.ArbolD;
import DecisionTree.NodoT;
import java.awt.Graphics;
/**
 *
 * @author AROMERO
 */

//Clase con la funcion para mostrar el arbol graficamente

public class Mostrar extends JPanel {
    private ArbolD arbol;
    public static final int DIAMETRO = 50;
    public static final int RADIO = DIAMETRO/2;
    public static final int ANCHO = 50;
    
    public void setObjArbol(ArbolD arbol){
        this.arbol = arbol;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        pintar(g, getWidth()/2, 20, arbol.getRaiz());
    }
    //Funcion pintar para dibujar el arbol
    private void pintar(Graphics g, int x, int y, NodoT n){
        if (n == null) {
            
        }else{
            int EXTRA = n.nodoCompleto(n) * (ANCHO/2);
            g.drawOval(x, y, DIAMETRO, DIAMETRO);
            g.drawString(n.getPreg_resp(), x +12, y+18); //12, 18
            if (n.getNo() != null) 
                g.drawLine(x + RADIO, y + RADIO, x - ANCHO - EXTRA + RADIO, y + ANCHO + RADIO);           
            if (n.getSi() != null) 
                g.drawLine(x + RADIO, y + RADIO, x + ANCHO + EXTRA + RADIO, y + ANCHO + RADIO);
            pintar(g, x - ANCHO - EXTRA, y + ANCHO, n.getNo());
            pintar(g, x + ANCHO + EXTRA, y + ANCHO, n.getSi());
        }
    }
}
