/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.projekt5.models;

import java.sql.Connection;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Kuba
 */
public class KolumnaModelTest extends TestCase {
    
    ModelFactory f = null;
    
    public KolumnaModelTest(String testName) {
        super(testName);
        f = ModelFactory.getInstance();
        
        //KlasaModel klasa = (KlasaModel)m.getModel("KlasaModel");
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getAll method, of class KolumnaModel.
     */
    public void testGetAll() {
        System.out.println("getAll");
        KolumnaModel instance = (KolumnaModel)f.getModel("KolumnaModel");//new KolumnaModel();
        List<Kolumna> result = instance.getAll();
        assertNotNull("Pusta baza danych", result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class KolumnaModel.
     */
    public void testGet() {
        System.out.println("get");
        int id = 0;
        KolumnaModel instance = (KolumnaModel)f.getModel("KolumnaModel");//new KolumnaModel();
        Kolumna result = instance.get(id);
        assertNull("Zwraca null", result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
