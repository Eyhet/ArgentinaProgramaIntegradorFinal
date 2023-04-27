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
public class Equipo {
    
    private String _nombre;
    
    private int _goles;
    
    public Equipo()
    {}
    
    public Equipo(String nombre)
    {
        this._nombre = nombre;
        
    
    }

    public int getGoles() {
        return _goles;
    }

    public void setGoles(int _goles) {
        this._goles = _goles;
    }
    
    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    
    public int nroEquipos (List <List<Equipo>> ganadores)
    {
        
     int u=0;
     int nro=0;
     
     
     for(List i : ganadores)
     { List <Equipo> equipos;
     
       equipos=ganadores.get(u);
       
       for(Equipo x : equipos)
       {
       nro++;
       }
       
       u++;
     }
    
    
    return nro;
    
    
    }
    
    
    
    
    
    
    public List<List<Equipo>> equipoMaker (List <List<String>> rondas)
    {
     
     
     List <String> texto;
     List <List<Equipo>> brackets = new ArrayList();
    
     
     int u=0;
     int z;
     
     
     for(List i : rondas)
     {
       List <Equipo> equipos = new ArrayList();  
       
       texto=rondas.get(u);  
       z=0;
       
       for(String x : texto)
       {
        
        Equipo equipo = new Equipo();
        
        equipo.setNombre(texto.get(z));
        equipos.add(equipo);
       
        z++;
       }
       
       brackets.add(equipos);
       u++; 
     }
    
    return brackets;
    }
    
    
    
    
    
    
    public List<List<String>> rondasYEquipos (File archivo) throws FileNotFoundException, IOException
    {
    
 FileReader reader = new FileReader(archivo);
 BufferedReader buffer =new BufferedReader(reader);
     
 List <List<String>> rondas = new ArrayList();
 
 String linea=buffer.readLine();

        while(linea != null){             
          while (linea != null && linea.contains("Ronda"))
           {
            
            List <String> rondaX = new ArrayList(); 
            linea=buffer.readLine();
  
            while(linea!=null && !linea.contains("Ronda"))
            {
                if(!linea.trim().isEmpty()){
                 rondaX.add(linea); 
                }
               linea=buffer.readLine();
            }
            
            rondas.add(rondaX);

           }
        }
        
    
        
        
        
        
     return rondas;
    
    
    
    
   }
    
    
    
}
