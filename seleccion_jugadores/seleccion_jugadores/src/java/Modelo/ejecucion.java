/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.jgap.InvalidConfigurationException;

/**
 *
 * @author user
 */
public class ejecucion {
    public static void main(String[] args) throws InvalidConfigurationException, Exception {
//        Test t= new Test();
//        t.iniciar("portero");
//        t.seleccionar();
//        Jugador j = new Jugador();
//        System.out.println("los porteros son");
//                System.out.println("jbc"+j.cargarJugadores());
//                Test t = new Test();
//                t.iniciar("portero");
//                t.seleccionar();
//    }
        LeerArchivo l = new LeerArchivo();
        l.leer();
    }
}
