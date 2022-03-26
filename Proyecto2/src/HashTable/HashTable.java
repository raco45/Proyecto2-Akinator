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
public class HashTable {

    Nodo table[];
    int sizeTable;

    public HashTable(int size) {
        this.sizeTable = size;
        this.table = new Nodo[sizeTable];
        for (int i = 0; i < sizeTable; i++) {
            this.table[i] = null;
        }
    }

    public int hashing(String key) {
        int value = 0;
        int position = 1;
        for (int i = 0; i < key.length(); i++) {
            if (key.codePointAt(i) == 32) {
                value += 0;
            } else if (key.codePointAt(i) >= 48 && key.codePointAt(i) <= 57) {
                value += ((key.codePointAt(i) - 47) * position);
            } else if (key.codePointAt(i) >= 65 && key.codePointAt(i) <= 90) {
                value += ((key.codePointAt(i) - 54) * position);
            } else if (key.codePointAt(i) >= 97 && key.codePointAt(i) <= 122) {
                value += ((key.codePointAt(i) - 60) * position);
            }
            position++;
        }
        return (value % sizeTable);
    }
    
    public void add(String name){
        int position = hashing(name);
        boolean exist = false;
        if (this.table[position] != null) {
            Nodo temp = this.table[position];
            if (temp.getName().equals(name)) {
                exist = true;
            }
            while(temp.getNext() != null){
                temp = temp.getNext();
                if (temp.getName().equals(name)) {
                    exist = true;
                }
            }
            if (!exist) {
                Nodo n = new Nodo(name);
                temp.setNext(n);
            }
        }else{
            Nodo n = new Nodo(name);
            this.table[position] = n;
        }
    }
    
    public Nodo search(String name){
        int position = hashing(name);
        Nodo temp = this.table[position];
        boolean exist = false;
        if (temp != null) {
            if (temp.getNext() == null) {
                exist = true;
            }else{
                while(temp.getNext() != null && !exist){
                    if (temp.getName().equals(name)) {
                        exist = true;
                    }else{
                        temp = temp.getNext();
                    }
                }
            }
        }
        if (exist) {
            return temp;
        }else{
            return null;
        }
    }
    
    public void empty(){
        for (int i = 0; i < sizeTable; i++) {
            this.table[i] = null;
        }
    }
    
    public void print(){
        for (int i = 0; i < sizeTable; i++) {
            if (this.table[i] != null) {
                System.out.println(this.table[i].getName());
                if (this.table[i] != null) {
                    Nodo temp = this.table[i].getNext();
                    while(temp != null){
                        System.out.println(temp.getName());
                        temp = temp.getNext();
                    }
                }
            }
        }
    }
}   
