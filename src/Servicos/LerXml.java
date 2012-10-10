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
    
    // caminho (path) do arquivo XML  
  private String xmlPathname;  
  
  // construtor que seta o caminho do XML  
  public LerXml( String path ) {  
    xmlPathname = path;  
  } 
  
  // le o XML carregando os dados dos usuários em um Vector.  
// retorna o vector contendo os usuários cadastrados no XML.  
public ArrayList<Vertice> lerMapa() throws Exception {  
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
    DocumentBuilder db = dbf.newDocumentBuilder();  
    Document doc = db.parse( xmlPathname );  
    Element elem = doc.getDocumentElement();  
    // pega todos os elementos usuario do XML  
    NodeList nl = elem.getElementsByTagName( "vertice" );  
  
    // prepara o vetor      
    ArrayList<Vertice> vetorVertice = new ArrayList<Vertice>(); 
    
    
     // percorre cada elemento usuario encontrado  
    for( int i=0; i<nl.getLength(); i++ ) {  
        Element tagVertice = (Element) nl.item( i );  
       
        
        // pega os dados cadastrado para o usuario atual  
        int x = Integer.parseInt( tagVertice.getAttribute( "x" ) );
        int y = Integer.parseInt( tagVertice.getAttribute( "y" ) );
        String nome = tagVertice.getAttribute("nome");  
        boolean init = Boolean.parseBoolean(tagVertice.getAttribute("init"));
        boolean fim = Boolean.parseBoolean(tagVertice.getAttribute("fim"));
       
        // cria uma nova instancia do UsuarioGuj com os dados do xml  
        Vertice vertice = new Vertice(init, fim, nome, x, y); 
       
        NodeList nlAresta = tagVertice.getElementsByTagName( "arestas" );  
  
        // prepara o vetor      
        ArrayList<Aresta> vetorAresta = new ArrayList<Aresta>(); 
           
        for (int j = 0; j < nlAresta.getLength(); j++) {
            Element tagAresta = (Element) nlAresta.item( j );  
               
            // pega os dados cadastrado para o usuario atual  
            int peso = Integer.parseInt( tagAresta.getAttribute( "peso" ) );
            String destino = tagAresta.getAttribute( "destino" );
            
            vetorAresta.add(new Aresta(peso,destino));

        }
        
        // adiciona o usuario na coleção (vector) de usuários do guj 
        vertice.setArestas(vetorAresta);
        vetorVertice.add( vertice );  
    }  
     
    return vetorVertice;  
}  

}
