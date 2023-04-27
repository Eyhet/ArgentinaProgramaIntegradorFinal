/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.argentinaprogramaintegradorfinal;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebim
 */








/*Hacer este trabajo Practivo integrador fue muy complicado, tarde muchisimo y al final no consegui lo que buscaba pero aun asi estoy orgulloso de el resultado

Asi no termine aprobando el curso igual estoy orgulloso de haberlo intentado.*/









public class ArgentinaProgramaIntegradorFinal {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
        String url = "jdbc:mysql://localhost:3306/default";
        String usuario="root";
        String contraseña="";
        
         
        List <Integer> sqlIdPartidos= new ArrayList();
        List <String> sqlPartidoEquipo1= new ArrayList();
        List <String> sqlPartidoEquipo2= new ArrayList();
        
        List <Integer> sqlIdPredicciones= new ArrayList();
        List <Integer> sqlPrediccionesPartidos= new ArrayList();
        List <Integer> sqlPrediccionesJugador= new ArrayList();
        List <String> sqlPrediccionesResultado= new ArrayList();
        
        List<Integer> sqlJugadoresId = new ArrayList();
        List<String> sqlJugadores = new ArrayList();
        
        
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection connection = DriverManager.getConnection(url,usuario,contraseña);
        
        Statement statement=  connection.createStatement();
        
        ResultSet resultset;

        resultset = statement.executeQuery("select * from partidos");
        
        while(resultset.next())
        {
        
         sqlIdPartidos.add(resultset.getInt(1));
         sqlPartidoEquipo1.add(resultset.getString(2));
         sqlPartidoEquipo2.add(resultset.getString(3));
        
        }
        
         
        
        resultset = statement.executeQuery("select * from predicciones");
        while(resultset.next())
        {
        
         sqlIdPredicciones.add(resultset.getInt(1));
         sqlPrediccionesJugador.add( resultset.getInt(2));
         sqlPrediccionesPartidos.add( resultset.getInt(3));
         sqlPrediccionesResultado.add(resultset.getString(4));
        
        }
        
        resultset = statement.executeQuery("select * from jugadores");
       
        while(resultset.next())
        {
        
         sqlJugadoresId.add(resultset.getInt(1));
         sqlJugadores.add(resultset.getString(2));
        
        }
        
        
       
        }
        catch(ClassNotFoundException | SQLException e)
        { System.out.println(e);}
        
         List <Integer> puntosSql= new ArrayList();
        
        int puntos1=0;
        int nro=1;
        
       
         
        /*System.out.println(sqlPrediccionesJugador);
        
        System.out.println("\n");
        
        System.out.println(sqlPartidoEquipo1);
        System.out.println(sqlPartidoEquipo2);
        System.out.println(sqlPrediccionesResultado);*/
        
        for(int i = 0; i<sqlPrediccionesJugador.size();i++   )
        {
            if(nro!=sqlPrediccionesJugador.get(i))
            {   
                
                System.out.println(puntosSql);
                nro++;
                puntos1=0;
            }
            if(nro==sqlPrediccionesJugador.get(i))
            {
                //System.out.println(sqlPrediccionesJugador.get(i));
                
                
                int t =0;
            
                for (int j=0 ; j< sqlPrediccionesPartidos.size()/2;j++)
                {
                
                String equipo1 = sqlPartidoEquipo1.get(t);
                String equipo2 = sqlPartidoEquipo2.get(t);
                
                /*System.out.println(equipo1);
                System.out.println(equipo2);
                */
                String prediccion = sqlPrediccionesResultado.get(t);
             
                    if(equipo1.equals(prediccion)||equipo2.equals(prediccion))
                    {
                        puntos1++;
                        //System.out.println(puntos1);
                    }
                t++;
                }
                System.out.println("final if"+nro);
                puntosSql.add(puntos1);
            }
            
        
        }
        
        
        for(int b =0; b<sqlJugadores.size();b++)
        {
        
        System.out.println(" Jugador:  "+sqlJugadores.get(b)+" Puntos Totales= "+puntosSql.get(b));
        
       
        
        }
        
        
     
        int z=0;
        
        File partidos = new File("Rondas.txt");
        File predicciones = new File ("Predicciones.txt");
        
        List <List<String>> lista;
        List <List<Equipo>> equipos;
        List <List<Equipo>> ganadores;
        List<List <String>> rondas;
        List <String> jugadores;
        List <Integer> puntos;
        
        
        Torneo torneo = new Torneo();
        Equipo equipo = new Equipo();
        Predicciones prediccion = new Predicciones();
        
        //Leemos archivo con rondas y Equipos
        lista=equipo.rondasYEquipos(partidos);
        //System.out.println(lista);
        //Creamos objetos Equipo para cada uno de los equipos que participan
        equipos = equipo.equipoMaker(lista);
        //Realizamos el torneo con los equipos en sus respectivas rondas
        ganadores = torneo.Torneo(equipos);
        //Leemos la lista con las predicciones del jugador
        rondas=prediccion.Equipos(predicciones, equipo.nroEquipos(equipos));
        jugadores=prediccion.Jugadores(predicciones, equipo.nroEquipos(equipos));
        //Conseguimos los puntos que le corresponden a cada uno de los jugadores
        puntos = prediccion.Puntos(rondas, ganadores,jugadores.size());
        
        //Imprimimos el puntaje por pantalla
        System.out.println("Puntaje Final: \n");
        
        // System.out.println(puntos);
        int q=0;
        for(int x : puntos)
        {
        
        System.out.println("Jugador"+jugadores.get(q)+" Puntos Totales= "+x);
        
        q++;
        
        }
        
        
        
     
     
     
    }
}
