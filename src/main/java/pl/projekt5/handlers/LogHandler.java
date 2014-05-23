/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.projekt5.handlers;

import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author Kuba
 */
public class LogHandler {
    private static LogHandler instance = null;
    private static PrintWriter file = null;
    private SimpleDateFormat Date;
    public static LogHandler getInstance() {
        if(instance == null)
            instance = new LogHandler();
        return instance;
    }
    
    private LogHandler() {
        try {
            InputStream config = getClass().getResourceAsStream("config.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.parse(config);

            NamedNodeMap attr = doc.getElementsByTagName("logs").item(0).getAttributes();
            String file_name = attr.getNamedItem("file").getNodeValue();
            this.file = new PrintWriter(file_name);
            this.Date = new SimpleDateFormat("[yyyy-MM-dd kk:mm:ss]: ");
        }catch(Exception e) {
            ExceptionHandler.handle(e, ExceptionHandler.FATAL_ERR);
        }
    }
    
    public void add(String log) {
        
        this.file.println(Date.format(new Date()) + log);
    }
    
    public static void close() {
        if( file != null ) file.close();
    }
    
    public void finalize() throws Throwable {
        super.finalize();
        this.close();
    }
}
