
package DesicionTree;

/**
 *
 * @author raco1
 */
public class NodoT {
    
    private String preg_resp;
    private NodoT padre;
    private NodoT si;
    private NodoT no; 
   
    public NodoT(String pr){
        this.preg_resp=pr;
        this.si=null;
        this.no=null;
    }

    /**
     * @return the no
     */
    public NodoT getNo() {
        return no;
    }

    /**
     * @return the preg_resp
     */
    public String getPreg_resp() {
        return preg_resp;
    }

    /**
     * @return the si
     */
    public NodoT getSi() {
        return si;
    }

    /**
     * @param no the no to set
     */
    public void setNo(NodoT no) {
        this.no = no;
    }

    /**
     * @param preg_resp the preg_resp to set
     */
    public void setPreg_resp(String preg_resp) {
        this.preg_resp = preg_resp;
    }

    /**
     * @param si the si to set
     */
    public void setSi(NodoT si) {
        this.si = si;
    }

    /**
     * @return the padre
     */
    public NodoT getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(NodoT padre) {
        this.padre = padre;
    }

    
}
