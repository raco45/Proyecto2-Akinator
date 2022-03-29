
package Lectura;

import DesicionTree.ArbolD;
import DesicionTree.NodoT;
import HashTable.HashTable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author raco1
 */
public class ArchivoTxt {
    
    boolean cargado;
    String[] title;
    
    public ArbolHash leerTxt(String rutaArchivo){
        File file= new File(rutaArchivo);
        
        try{
            FileReader fileReader;
            fileReader= new FileReader(file);
            BufferedReader br= new BufferedReader(fileReader);
            
            String line;
            
            try{
//                int readMode=0;
                ArbolD arbolito= new ArbolD();
                
                while ((line=br.readLine())!=null){
                    if(line.split(",")[0].equals("Pregunta")){
                        String[] titulo=line.split(",");
                        this.title=titulo;
                    }else{
                        String[] helper=line.split(",");
                        NodoT aux;
                        NodoT si;
                        NodoT no;
                        if (arbolito.esVacio()){
                            aux= new NodoT(helper[0]);
                            no= new NodoT(helper[1]);
                            si= new NodoT(helper[2]);
                            aux.setNo(no);
                            aux.setSi(si);
                            arbolito.insertarRaiz(aux);
                        }else{
                            arbolito.insertarNo(helper[0], helper[1]);
                            arbolito.insertarSi(helper[0], helper[2]);
                        }
                    }
                    
                }
                
                HashTable tabla=arbolito.llenado();
                
                   
                br.close();
                ArbolHash aux= new ArbolHash(arbolito,tabla);
                
                
                JOptionPane.showMessageDialog(null,"Lectura exitosa.");
                return aux;
                
                                
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null,"Error de lectura, se procedera a cargar un archivo por default");
                
                return null;
            }
        }catch(FileNotFoundException ex){
            
            JOptionPane.showMessageDialog(null,"No se encontro el archivo, se procedera a cargar un archivo por default");
            return null;
            
            
        }
        
         
    }
    
    public void escribirTxt(String rutaArchivo,ArbolD tree){
        
        String escritura=title[0]+", "+title[1]+", "+title[2]+"\n";
        
        String raices= tree.preorden(tree.getRaiz());
        try{
            escritura=escritura+raices;
            
            PrintWriter pw = new PrintWriter(rutaArchivo);
            pw.print(escritura);
            pw.close();
            JOptionPane.showMessageDialog(null, "Guardado exitoso");
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error de lectura");
        }
    }
    
    
}
