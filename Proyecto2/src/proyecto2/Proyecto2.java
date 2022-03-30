
package proyecto2;

import DesicionTree.ArbolD;
import HashTable.HashTable;
import Lectura.ArbolHash;
import Lectura.ArchivoTxt;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
//        JFileChooser archivo= new JFileChooser();
//        archivo.showOpenDialog(archivo);
//        String path=archivo.getSelectedFile().getAbsolutePath();
//        System.out.println(path);
        ArchivoTxt prueba= new ArchivoTxt();
        ArbolHash nuevo=prueba.leerTxt("C:\\Users\\raco1\\Desktop\\archivo.csv");
        ArbolD arbolito= nuevo.getArbolito();
        HashTable tabla=nuevo.getTable();
        
        System.out.println(arbolito.partida(arbolito.getRaiz()));
        
        
        
//        tabla.print();
//        System.out.println(tabla.search("Perro").getName());
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
