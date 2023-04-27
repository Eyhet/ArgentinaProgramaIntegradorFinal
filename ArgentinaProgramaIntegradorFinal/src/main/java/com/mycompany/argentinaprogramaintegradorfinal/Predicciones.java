/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argentinaprogramaintegradorfinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebim
 */
public class Predicciones {
    
    
    
public List<Integer> Puntos (List<List<String>> rondasP, List<List<Equipo>> ganadores, int nro) {

    List<String> predicciones;
    List<Equipo> equiposG;
    List<Integer> tablaPuntos = new ArrayList<>();


    
    
    int conjunto= rondasP.size()/nro;
    
    
    String nombre;
    String nombre2;

    int offset=0;
    for (int i = 0; i < nro; i++) 
    
    {   
        tablaPuntos.add(0);
        
        for (int j = 0; j < conjunto; j++) 

        {   
            predicciones= rondasP.get(offset);
            equiposG = ganadores.get(j);
            
            for(int h =0; h<equiposG.size() ; h++ )
            {
                   
                nombre= predicciones.get(h);
                nombre2= equiposG.get(h).getNombre();

              if(!(equiposG.get(h).getGoles()==0))  
              {
                  
                if (nombre.equals(nombre2)) 
                {
                    tablaPuntos.set(i, tablaPuntos.get(i)+1);  
                }
              }
              
              
            }
            
            offset++;
        }
             
    }
    
    
    
    
    return tablaPuntos;
}

    
public List<String> Jugadores(File predicciones, int nro) throws FileNotFoundException, IOException 
{  
 FileReader reader = new FileReader(predicciones);
 BufferedReader buffer =new BufferedReader(reader);

 
 List <String> jugadores = new ArrayList();
 
 int u=0;
 
 
 
 String linea=buffer.readLine();
        while( linea!= null)
        {
            
          //System.out.println(linea);
        
          if ( linea.contains("Jugador:")  )
           {  
               //System.out.println(linea);
               
             jugadores.add(linea.substring(8));
               //System.out.println(jugadores.get(u));
             linea=buffer.readLine();
               //System.out.println(linea);
               
           }
          
          while(linea!=null && !linea.contains("Jugador:"))
          {
            linea=buffer.readLine();
             //System.out.println(linea);
          }

            
          
          
          u++;
          
        }
        

        
     return jugadores;
     
}
    
    


    
public List<List<String>> Equipos(File predicciones, int nro) throws FileNotFoundException, IOException 
{  
 FileReader reader = new FileReader(predicciones);
 BufferedReader buffer =new BufferedReader(reader);

 int u=0;
 List <List<String>> rondas = new ArrayList();
 
 
 String linea=buffer.readLine();
        while( linea!= null)
        {
            
            List <String> equipos = new ArrayList();
            
            
           
          //System.out.println(linea);
        
          if ( linea.contains("Jugador:")  )
           {   
               //System.out.println(jugadores.get(u));
             linea=buffer.readLine();
               //System.out.println(linea);
               
           }
          
          while(linea.trim().isEmpty() || linea.contains("Ronda"))
          {
            linea=buffer.readLine();
             //System.out.println(linea);
          }

          
          
          while (linea!=null && !linea.trim().isEmpty() && !linea.contains("Ronda"))
          { 
          equipos.add(linea);
          linea=buffer.readLine();
          
          }
            
            
            
          
          
          if(!equipos.isEmpty())
          {
          
          rondas.add(equipos);
          
          }
          
            
          
          linea= buffer.readLine();
          
          u++;
          
        }
        
        
        
        
     return rondas;
     
}
    
    
    
    
    
}
