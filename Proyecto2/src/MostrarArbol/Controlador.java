/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MostrarArbol;

import DesicionTree.ArbolD;



/**
 *
 * @author AROMERO
 */

//Controlador del display para el arbol
public class Controlador {
    private Mostrar obj;
    private ArbolD arbol;
    
    //Constructor del Controlador
    public Controlador(Mostrar obj, ArbolD arbol){
        this.obj = obj;
        this.arbol = arbol;
    }
    //Funcion para iniciar el arbol grafico cada vez que se a;ade un elemento
    public void iniciar(){
        obj.setObjArbol(arbol);
    }
}
