package Modelos;

public class Aresta {
   private int peso ;
   private Vertice destino;
  
    public Aresta(int peso, Vertice destino) {
        this.peso = peso;
        this.destino = destino;
    }  
    
    public Vertice getDestino(){
        return destino;
    }
    
    public int getPeso(){
        return peso;
    }
    
    @Override
    public String toString(){
        return "Peso="+peso +" Destino="+destino.getNome(); 
    }
}
