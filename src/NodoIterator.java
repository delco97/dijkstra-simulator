/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;

/**
 * Classe che crea un iteratore per i grafi e che implementa la classe Iterator
 * @author Andrea Del Corto-Simone Giacomelli 5IA-07
 */
public class NodoIterator implements Iterator{
    private Nodo cursore,primo;
    
    /**
     * Crea un oggetto NodoIterator
     * @param n oggetto di tipo Nodo
     */
    public NodoIterator(Nodo n){
      cursore = n;
      primo = n;
    }

    /**
     * controlla se il nodo ha un successore
     * @return ritorn true se il nodo ha un successore e false se non ce l'ha
     */
    @Override
    public boolean hasNext() {
        return cursore != null;     
    }

    /**
     * memorizza il nodo corrente e va avanti 
     * @return ritorna un oggetto generico di tipo Object
     */
    @Override
    public Object next() {
        Nodo aux = cursore;     
        cursore = cursore.next; 
        return aux;
    }
    /**
     * ritorna l'ID del nodo
     * @return ritorna un intero che rappresenta l'ID del nodo
     */
    public int getIdNodo(){return cursore.id;}
    /**
     * ritorna il peso dell'arco
     * @return ritorna un double che rappresenta il peso dell'arco
     */
    public double getPeso(){return cursore.peso;}

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
