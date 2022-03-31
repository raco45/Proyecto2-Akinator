
package Lectura;

import DesicionTree.ArbolD;
import HashTable.HashTable;

/**
 *Clase auxiliar que funciona para guardar el Hashtable y el arbol
 * @author raco1
 */
public class ArbolHash {
    
    private ArbolD arbolito;
    private HashTable table;
    
    public ArbolHash(ArbolD arbol, HashTable tabla){
        this.arbolito=arbol;
        this.table=tabla;
    }

    /**
     * @return the arbolito
     */
    public ArbolD getArbolito() {
        return arbolito;
    }

    /**
     * @return the table
     */
    public HashTable getTable() {
        return table;
    }

    /**
     * @param arbolito the arbolito to set
     */
    public void setArbolito(ArbolD arbolito) {
        this.arbolito = arbolito;
    }

    /**
     * @param table the table to set
     */
    public void setTable(HashTable table) {
        this.table = table;
    }
    
    
    
    
}
