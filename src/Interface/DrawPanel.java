package Interface;

import Modelos.Aresta;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import Modelos.Vertice;
import java.util.ArrayList;
import java.util.Stack;

public class DrawPanel extends JPanel {

    private ArrayList<Vertice> vertices;
    private Stack<Vertice> menorCaminho;

    public void setMenorCaminho(Stack<Vertice> menorCaminho) {
        this.menorCaminho = menorCaminho;
    }

    public DrawPanel(ArrayList<Vertice> vertices) {
        setSize(800, 400);
        setVisible(false);
        this.vertices = vertices;
    }

    private int retornaPosicaoXdoVerticeDestino(Aresta aresta) {
        for (Vertice vertice : vertices) {
            if (vertice.getNome().equals(aresta.getDestino().getNome())) {
                return vertice.getPosicaoX();
            }
        }
        return 0;
    }

    private int retornaPosicaoYdoVerticeDestino(Aresta aresta) {
        for (Vertice vertice : vertices) {
            if (vertice.getNome().equals(aresta.getDestino().getNome())) {
                return vertice.getPosicaoY();
            }
        }
        return 0;
    }

    public void paint(Graphics g) {
        desenharMapa(g);
        desenharMenorcaminho(g);
    }

    private void desenharMapa(Graphics g) {
        int contador = 0;
        int incremento = 10;

        for (Vertice vertice : vertices) {
            g.setColor(Color.blue);
            //g.setPaintMode();
            g.drawOval(vertice.getPosicaoX() - 30, vertice.getPosicaoY() - 30, 60, 60);
            g.setColor(Color.black);
            g.drawString(vertice.getNome(), vertice.getPosicaoX() - 30, vertice.getPosicaoY() - 30);
            contador++;
            for (Aresta aresta : vertice.getArestas()) {
                g.setColor(Color.red);

                g.drawLine(vertice.getPosicaoX(),
                        vertice.getPosicaoY(),
                        retornaPosicaoXdoVerticeDestino(aresta),
                        retornaPosicaoYdoVerticeDestino(aresta));
                g.setColor(Color.BLACK);

                if ((contador % 2) == 0) {
                    incremento = 20;
                } else {
                    incremento = 0;
                }

                g.drawString(String.valueOf(aresta.getPeso()), ((vertice.getPosicaoX() + retornaPosicaoXdoVerticeDestino(aresta)) / 2) + incremento,
                        ((vertice.getPosicaoY() + retornaPosicaoYdoVerticeDestino(aresta)) / 2) + incremento);

            }
        }
    }

    private void desenharMenorcaminho(Graphics g) {
        if (this.menorCaminho != null) {
            for (Vertice vertice : this.menorCaminho) {
                g.setColor(Color.ORANGE);
                g.drawOval(vertice.getPosicaoX() - 30, vertice.getPosicaoY() - 30, 60, 60);
                if(vertice.getDestinoAnterior()!= null){
                    g.setColor(Color.yellow);
                    g.drawLine(vertice.getPosicaoX(),
                            vertice.getPosicaoY(),
                            vertice.getDestinoAnterior().getPosicaoX(),
                            vertice.getDestinoAnterior().getPosicaoY());
                }
            }
        }
    }
}
