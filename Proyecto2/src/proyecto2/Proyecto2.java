
package proyecto2;

import DesicionTree.ArbolD;
import Lectura.ArchivoTxt;
import javax.swing.JFileChooser;
import mostrar.treeGUI;

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
//        arbolito.preorden2(arbolito.getRaiz(),0,"");
        treeGUI gui = new treeGUI(arbolito);
        arbolito.partida(arbolito.getRaiz());
        
//        arbolito.preorden2(arbolito.getRaiz(),0,"");
        
    }
    
}
