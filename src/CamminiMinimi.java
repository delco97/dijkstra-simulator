/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *Classe che esegue l'algoritmo di Dijkstra
 * @author Andrea Del Corto-Simone Giacomelli 5IA-07
 */
public class CamminiMinimi {
    class NodoConfrontabile implements Comparable{
      public int idNodo;
      public double dist;
      public NodoConfrontabile(int idNodo,double dist){
        this.idNodo = idNodo;
        this.dist = dist;
      }

        @Override
        public int compareTo(Object x) {
            double distx = ((NodoConfrontabile)(x)).dist;
            return dist > distx ? -1 : (dist < distx ? 1 : 0);
        }
      @Override
        public String toString(){
          String aux = "idNodo: "+idNodo+"  dist: "+dist;
          return aux;
          
        }
    }
    protected Grafo g;
    protected int numNodi;
    protected int[] pred;
    protected double[] dist;
    
    /**
     * inizializza un grafo
     * @param g Grafo 
     */

    public CamminiMinimi(Grafo g){
      this.g = g;
      numNodi = g.getNumeroNodi();
    }
    
    /**
     * ritorna l'ID del nodo precedente
     * @param i indice del vettore
     * @return ritorna un intero che rappresenta l'ID del nodo 
     */
    public int getPred(int i) {return pred[i];}
    
    /**
     * ritorna la distanza da un nodo al successivo
     * @param i indice del vettore
     * @return ritorna un double che rappresenta la distanza da un nodo ad un altro
     */
    public double getDist(int i) {return dist[i];}
    
    /**
     * esegue l'algoritmo di Dijkstra sul grafo
     * @param start ID del nodo di partenza
     */
     
    public void exeDijkstra(int start){
      CodaPriorita q = new CodaPriorita();
      pred = new int[numNodi];
      dist = new double[numNodi];
      NodoConfrontabile[] nodo = new NodoConfrontabile[numNodi];
      
      for(int i=0;i<numNodi;i++){
        dist[i]=Double.POSITIVE_INFINITY;
        pred[i]=-1;
      }
      dist[start]=0.0;
      for(int i=0;i<numNodi;i++){
        nodo[i]= new NodoConfrontabile(i,dist[i]);
        q.enqueue(nodo[i]);
      }
      while(!q.isEmpty()){
        int u = ((NodoConfrontabile) q.removeMaxElement()).idNodo;
        NodoIterator it = g.getAdiacenti(u);
        while(it.hasNext()){
          double w = it.getPeso();
          int v = it.getIdNodo();
          if(dist[v] > dist[u] + w){
            dist[v]=dist[u]+w;
            nodo[v].dist=dist[v];
            pred[v]=u;
          }
           it.next();
        }
      }
    }
    
    /**
     *  memorizza il cammino da un nodo ad un altro
     * @param start ID del nodo di partenza
     * @param end ID del nodo di arrivo
     * @return ritorna un ArrayList contenente il cammino da percorrere per andare dal nodo d partenza al nodo di arrivo
     */
    
    public ArrayList cammino(int start,int end){
      //int[] path=new int[1];
      ArrayList<Integer> path = new ArrayList();
      int cursor=end;
      while(cursor!=start){
        System.out.println(cursor);
        path.add(0,cursor);
        cursor=getPred(cursor);  
      }
      
      return path;
    }
    @Override
    public String toString(){
      String res="";
        for(int i=0;i<numNodi;i++){
          res += "Nodo: "+i+" pred = "+pred[i]+" dist = "+dist[i]+"\n";
        }
        return res;
    }
    
    
}
