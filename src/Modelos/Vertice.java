package Modelos;

import java.util.ArrayList;

public class Vertice {
    
  private boolean init, fim;
  private int posicaoX, posicaoY;
  private String nome;
  private ArrayList<Aresta> arestas;
  
  public Vertice(boolean init, boolean fim, String nome,int x, int y) {
        this.init = init;
        this.fim = fim;
        this.nome = nome;
        this.posicaoX = x;
        this.posicaoY = y;
    }
  
    @Override
    public String toString() {
        return String.format("Nome:%s Inicio:%b Fim:%b X:%d Y:%d",getNome(),isInit(),isFim(),getPosicaoX(),getPosicaoY());
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
  
}
