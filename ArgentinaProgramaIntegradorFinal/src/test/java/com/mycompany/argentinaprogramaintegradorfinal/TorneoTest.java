/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.argentinaprogramaintegradorfinal;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sebim
 */
public class TorneoTest {
    
    public TorneoTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    

    /**
     * Test of Torneo method, of class Torneo.
     */
    @org.junit.jupiter.api.Test
    public void testTorneo() {
        System.out.println("Torneo");
        
        List<List<Equipo>> ronda = null;
       
        Torneo instance = new Torneo();
        
        List<List<Equipo>> expResult = null;
        
        List<List<Equipo>> result = instance.Torneo(ronda);
        
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    void ganadorTorneo ()
    {
        List<List<Equipo>> equipos1 = new ArrayList();
        List<Equipo> equipos = new ArrayList();
        
        Equipo equipo = new Equipo("sanjuan");
        
        
        equipos.add(equipo);
        equipos.add(equipo);
        
        equipos1.add(equipos);
        
        var ganador = new Torneo();
        
        equipos1=ganador.Torneo(equipos1);
        
        equipos=equipos1.get(0);
    
        
        assertEquals("sanjuan",equipos.get(0).getNombre());
        
    
    }
    
    
}
