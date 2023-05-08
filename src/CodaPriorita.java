/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Classe che crea una coda con priorità
 * @author Andrea Del Corto-Simone Giacomelli 5IA-07
 */
public class CodaPriorita {
    protected NodoConc fronte,ultimo;
    
    /**
     * crea un CodaPriorita vuota
     */
    public CodaPriorita(){
      fronte=null;
    }
    
    /**
     * controlla se la CodaPriorita è vuota
     * @return ritorna true se è vuota, false se c'è un elemento
     */
    public boolean isEmpty(){return fronte==null;}
    
    /**
     * rimuove un elemento dalla coda
     */
    public void dequeue(){
      assert !isEmpty() : "dequeue su coda vuota";
      fronte=fronte.next;
    }
    
    /**
     * aggiunge un elemento di tipo Object alla CodaPriorita
     * @param x oggetto generico da aggiungere
     */
    public void enqueue(Object x){
        NodoConc n = new NodoConc(x,null);
        if(isEmpty())
          ultimo=fronte=n;
        else{
          ultimo.next=n;
          ultimo=n;
        }
    }
    /**
     * ritorna l'informazione del primo elemento
     * @return ritorna un Object contenente l'informazione
     */
    public Object front(){
      return fronte.info;
    }
    
    /**
     * Elimina l'elemento con valore maggiore
     * @return ritorna un elemento di tipo Comparable
     */
    public Comparable removeMaxElement(){
      assert !isEmpty() : "removeMaxElement su coda vuota";
      Comparable max = (Comparable)fronte.info;
      NodoConc nodoPrecMax = null;
      NodoConc hprec= fronte;
      NodoConc h = fronte.next;
      while(h!=null){
        Comparable x = (Comparable)fronte.info;
        if(x.compareTo(max)>0){
          max=x;
          nodoPrecMax=hprec;
        }
        hprec=h;
        h=h.next;
      }
      if(nodoPrecMax==null)dequeue();
      else nodoPrecMax.next=nodoPrecMax.next.next;
      return max;
    }
}
