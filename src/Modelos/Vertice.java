package Modelos;

import java.awt.List;
import java.util.ArrayList;

public class Vertice {
    
  private boolean init, fim;
  private int posicaoX, posicaoY;
  private String nome;
  private ArrayList<Aresta> arestas;
  private int pesoAtual = Integer.MAX_VALUE;
  private Vertice destinoAnterior = null;
  
  
      
  public Vertice(boolean init, boolean fim, String nome,int x, int y) {
        this.init = init;
        this.fim = fim;
        this.nome = nome;
        this.posicaoX = x;
        this.posicaoY = y;
    }  
  
  public Vertice(String nome){
      this.nome = nome;
  }
  
    @Override
    public String toString() {
        return String.format("Nome:%s Inicio:%b Fim:%b X:%d Y:%d",getNome(),isInit(),isFim(),getPosicaoX(),getPosicaoY());
    }
    
    public boolean equals(String obj) {
        return (this.getNome()==obj);
    }

    @Override
    public boolean equals(Object obj) {
        Vertice v = (Vertice)obj;
        return getNome().equals(v.getNome());
    }       

    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }

    public boolean isFim() {
        return fim;
    }

    public void setFim(boolean fim) {
        this.fim = fim;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int x) {
        this.posicaoX = x;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int y) {
        this.posicaoY = y;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
    }
    
    public int getPesoAtual() {
        if (this.isInit()){
            return 0;
        }
        else{
            return pesoAtual;
        }
        
    }

    public void setPesoAtual(int pesoAtual) {
        this.pesoAtual = pesoAtual;
    }

    public Vertice getDestinoAnterior() {
        return destinoAnterior;
    }

    public void setDestinoAnterior(Vertice destinoAtual) {
        this.destinoAnterior = destinoAtual;
    } 
}
