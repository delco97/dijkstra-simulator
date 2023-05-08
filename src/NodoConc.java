/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * classe che crea un NodoConc generico
 * @author Andrea Del Corto-Simone Giacomelli 5IA-07
 * @param <T> 
 */
public class NodoConc <T>{
    T info;
    NodoConc<T> next;
    /**
     * Crea un oggetto NodoConc 
     * @param info informazione del nodo
     * @param next riferimento al nodo successivo
     */
    NodoConc(T info,NodoConc<T> next){
      this.info=info;
      this.next=next;
    }
}
