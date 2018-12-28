/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 *
 * @author andrei
 */
public class XMLIO {
    static final String filePath = "/home/andrei/NetBeansProjects/Java9AndreiPambuccian/eBooksStoreJava9/src/java/server/users.xml";
    //SAXParserFactory factory;
    //SAXParser parser;
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    Document document;
    Element root;

    NodeList nodeList;
    Node node;
    Element elem;
    
    public XMLIO() {
        //factory = SAXParserFactory.newInstance();
        //parser = factory.newSAXParser();
        factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(filePath);
            root = document.getDocumentElement();
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            System.out.println(ex);
        }
    }
        
    public static void main(String[] args) {
        XMLIO xmlio = new XMLIO();
        xmlio.create(2, "testuser", "password");
        xmlio.read(0);

        xmlio.update(2, "TestUser", null);
        System.out.println("***************");
        xmlio.read(0);

        xmlio.delete(2);
        System.out.println("***************");
        xmlio.read(0);
        
    }
    
    public void create(int id, String username, String password) {
       Element elemUser = document.createElement("user");

       Element elemId = document.createElement("id");
       Element elemUsername = document.createElement("username");
       Element elemPassword = document.createElement("password");
       
       elemId.setTextContent(String.valueOf(id));
       elemUsername.setTextContent(username);
       elemPassword.setTextContent(password);
       
       elemUser.appendChild(elemId);
       elemUser.appendChild(elemUsername);
       elemUser.appendChild(elemPassword);
       root.appendChild(elemUser);
    }
    
    public void read(int id) {        
        if (id == 0) {
            nodeList = document.getElementsByTagName("user");
            for (int i = 0; i < nodeList.getLength(); i++) {
                node = nodeList.item(i);
                readElement((Element) node);
            }
        } else {
            elem = getUserById(id);
            readElement(elem);
        }
    }
    
    private void readElement(Element elem) {
        String id = elem.getElementsByTagName("id").item(0).getTextContent();
        String username = elem.getElementsByTagName("username").item(0).getTextContent();
        String password = elem.getElementsByTagName("password").item(0).getTextContent();
                
        System.out.println("id: " + id + " username: " + username + " password: " + password);
    }
    
    public void update(int id, String username, String password) {
        elem = getUserById(id);
        if (username != null) {
            elem.getElementsByTagName("username").item(0).setTextContent(username);
        }
        
        if (password != null) {
            elem.getElementsByTagName("password").item(0).setTextContent(password);
        }
    }
    
    public void delete(int id) {
        elem = getUserById(id);
        root.removeChild(elem);
    }

    private Element getUserById(int id) {
        nodeList = document.getElementsByTagName("id");
        for (int i = 0; i < nodeList.getLength(); i++) {
            elem = (Element) nodeList.item(i);

            if (Integer.parseInt(elem.getTextContent()) == id) {
                return (Element) elem.getParentNode();
            }
        }
        System.out.println("node with id " + id + " not found");
        return null;
    }
}

/*        
        FileOutputStream out= null;
        try {
                out = new FileOutputStream(filepath);
                // create an int variable to be loaded from input file and to be written to output stream
                int val;
                // read the int value from input stream and write it to output stream
                while ((val = in.read()) != -1) {
                    out.write(val);
                }
        } catch (FileNotFoundException ex) {
                Logger.getLogger(InputAndOutputStreamsAsFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
                Logger.getLogger(InputAndOutputStreamsAsFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if (in != null) {
                    in.close();
            }
            if (out != null) {
                    out.close();
            }
        }

  */      
