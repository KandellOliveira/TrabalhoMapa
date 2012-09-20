/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;

import java.util.ArrayList;

/**
 *
 * @author Kandell
 */
public class Vertice {

    
  private boolean init, fim;
  private int x, y;
  private String nome;
  private ArrayList<Aresta> arestas;
  
  
  
  public Vertice(boolean init, boolean fim, String nome,int x, int y) {
        this.init = init;
        this.fim = fim;
        this.nome = nome;
        this.x = x;
        this.y = y;
    }

  
    @Override
    public String toString() {
        return String.format("Nome: %s\nInicio: %b\nFim: %b\nX: %d\nY: %d\n",getNome(),isInit(),isFim(),getX(),getY());
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
