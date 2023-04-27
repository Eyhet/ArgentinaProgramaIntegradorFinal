/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argentinaprogramaintegradorfinal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebim
 */
public class Torneo {
    
    public List<List<Equipo>> Torneo (List<List <Equipo>> ronda)
    {
        Partido partido = new Partido();
        
        List <List<Equipo>> rondasYGanadores= new ArrayList();
        List <Equipo> equipos;
  
        int nro;
        int q;
        int u=0;

       for(List i : ronda)
       {
           List <Equipo> ganadores = new ArrayList();
           equipos = ronda.get(u);
 
           
           
           nro=0;
           for(Equipo x : equipos)
           {
             nro++;
           }
           
           
           q=0;
           for(int z=0; z<nro/2 ;z++)
           {
               
               ganadores.add(partido.Partido(equipos.get(q), equipos.get(q+1)));
               
               
               
               q +=2;
           }    
           
                      
           rondasYGanadores.add(ganadores);

           
           
           u++;
       }
       
      
       
       
       
        
    return rondasYGanadores;
    
    }
    
    
    
}
