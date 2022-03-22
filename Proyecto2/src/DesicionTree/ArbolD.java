
package DesicionTree;

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
            if(root.getPreg_resp().toLowerCase().equals(valor.toLowerCase())){
                return root;
            }
            if(root.getNo()!=null){
                buscado=buscar(root.getNo(),valor.toLowerCase());
            }
            if(buscado==null){
                buscado=buscar(root.getSi(),valor.toLowerCase());
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
    public void preorden(NodoT root){
        if(root!=null){
            //Imprimo primero
            if(root.getNo()!=null && root.getSi()!=null){
                System.out.println(root.getPreg_resp()+" ");
                //pregunto por el hijo izquierdo
                preorden(root.getNo());
                // pregunto por el hijo derecho
                preorden(root.getSi());
            }
        }
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
