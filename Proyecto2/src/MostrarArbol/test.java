/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MostrarArbol;


import DesicionTree.ArbolD;
import DesicionTree.NodoT;
import javax.swing.JFrame;

/**
 *
 * @author AROMERO
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArbolD arbol = new ArbolD();
        Mostrar obj = new Mostrar();
        Controlador control = new Controlador(obj, arbol);
        
        NodoT raiz = new NodoT("Hola");
        arbol.insertarRaiz(raiz);
        
        arbol.insertarSi("Hola", "K ace");
        arbol.insertarNo("Hola", "Naa");
        arbol.insertarNo("Naa", "bla");
        arbol.insertarSi("Naa", "ja");
        control.iniciar();
        
        JFrame vent = new JFrame();
        vent.getContentPane().add(obj);
        vent.setDefaultCloseOperation(3);
        vent.setSize(600, 600);
        vent.setVisible(true);
    }
    
}
