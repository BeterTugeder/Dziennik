/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.projekt5.models;

import junit.framework.TestCase;

/**
 *
 * @author Kuba
 */
public class ModelFactoryTest extends TestCase {
    
    public ModelFactoryTest(String testName) {
        super(testName);
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
     * Test of getInstance method, of class ModelFactory.
     */
    public void testGetInstance() {
        System.out.println("getInstance");
        ModelFactory expResult = null;
        ModelFactory result = ModelFactory.getInstance();
        assertNotNull(result);
    }

    /**
     * Test of getModel method, of class ModelFactory.
     */
    public void testGetModel() {
        System.out.println("getModel");
        String name = "KlasaModel";
        ModelFactory instance = ModelFactory.getInstance();
        Model expResult = null;
        Model result = instance.getModel(name);
        assertTrue("Zwraca inny model", result instanceof KlasaModel);
    }

    /**
     * Test of closeConnection method, of class ModelFactory.
     */
    public void testCloseConnection() {
        System.out.println("closeConnection");
        ModelFactory.closeConnection();
    }
    
}
