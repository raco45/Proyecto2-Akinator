
package DesicionTree;

import HashTable.HashTable;
import javax.swing.JOptionPane;

/**
 *
 * @author raco1
 */
public class ArbolD {
    private NodoT raiz;
    
    public ArbolD(){
        this.raiz=null;
    }
    
    
    public boolean esVacio(){
        return raiz==null;
    }
    
    public void vaciar(){
        this.raiz=null;
    }
    
    public void insertarRaiz(NodoT preg_resp){
        raiz=preg_resp;
    }
    
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
            
    public void insertarSi(String padre, String valor){
        NodoT temp= buscar(this.raiz, padre);
        NodoT respSi=new NodoT(valor);
        temp.setSi(respSi);
        respSi.setPadre(temp);
        
    }
    public void insertarNo(String padre, String valor){
        NodoT temp= buscar(this.raiz, padre);
        NodoT respNo=new NodoT(valor);
        temp.setNo(respNo);
        respNo.setPadre(temp);
    }
    public String preorden(NodoT root){
        String escritura="";
        if(root!=null){
            if(root.getNo()!=null && root.getSi()!=null){
                escritura+=root.getPreg_resp()+", "+root.getNo().getPreg_resp()+", "+root.getSi().getPreg_resp()+"\n";
                //System.out.println(escritura);
                escritura+=preorden(root.getNo());
                escritura+=preorden(root.getSi());
            }
        }
        return escritura;
    }
    
    /**
     * Metodo que busca los animales en el arbol
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
    public HashTable llenado(){
        String[] escri= this.animales(raiz).split("\n");
        HashTable nuevo= new HashTable(escri.length);
        for (int i = 0; i < escri.length; i++) {
            nuevo.add(escri[i]);
        }
        return nuevo;
    }
    
    
                
                

        
    
    public NodoT partida(NodoT root){
        String ask;
        String nuevo;
        NodoT animal = null;
        if(root.getNo()!=null && root.getSi()!=null){
            ask= JOptionPane.showInputDialog("¿"+root.getPreg_resp()+"?");
            if(ask.equals("si")){
                animal=partida(root.getSi());
            }else if(ask.equals("no")){
                animal=partida(root.getNo());
            }
        }else if(root.getNo()==null&& root.getSi()==null){
            animal=root;
            ask= JOptionPane.showInputDialog("¿Es un "+root.getPreg_resp()+"?");
            if(ask.equals("si")){
                JOptionPane.showMessageDialog(null,  "¡Qué fácil, ponlo más difícil la próxima vez!");
            }else if(ask.equals("no")){
                String nuevoQ;
                nuevo=JOptionPane.showInputDialog("¿Que animal era "+"?");
                NodoT aux= new NodoT(nuevo);
                if(animal.getPreg_resp().endsWith("a")&&(!aux.getPreg_resp().endsWith("a"))){
                    ask=JOptionPane.showInputDialog("¿Que diferencia existe entre un "+aux.getPreg_resp()+ "y una "+animal.getPreg_resp()+"?" );
                }else if(aux.getPreg_resp().endsWith("a")&&(!animal.getPreg_resp().endsWith("a"))){
                    ask=JOptionPane.showInputDialog("¿Que diferencia existe entre una "+aux.getPreg_resp()+ "y un "+animal.getPreg_resp()+"?" );
                }else if(aux.getPreg_resp().endsWith("a")&&(animal.getPreg_resp().endsWith("a"))){
                    ask=JOptionPane.showInputDialog("¿Que diferencia existe entre una "+aux.getPreg_resp()+ "y una "+animal.getPreg_resp()+"?" );
                }else if(!aux.getPreg_resp().endsWith("a")&&(!animal.getPreg_resp().endsWith("a"))){
                    ask=JOptionPane.showInputDialog("¿Que diferencia existe entre un "+aux.getPreg_resp()+ "y un "+animal.getPreg_resp()+"?" );
                }
                nuevoQ=JOptionPane.showInputDialog("Si el animal fuera un "+aux.getPreg_resp()+", ¿cual seria la respuesta?" );
                String ani=animal.getPreg_resp();
                String cambio=ask;
                if(nuevoQ.equals("si")){
                    animal.setPreg_resp(cambio);
                    this.insertarNo(animal.getPreg_resp(), ani);
                    this.insertarSi(animal.getPreg_resp(), nuevo);
                }
            }
        }
        return animal;
    }
    public NodoT Max(NodoT n) {
            if (n.getSi() == null) {
                return n;
            } else {
                return Max(n.getSi());
        }
    }
    public int getheight(NodoT root) {
		if (root == null)
			return 0;
		return Math.max(getheight(root.getNo()), getheight(root.getSi())) + 1;
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
