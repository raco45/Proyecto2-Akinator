
package DesicionTree;

import HashTable.HashTable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *Arbol binario de decision 
 * @author raco1
 */
public class ArbolD {
    private NodoT raiz;
    
    public ArbolD(){
        this.raiz=null;
    }
    
    /**
     * Esta funcion se encarga de verificar si el arbol esta vacio
     * @return Retorna un dato de tipo boleano
     */
    public boolean esVacio(){
        return raiz==null;
    }
    /**
     * Se encarga de vaciar el arbol
     */
    public void vaciar(){
        this.raiz=null;
    }
    /**
     * Se encarga de insertar un nodo en la raiz del arbol 
     * @param preg_resp 
     */
    public void insertarRaiz(NodoT preg_resp){
        raiz=preg_resp;
    }
    /**
     * Se encarga de buscar el nodo que contenga el valor pasado por parametro
     * @param root
     * @param valor
     * @return Retorna el nodo encontrado o null
     */
    public NodoT buscar(NodoT root, String valor){
        NodoT buscado= null;
        
        if(root!=null && esVacio()==false){
            if(root.getPreg_resp().replace(" ", "").toLowerCase().equals(valor.replace(" ", "").toLowerCase())){
                return root;
            }
            if(root.getNo()!=null){
                buscado=buscar(root.getNo(),valor.replace(" ", "").toLowerCase());
            }
            if(buscado==null){
                buscado=buscar(root.getSi(),valor.replace(" ", "").toLowerCase());
            }
            return buscado;
        }
        else{
            return null;
        }
    }
    
    /**
     * Se encarga de insertar un nodo por la izquierda
     * @param padre
     * @param valor 
     */        
    public void insertarSi(String padre, String valor){
        NodoT temp= buscar(this.raiz, padre);
        NodoT respSi=new NodoT(valor);
        temp.setSi(respSi);
        respSi.setPadre(temp);
        
    }
    /**
     * Se encarga de insertar un nodo por la derecha
     * @param padre
     * @param valor 
     */
    public void insertarNo(String padre, String valor){
        NodoT temp= buscar(this.raiz, padre);
        NodoT respNo=new NodoT(valor);
        temp.setNo(respNo);
        respNo.setPadre(temp);
    }
    /**
     * Se encarga de recorrer el arbol en preorden 
     * @param root
     * @return Devuelve un String con el recorrido completo
     */
    public String preorden(NodoT root){
        String escritura="";
        if(root!=null){
            if(root.getNo()!=null && root.getSi()!=null){
                escritura+=root.getPreg_resp()+","+root.getNo().getPreg_resp()+","+root.getSi().getPreg_resp()+"\n";
                //System.out.println(escritura);
                escritura+=preorden(root.getNo());
                escritura+=preorden(root.getSi());
            }
        }
        return escritura;
    }
    
