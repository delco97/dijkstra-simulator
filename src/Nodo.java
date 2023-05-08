/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.util.Iterator;

/**
 * Crea l'oggetto Nodo
 * @author Andrea Del Corto-Simone Giacomelli 5IA-07

 */
public class Nodo implements Iterable{
    public int id;
    public double peso;
    public Nodo next;

    /**
     * crea un  iteratore
     * @return ritorna un iteratore 
     */
    @Override
    public Iterator iterator() {
        return new NodoIterator(this); //To change body of generated methods, choose Tools | Templates.
    }
}
