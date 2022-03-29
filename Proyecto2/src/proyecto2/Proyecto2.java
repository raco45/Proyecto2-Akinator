
package proyecto2;

import DesicionTree.ArbolD;
import HashTable.HashTable;
import Lectura.ArbolHash;
import Lectura.ArchivoTxt;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


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
        ArbolHash nuevo=prueba.leerTxt(path);
        ArbolD arbolito= nuevo.getArbolito();
        HashTable tabla=nuevo.getTable();
        String xd= JOptionPane.showInputDialog("Prueba");
        System.out.println(xd);
        
//        tabla.print();
//        System.out.println(tabla.search("Perro").getName());
//        arbolito.partida(arbolito.getRaiz());
//        System.out.println(arbolito.preorden(arbolito.getRaiz()));

////        prueba.escribirTxt(path, arbolito);
//        prueba.escribirTxt(path, arbolito);
//        arbolito.animales(arbolito.getRaiz());
//        
//        
//        arbolito.preorden2(arbolito.getRaiz(),0,"");
//        
    }
    
}
