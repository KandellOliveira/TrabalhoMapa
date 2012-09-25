package Modelos;

public class Aresta {
  private int peso ;
  private String destino;

    public Aresta(int peso, String destino) {
        this.peso = peso;
        this.destino = destino;
    }  
    
    public String getDestino(){
        return destino;
    }
    
    public String getPeso(){
        return String.valueOf(this.peso);
    }
    
    @Override
    public String toString(){
        return "Peso="+peso +" Destino="+destino; 
    }
}
