/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.LinkedList;
import java.util.Queue;

/**
 *Classe che crea la struttura dati Grafo
 * @author Andrea Del Corto-Simone Giacomelli 5IA-07
 */
public class Grafo {
    private Nodo[] listeAdiacenze;
    private int numNodi;
    public static final byte BIANCO=0,GRIGIO=1,NERO=2;
    
    /**
     * Crea un istanza della classe Grafo
     * @param n intero che rappresenta il numero di nodi nel grafo
     */
    public Grafo(int n){
      listeAdiacenze = new Nodo[n];
      numNodi=n;
    }
    /**
     * restituisce il numero di nodi
     * @return ritorna un intero che rappresenta il numero di nodi presenti
     */
    public int getNumeroNodi(){return numNodi;}
    
    /**
     * Controlla se l'ID del nodo inserito è valido
     * @param k ID del nodo inserito
     * @return ritorna true se è valido, false se non lo è
     */
    public boolean nodoValido(int k){return (k>=0 && k<numNodi);}
    
    /**
     * Aggiunge un arco al grafo
     * @param nodoInizio nodo di partenza dell'arco
     * @param nodoFine nodo di arrivo del grafo
     * @param peso peso dell'arco
     * @return  ritorna true se è stato aggiunto, false se l'operazione non è riuscita
     */
    public boolean addArco(int nodoInizio,int nodoFine,double peso){
      if( nodoValido(nodoInizio) && nodoValido(nodoFine) ){
        Nodo x = new Nodo();
        x.id = nodoFine;
        x.peso = peso;
        x.next = listeAdiacenze[nodoInizio];
        listeAdiacenze[nodoInizio]=x;
        return true;
      }
      return false;
    }
    
    /**
     * 
     * @param nodo indica l'ID di un nodo
     * @return ritorna un iteratore 
     */
    public NodoIterator getAdiacenti(int nodo){
      return new NodoIterator(listeAdiacenze[nodo]);     
    }
    
    /**
     * Controlla se l'arco da creare esiste gia
     * @param nodoInizio nodo di partenza dell'arco
     * @param nodoFine nodo di arrivo del grafo
     * @param peso peso dell'arco
     * @return ritorna true se l'arco esiste gia e false se non esiste
     */
    public boolean esisteArco(int nodoInizio,int nodoFine,double peso){
      if(!nodoValido(nodoInizio) || !nodoValido(nodoFine))return false;
      NodoIterator cursor = getAdiacenti(nodoInizio);
      while(cursor.hasNext()){
        if(cursor.getIdNodo()==nodoFine && cursor.getPeso()==peso)
          return true;
        cursor.next();
      }
      return false;
    }
    @Override
    public String toString(){
      String result = "\nGRAFO:\n";
      for(int i=0;i<numNodi;i++){
        result += " " + i + ":<";
        Nodo nodo = listeAdiacenze[i];
        while(nodo!=null){
          result += "("+nodo.id+", "+nodo.peso+")";
          nodo=nodo.next;  
        }
        result +=">\n";
      }
      return result;
    }
}
