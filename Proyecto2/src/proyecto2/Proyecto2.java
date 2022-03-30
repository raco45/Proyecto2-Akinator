
package proyecto2;

import DesicionTree.ArbolD;
import DesicionTree.NodoT;
import Lectura.ArchivoTxt;
import MostrarArbol.Controlador;
import MostrarArbol.Mostrar;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


/**
 *
 * @author raco1
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFileChooser archivo= new JFileChooser();
        archivo.showOpenDialog(archivo);
        String path=archivo.getSelectedFile().getAbsolutePath();
        ArchivoTxt prueba= new ArchivoTxt();
        
        ArbolD arbolito= prueba.leerTxt(path);
        
         Mostrar obj = new Mostrar();
        Controlador control = new Controlador(obj, arbolito);
        
        
        
        
        control.iniciar();
        
        JFrame vent = new JFrame();
        vent.getContentPane().add(obj);
        vent.setDefaultCloseOperation(3);
        vent.setSize(600, 600);
        vent.setVisible(true);
        
//        prueba.escribirTxt(path, arbolito);
//        arbolito.partida(arbolito.getRaiz());
//        prueba.escribirTxt(path, arbolito);
//        
//        
//        arbolito.preorden2(arbolito.getRaiz(),0,"");
//        
    }
    
}
