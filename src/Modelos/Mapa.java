package Modelos;

import java.util.ArrayList;
import java.util.Stack;

public class Mapa {
    private ArrayList<Vertice> vertices;
    
    public Mapa(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }
    
    public ArrayList<Vertice> getVertices(){
        return this.vertices;
    }
    
    private Vertice retornaVerticeInicial(){
       for (Vertice vertice : vertices) {
          if(vertice.isInit()){
             return vertice;
          }          
        }
      return null;
   }
    
   private Vertice retornaVerticeFinal(){
       for (Vertice vertice : vertices) {
          if(vertice.isFim()){
             return vertice;
          }          
        }
      return null;
   }
   
   public Stack<Vertice> MostrarMenorCaminho(){
      MenorCaminho(null);
      return guardarMenorCaminho();
   }
   
   private void MenorCaminho(Vertice vertice){
       Vertice verticeAtual;
       if (vertice == null){
          verticeAtual = retornaVerticeInicial();       
       }else
           verticeAtual = vertice;
       
       for (Aresta aresta : verticeAtual.getArestas()) {
           int pesoDoCaminho = verticeAtual.getPesoAtual()+aresta.getPeso();
           if (verticeAtual.getDestinoAtual().getPesoAtual() < pesoDoCaminho){
               verticeAtual.getDestinoAtual().setPesoAtual(pesoDoCaminho);
           }
           if (!verticeAtual.isFim()){
              MenorCaminho(verticeAtual.getDestinoAtual());
           }
           else
               break;
       }
   }
   
   private Stack<Vertice> guardarMenorCaminho(){
       Vertice verticeAtual = retornaVerticeFinal();
       Stack<Vertice> pilha = null;       
       do{
           pilha.add(verticeAtual);
           verticeAtual = verticeAtual.getDestinoAtual();
       }while(verticeAtual.isInit());
       return pilha; 
   }        
}
