package HashTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AROMERO
 */

    // Clase NodoHT para HashTable

public class NodoHT {
    private NodoHT next;
    private String name;
    
    //Constructor del NodoHT
    
    public NodoHT(String name){
        this.next = null;
        this.name = name;
    }
    
    //Metodos getters and setters para el NodoHT
    
    /**
     * @return the next
     */
    public NodoHT getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NodoHT next) {
        this.next = next;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
