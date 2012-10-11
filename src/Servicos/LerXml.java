package Servicos;

import Modelos.Aresta;
import Modelos.Vertice;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LerXml {

    private String xmlPath;
    private ArrayList<Vertice> vertices;

    public LerXml(String path) {
        xmlPath = path;
    }

    public ArrayList<Vertice> lerMapa() throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(xmlPath);
        Element element = document.getDocumentElement();
        NodeList verticeXml = element.getElementsByTagName("vertice");
     
        vertices = new ArrayList<Vertice>();

        for (int i = 0; i < verticeXml.getLength(); i++) {
            Element tagVertice = (Element) verticeXml.item(i);

            int x = Integer.parseInt(tagVertice.getAttribute("x"));
            int y = Integer.parseInt(tagVertice.getAttribute("y"));
            String nome = tagVertice.getAttribute("nome");
            boolean init = Boolean.parseBoolean(tagVertice.getAttribute("init"));
            boolean fim = Boolean.parseBoolean(tagVertice.getAttribute("fim"));
            
            Vertice vertice = new Vertice(init, fim, nome, x, y);

            //criarArestas(tagVertice, vertice);
            
            vertices.add(vertice);
        }
        
        for (int i = 0; i < verticeXml.getLength(); i++) {
            Element tagVertice = (Element) verticeXml.item(i);            
            for (Vertice vertice : vertices) {
                if(vertice.equals(tagVertice.getAttribute("nome"))){
                    criarArestas(tagVertice, vertice);
                }
            }                                         
        }
        return vertices;
    }

    private void criarArestas(Element tagVertice, Vertice vertice) throws NumberFormatException {
        NodeList arestasXml = tagVertice.getElementsByTagName("arestas");
        ArrayList<Aresta> arestas = new ArrayList<Aresta>();

        for (int j = 0; j < arestasXml.getLength(); j++) {
            Element tagAresta = (Element) arestasXml.item(j);

            int peso = Integer.parseInt(tagAresta.getAttribute("peso"));
            Vertice verticeAuxiliar = new Vertice(tagAresta.getAttribute("destino"));
            int i = vertices.indexOf(verticeAuxiliar);
            Vertice verticeDestino = vertices.get(i);
            arestas.add(new Aresta(peso, verticeDestino));
        }

        vertice.setArestas(arestas);
    }
}
