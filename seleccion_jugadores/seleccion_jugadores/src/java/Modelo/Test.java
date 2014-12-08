/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

/**
 *
 * @author user
 */


public class Test {
    private Configuration conf;
    private FitnessFunctionJugador ffa;
    public Jugador jugadoor =new Jugador();
    public List jugador= new ArrayList();
    public List posicion = new ArrayList();
    public static final int MAX_ALLOWED_EVOLUTIONS =1500;
    private Chromosome jugadorChromosome=null;
    
    String presentacion="";

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }
    
    
    public void iniciar(String tipoPosicion)throws Exception{
        StringTokenizer st= new StringTokenizer(tipoPosicion);
        while (st.hasMoreElements()) {
            String desp = st.nextToken();
            posicion.add(desp);
        }
        jugador=jugadoor.cargarJugadores();
        conf= new DefaultConfiguration();
        conf.setPreservFittestIndividual(true);
        conf.setPopulationSize(1000);
        conf.setKeepPopulationSizeConstant(false);
        
       ffa=new FitnessFunctionJugador(jugador, posicion);
       conf.setFitnessFunction(ffa);
       
       Gene[] aniGene=new Gene[1];
       aniGene[0]=new IntegerGene(conf, 0, jugador.size()-1);
//       aniGene[1]=new IntegerGene(conf, 0, jugador.size()-1);
       jugadorChromosome = new Chromosome(conf, aniGene);
       aniGene[0].setAllele(new Integer(0));
//       aniGene[1].setAllele(new Integer(1));
       
       conf.setSampleChromosome(jugadorChromosome);
       
    }    
  public   boolean ver=false;

    public boolean isVer() {
        return ver;
    }

    public void setVer(boolean ver) {
        this.ver = ver;
    }
  
        public void seleccionar() throws InvalidConfigurationException{
        jugador=jugadoor.cargarJugadores();
        Genotype poblacion=Genotype.randomInitialGenotype(conf);
       IChromosome mejorSolucion=jugadorChromosome;
        
        for (int i = 0; i < MAX_ALLOWED_EVOLUTIONS; i++) {
            poblacion.evolve();
            IChromosome mejorCandidato=poblacion.getFittestChromosome();
            
            if (mejorCandidato.getFitnessValue()>mejorSolucion.getFitnessValue()) {
                mejorSolucion=mejorCandidato;
            }
        }
        
         presentar(mejorSolucion, jugador);
            ver=true;
        }
        
    public void presentar(IChromosome solucion, List an){
        
        System.out.println("---**--**RESPUESTA**--**--");
        System.out.println("Valor de Fitness: "+solucion.getFitnessValue());
        
        for (int i = 0; i < solucion.size(); i++) {
            int index= (Integer)solucion.getGene(i).getAllele();
            Jugador ju=(Jugador)an.get(index);
            System.out.println(ju.toString());
            setPresentacion(getPresentacion()+"//"+ju.toString());
            }
        
      
        
    }
    
    
}
