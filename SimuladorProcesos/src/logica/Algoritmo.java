package logica;

import java.util.HashSet;
import java.util.Set;

public class Algoritmo {

    public void ordenar(Proceso[] procesos) {
        for(int i = 0; i < procesos.length; i++) {
            for(int j = 0; j < procesos.length - 1; j++) {
                float auxActual = procesos[j].t_llegada;
                float auxSig = procesos[j+1].t_llegada;
                if(auxActual > auxSig) {
                    procesos[j].t_llegada = auxSig;
                    procesos[j+1].t_llegada = auxActual;
                }
            }
        }
    }

    public void fifo(Proceso[] procesos) {
        this.ordenar(procesos);
        
        for (int x=0; x<procesos.length; x++) {
            if(x == 0){
                procesos[x].setT_comienzo(procesos[x].getT_llegada());
                procesos[x].setT_fin(procesos[x].getT_comienzo()+procesos[x].getT_cpu());
                procesos[x].setT_espera(procesos[x].getT_comienzo()-procesos[x].getT_llegada());

            }
            else{
                if(procesos[x-1].getT_fin()<procesos[x].getT_llegada()){
                    procesos[x].setT_comienzo(procesos[x].getT_llegada());
                }
                else
                {
                    procesos[x].setT_comienzo(procesos[x-1].getT_fin());
                }
                procesos[x].setT_fin(procesos[x].getT_comienzo()+procesos[x].getT_cpu());
                procesos[x].setT_espera(procesos[x].getT_comienzo()-procesos[x].getT_llegada());
            }
            
        }
        System.out.println("");
        for(int x=0; x<procesos.length; x++){
           System.out.println(procesos[x].toString()); 
        }

    }
}