    /**
     * Metodo que busca los animales(o nodos hoja) en el arbol
     * @param root 
     */
    public String animales(NodoT root){
        String esc="";
        if(root!=null){
            if(root.getNo()==null && root.getSi()==null){
//                System.out.println(root.getPreg_resp()+"\n");
                esc+=root.getPreg_resp().replace(" ", "")+"\n";
                
                //System.out.println(escritura);
            }
                esc+=animales(root.getNo());
                esc+=animales(root.getSi());
        }
        return esc;
    }
    /**
     * Se encarga de crear y llenar un HashTable
     * @return retorna un hash table con la informacion de los animales del arbol
     */
    public HashTable llenado(){
        String[] escri= this.animales(raiz).split("\n");
        HashTable nuevo= new HashTable(1011);
        for (int i = 0; i < escri.length; i++) {
            nuevo.add(escri[i].toLowerCase());
        }
        return nuevo;
    }
    
    
                
                

        
    /**
     * Se encarga de iniciar una ronda del juego 
     * @param root
     * @return El nodo final adivinado
     */
    public NodoT partida(NodoT root){
        String ask;
        String nuevo;
        NodoT animal = null;
        if(root.getNo()!=null && root.getSi()!=null){
            Icon icono= new ImageIcon(getClass().getResource("ingame.png"));
            ask=(String) JOptionPane.showInputDialog(null,"¿"+root.getPreg_resp()+"?", "Partida", 0, icono, null, null);

            if(ask==null){
                return null;
                
            }
            else if(ask.equals("si")){
                animal=partida(root.getSi());
            }else if(ask.equals("no")){
                animal=partida(root.getNo());
            }else{
                animal=partida(root);
            }
        }else if(root.getNo()==null&& root.getSi()==null){
            animal=root;
            Icon pen= new ImageIcon(getClass().getResource("pensando.png"));
            ask=(String) JOptionPane.showInputDialog(null,"¿Es un "+root.getPreg_resp().replace(" ", "")+"?", "Partida", 0, pen, null, null);

            if(ask==null){
                return null;
            }
            else if(ask.toLowerCase().equals("si")||ask.toLowerCase().equals("yes")){
                Icon icono= new ImageIcon(getClass().getResource("victoria.png"));
                JOptionPane.showMessageDialog(null, "¡Qué fácil, ponlo más difícil la próxima vez!", "Victoria", JOptionPane.PLAIN_MESSAGE, icono);
            }else if(ask.toLowerCase().equals("no")){
                String nuevoQ;
                String aski="";
                Icon per= new ImageIcon(getClass().getResource("perdido.png"));
                nuevo=(String) JOptionPane.showInputDialog(null,"¿Que animal era "+"?", "Partida", 0, per, null, null);
                
                if(nuevo==null){
                    return null;
                }
                Icon ano= new ImageIcon(getClass().getResource("anotando.png"));
                NodoT aux= new NodoT(nuevo);
                if(animal.getPreg_resp().endsWith("a")&&(!aux.getPreg_resp().endsWith("a"))){
                    aski=(String) JOptionPane.showInputDialog(null,"¿Que diferencia existe entre un "+aux.getPreg_resp()+ " y una "+animal.getPreg_resp()+"?", "Partida", 0, ano, null, null);
                    
                }else if(aux.getPreg_resp().endsWith("a")&&(!animal.getPreg_resp().endsWith("a"))){
                    aski=(String) JOptionPane.showInputDialog(null,"¿Que diferencia existe entre una "+aux.getPreg_resp()+ " y un "+animal.getPreg_resp()+"?", "Partida", 0, ano, null, null);
                    
                }else if(aux.getPreg_resp().endsWith("a")&&(animal.getPreg_resp().endsWith("a"))){
                    aski=(String) JOptionPane.showInputDialog(null,"¿Que diferencia existe entre una "+aux.getPreg_resp()+ " y una "+animal.getPreg_resp()+"?", "Partida", 0, ano, null, null);
                    
                }else if(!aux.getPreg_resp().endsWith("a")&&(!animal.getPreg_resp().endsWith("a"))){
                    aski=(String) JOptionPane.showInputDialog(null,"¿Que diferencia existe entre un "+aux.getPreg_resp()+ " y un "+animal.getPreg_resp()+"?", "Partida", 0, ano, null, null);
                    
                }
                
                if(aski==null){
                    return null;
                }
                
                String ani=animal.getPreg_resp();
                String cambio=aski;
                while(true){
                    nuevoQ=(String) JOptionPane.showInputDialog(null,"Si el animal fuera un "+aux.getPreg_resp()+", ¿cual seria la respuesta?", "Partida", 0, ano, null, null);
                    if(nuevoQ==null){
                        return null;
                    }
                    else if(nuevoQ.toLowerCase().equals("si")||nuevoQ.toLowerCase().equals("yes")){

                        animal.setPreg_resp(cambio);
                        this.insertarNo(animal.getPreg_resp(), ani);
                        this.insertarSi(animal.getPreg_resp(), nuevo);
                        break;
                    }else if(nuevoQ.toLowerCase().equals("no")){
                        animal.setPreg_resp(cambio);
                        this.insertarSi(animal.getPreg_resp(), ani);
                        this.insertarNo(animal.getPreg_resp(), nuevo);
                        break;
                    }else if(!(nuevoQ.toLowerCase().equals("si")||nuevoQ.toLowerCase().equals("yes"))&&!(nuevoQ.toLowerCase().equals("no"))){
                        JOptionPane.showMessageDialog(null,"Por favor ingrese, si/yes o no");
                    }
                    
                }
                Icon icono= new ImageIcon(getClass().getResource("victoria.png"));
                JOptionPane.showMessageDialog(null, "¡Muchas gracias!, ahora soy mucho más inteligente que antes.", "Fin", JOptionPane.PLAIN_MESSAGE, icono);
            }else{
                animal=partida(root);
            }
        }
        return animal;
    }
    
    /**
     * @return the raiz
     */
    public NodoT getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(NodoT raiz) {
        this.raiz = raiz;
    }
    
                
            
        
                    
                    
                    
                
                    
                    
                    
                    
    
    
    

}
