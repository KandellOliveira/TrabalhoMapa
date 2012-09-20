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
public class Mapa {
    ArrayList<Vertice> vertices;

    
    public Mapa(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }
    
 public static void main(String[] args){
     LerXml ler = new LerXml("A:/mapa.xml");
     try{
        Mapa mapa = new Mapa(ler.lerMapa());
        for (Vertice vertices : mapa.vertices) {
         System.out.println(vertices);
        }
     
     }catch(Exception e){
         e.printStackTrace();
     }
     
          
 }
  
}
