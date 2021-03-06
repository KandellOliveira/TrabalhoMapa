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
        setSize(1000, 800);
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
        desenharArestasDoMapa(g);
        desenharVerticesDoMapa(g);
    }

    private void desenharMenorcaminho(Graphics g) {
        if (this.menorCaminho != null) {
            desenharArestas(g);
            desenharVertices(g);
        }
    }

    private void desenharArestas(Graphics g) {
        for (Vertice vertice1 : this.menorCaminho) {
            if (vertice1.getDestinoAnterior() != null) {
                g.setColor(Color.yellow);
                g.drawLine(vertice1.getPosicaoX(),
                        vertice1.getPosicaoY(),
                        vertice1.getDestinoAnterior().getPosicaoX(),
                        vertice1.getDestinoAnterior().getPosicaoY());
            }
        }
    }

    private void desenharVertices(Graphics g) {
        for (Vertice vertice : this.menorCaminho) {

            g.setColor(Color.ORANGE);
            g.fillOval(vertice.getPosicaoX() - 30, vertice.getPosicaoY() - 30, 60, 60);

            rotularInicioEfim(vertice, g);
        }
    }

    private void rotularInicioEfim(Vertice vertice, Graphics g) {
        g.setColor(Color.green);
        if (vertice.isInit()) {
            g.drawString("Inicio", vertice.getPosicaoX(), vertice.getPosicaoY());
        }

        if (vertice.isFim()) {
            g.drawString("Fim", vertice.getPosicaoX(), vertice.getPosicaoY());
        }
    }

    private int desenharVerticesDoMapa(Graphics g) {
        int contador = 0;
        for (Vertice vertice : vertices) {
            g.setColor(Color.blue);
            g.fillOval(vertice.getPosicaoX() - 30, vertice.getPosicaoY() - 30, 60, 60);
            g.setColor(Color.black);
            g.drawString(vertice.getNome(), vertice.getPosicaoX() - 30, vertice.getPosicaoY() - 30);
            contador++;


            rotularInicioEfim(vertice, g);
        }
        return contador;
    }

    private void desenharArestasDoMapa(Graphics g) {
        int contador = 0;
        int incremento = 0;
        for (Vertice vertice : vertices) {
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
}
