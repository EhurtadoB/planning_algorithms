package logica;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Algoritmo {

    public void ordenar(Proceso[] procesos) {
        for(int i = 0; i < procesos.length; i++) {
            for(int j = 0; j < procesos.length - 1; j++) {

                float auxllegadaActual = procesos[j].t_llegada;
                float auxllegadaSig = procesos[j+1].t_llegada;
                String auxNomActual = procesos[j].nomProceso;
                String auxNomSig = procesos[j+1].nomProceso;
                float auxPrioridadActual = procesos[j].prioridad;
                float auxPrioridadSig = procesos[j+1].prioridad;
                float auxCpuActual = procesos[j].t_cpu;
                float auxCpuSig = procesos[j+1].t_cpu;

                if(auxllegadaActual > auxllegadaSig) {
                    procesos[j].t_llegada = auxllegadaSig;
                    procesos[j+1].t_llegada = auxllegadaActual;
                    procesos[j].nomProceso = auxNomSig;
                    procesos[j+1].nomProceso = auxNomActual;
                    procesos[j].prioridad = auxPrioridadSig;
                    procesos[j+1].prioridad = auxPrioridadActual;
                    procesos[j].t_cpu = auxCpuSig;
                    procesos[j+1].t_cpu = auxCpuActual;
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
