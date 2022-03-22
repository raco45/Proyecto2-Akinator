
package Lectura;

import DesicionTree.ArbolD;
import DesicionTree.NodoT;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author raco1
 */
public class ArchivoTxt {
    
    public ArbolD leerTxt(String rutaArchivo){
        File file= new File(rutaArchivo);
        
        try{
            FileReader fileReader;
            fileReader= new FileReader(file);
            BufferedReader br= new BufferedReader(fileReader);
            
            String line;
            try{
//                int readMode=0;
                String[] titulo;
                ArbolD arbolito= new ArbolD();
                
                while ((line=br.readLine())!=null){
                    if(line.split(",")[0].equals("Pregunta")){
                        titulo=line.split(",");
                    }else{
                        String[] helper=line.split(",");
                        NodoT aux;
                        NodoT si;
                        NodoT no;
                        if (arbolito.esVacio()){
                            aux= new NodoT(helper[0].replace(" ", "").toLowerCase());
                            no= new NodoT(helper[1].replace(" ", "").toLowerCase());
                            si= new NodoT(helper[2].replace(" ", "").toLowerCase());
                            aux.setNo(no);
                            aux.setSi(si);
                            arbolito.insertarRaiz(aux);
                        }else{
                            arbolito.insertarNo(helper[0].replace(" ", ""), helper[1].replace(" ", "").toLowerCase());
                            arbolito.insertarSi(helper[0].replace(" ", ""), helper[2].replace(" ", "").toLowerCase());
                        }
                    }
                    
                    
                   
                }
                br.close();
                
                JOptionPane.showMessageDialog(null,"Lectura exitosa.");
                return arbolito;
                
                                
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null,"Error de lectura, se procedera a cargar un archivo por default");
                
                return null;
            }
        }catch(FileNotFoundException ex){
            
            JOptionPane.showMessageDialog(null,"No se encontro el archivo, se procedera a cargar un archivo por default");
            return null;
            
            
        }
         
    }
    
    
}
