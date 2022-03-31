
package Partidas;

import DesicionTree.ArbolD;
import DesicionTree.NodoT;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *Clase para buscar iniciar una partida de akinator
 * @author raco1
 */
public class Partida {
    /**
     * Nuevo juego
     * @param arbol 
     */
    public void juego(ArbolD arbol){
        boolean jugar=true;
        int cont=0;
        
        while(jugar==true){
            Icon icono= new ImageIcon(getClass().getResource("espera.png"));
            int input= JOptionPane.showConfirmDialog(null, " ¿Estás listo para jugar una ronda?", "AKINATOR", JOptionPane.YES_NO_OPTION, 0, icono);
            if(input==0){
                cont+=1;
                JOptionPane.showMessageDialog(null,"Ronda "+cont);
                NodoT node=arbol.partida(arbol.getRaiz());
                if(node==null){
                    JOptionPane.showMessageDialog(null,"Fin del juego");
                    jugar=false;
                }
            }else if(input==1){
                JOptionPane.showMessageDialog(null,"Vuelve cuando estés preparado para perder.");
                JOptionPane.showMessageDialog(null,"Recuerde presionar el boton Actualizar para acutualizar la base de conocimiento");
                jugar=false;
            }else{
                jugar=false;
            }
        }
        cont=0;
                
            
        
        
    }
    
}
