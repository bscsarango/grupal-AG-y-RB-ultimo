/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Modelo.Jugador;
import Modelo.Test;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.jgap.InvalidConfigurationException;

/**
 *
 * @author user
 */
@ManagedBean(name="bean")
@SessionScoped
public class BeanJugador {
    private List resultado = new ArrayList();
    private String opcion= "";
    private Jugador j= new Jugador();
    public Test test = new Test();

    public List getResultado() {
        return resultado;
    }

    public void setResultado(List resultado) {
        this.resultado = resultado;
    }

  
    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public Jugador getJ() {
        return j;
    }

    public void setJ(Jugador j) {
        this.j = j;
    }
    
     public List comparar(String s) {
        Test t = new Test();
        List l = j.cargarJugadores();
        Iterator<Jugador> itj;
        List l2 = new ArrayList();
        System.out.println("ingresa ");
        itj = l.iterator();
        while (itj.hasNext()) {
            j = itj.next();
            if (j.getPosicion().equals(s)) {
                l2.add(j);
            }
        }
        System.out.println("kk" + l2);

        return l2;
    }
     
    public String cargar(){
       
       switch(getOpcion()){
       case "portero":
           setOpcion("portero");
           break;
       case "defensa":
           setOpcion("defensa");
           break;
       case "volante":
           setOpcion("volante");
           break;
       case "delantero":
           setOpcion("delantero");
           break;
                }
    return getOpcion()+".xhtml";
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

public String obtener_resultado() throws Exception {
    try {
            test.iniciar(getOpcion());
            test.seleccionar();
            test.isVer();
            
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(BeanJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
   //test.seleccionar();
    
  return "defensa.xhtml";
}
//    public static void main(String[] args) {
//        BeanJugador bj = new BeanJugador();
//        try {
//            bj.obtener_resultado();
//        } catch (Exception ex) {
//            Logger.getLogger(BeanJugador.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
