/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argentinaprogramaintegradorfinal;

import java.util.Random;

/**
 *
 * @author sebim
 */
public class Partido {
    
    
    
    private Equipo _equipo1;
    private Equipo _equipo2;
    
    
    
    public Partido ()
    {
    }
    
    public Partido(Equipo equipo1, Equipo equipo2)
    {
    
    
    }

    public Equipo getEquipo1() {
        return _equipo1;
    }

    public void setEquipo1(Equipo _equipo1) {
        this._equipo1 = _equipo1;
    }

    public Equipo getEquipo2() {
        return _equipo2;
    }

    public void setEquipo2(Equipo _equipo2) {
        this._equipo2 = _equipo2;
    }

    public String ComparacionYGanador(int goles1,int goles2, Partido partido)
    {
        String Case;
    
       if(goles1>goles2)
       {
        Case = partido.getEquipo1().getNombre();
       
       }
       else if( goles1<goles2)
       {
           Case = partido.getEquipo2().getNombre();
                   
       
       }
       else{  Case="E"; }
    
    
       return Case;
    
    }
    

    
    public Equipo Partido(Equipo equipo1, Equipo equipo2)
    {
    
         
        
        Equipo equipoG = new Equipo();

        int minutos = 90;
        
        int gEquipo1 = 0;
        int gEquipo2 = 0;
        
        Random random = new Random();

        
        for (int i=0; i <= minutos; i++)
        {
            
            int nroRandom = random.nextInt();
            int nroRandom2 = random.nextInt();
            int randomDiv = nroRandom / nroRandom2;
            
            if(randomDiv > (random.nextInt()/2) )
            {
            gEquipo1++;
            }
            else
            {
            gEquipo2++;
            }
        
        
        }
        
        if(gEquipo1>gEquipo2)
        {
         equipoG.setGoles(gEquipo1);
         equipoG.setNombre(equipo1.getNombre());
        }
        else if(gEquipo1<gEquipo2)
        {
         equipoG.setGoles(gEquipo2);
         equipoG.setNombre(equipo2.getNombre());
        }
        else
        {
         equipoG.setGoles(0);
         equipoG.setNombre("Empate entre" +equipo1.getNombre()+" y "+equipo2.getNombre());
        }
    
    return equipoG;
        
    }
    
    
    
}
