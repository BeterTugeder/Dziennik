package pl.projekt5.models;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NamedNodeMap;
import pl.projekt5.handlers.ExceptionHandler;
import pl.projekt5.handlers.LogHandler;

/**
*
* @author Kuba
*/
public class ModelFactory {
    
    private static ModelFactory instance = null;
    
    private static Connection conn;
    
    private ModelFactory() {
        try {
            InputStream config = getClass().getResourceAsStream("config.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.parse(config);
            
            NamedNodeMap attr = doc.getElementsByTagName("database").item(0).getAttributes();
            String dbName = attr.getNamedItem("address").getNodeValue();
            
            conn = DriverManager.getConnection("jdbc:sqlite:"+dbName);
            
        }catch(Exception e) {
            ExceptionHandler.handle(e, ExceptionHandler.FATAL_ERR);
        }
    }
    
    public static ModelFactory getInstance() {
        if(instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }
    
    public Model getModel(String name) {
        Model obj = null;
        ClassLoader classLoader = ModelFactory.class.getClassLoader();
        try {
            if(!name.equals("Model")
                    || !name.equals("ModelFactory")
                    || !name.equals("ModelException")
            ) {
                //Throws
                //ClassNotFoundException
                //InstantiationException
                //IllegalAccessException
                  //obj = (Model)Class.forName(name).newInstance();
                obj = (Model)classLoader.loadClass("pl.projekt5.models." + name).newInstance();
            }else {
                throw new ModelException("Nie mozna zaladowac wybranego modelu: " + name);
            }
            
        }catch(Exception e) {
            //lapiemy wszystkie wyjatki jako fatal error
            ExceptionHandler.handle(e, ExceptionHandler.FATAL_ERR);
        }
        obj.initializeModel(conn);
        return obj;
    }
    
    public static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            ExceptionHandler.handle(e, ExceptionHandler.FATAL_ERR);
        }
    }
}