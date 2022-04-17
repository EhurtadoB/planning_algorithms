package logica;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Algoritmo {

    public void ordenar(Proceso[] procesos) {
        for (int i = 0; i < procesos.length; i++) {
            for (int j = 0; j < procesos.length - 1; j++) {

                float auxllegadaActual = procesos[j].t_llegada;
                float auxllegadaSig = procesos[j + 1].t_llegada;
                String auxNomActual = procesos[j].nomProceso;
                String auxNomSig = procesos[j + 1].nomProceso;
                float auxPrioridadActual = procesos[j].prioridad;
                float auxPrioridadSig = procesos[j + 1].prioridad;
                float auxCpuActual = procesos[j].t_cpu;
                float auxCpuSig = procesos[j + 1].t_cpu;

                if (auxllegadaActual > auxllegadaSig) {
                    procesos[j].t_llegada = auxllegadaSig;
                    procesos[j + 1].t_llegada = auxllegadaActual;
                    procesos[j].nomProceso = auxNomSig;
                    procesos[j + 1].nomProceso = auxNomActual;
                    procesos[j].prioridad = auxPrioridadSig;
                    procesos[j + 1].prioridad = auxPrioridadActual;
                    procesos[j].t_cpu = auxCpuSig;
                    procesos[j + 1].t_cpu = auxCpuActual;
                }
            }
        }
    }

    public void fifo(Proceso[] procesos) {
        this.ordenar(procesos);

        for (int x = 0; x < procesos.length; x++) {
            if (x == 0) {
                procesos[x].setT_comienzo(procesos[x].getT_llegada());
                procesos[x].setT_fin(procesos[x].getT_comienzo() + procesos[x].getT_cpu());
                procesos[x].setT_espera(procesos[x].getT_comienzo() - procesos[x].getT_llegada());

            } else {
                if (procesos[x - 1].getT_fin() < procesos[x].getT_llegada()) {
                    procesos[x].setT_comienzo(procesos[x].getT_llegada());
                } else {
                    procesos[x].setT_comienzo(procesos[x - 1].getT_fin());
                }
                procesos[x].setT_fin(procesos[x].getT_comienzo() + procesos[x].getT_cpu());
                procesos[x].setT_espera(procesos[x].getT_comienzo() - procesos[x].getT_llegada());
            }

        }
        Ejecucion h1[] = new Ejecucion[procesos.length];
        for (int i = 0; i < procesos.length; i++) {
            h1[i] = new Ejecucion(procesos[i].getNomProceso(), procesos[i].getT_comienzo(), procesos[i].t_cpu/*, h1[i]*/);
            h1[i].start();
            try {
                h1[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Algoritmo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("");
        for (int x = 0; x < procesos.length; x++) {
            System.out.println(procesos[x].toString());
        }
    }

    public void ordenarprioridad(Proceso[] procesos) {
        for (int i = 0; i < procesos.length; i++) {
            for (int j = 0; j < procesos.length - 1; j++) {

                float auxllegadaActual = procesos[j].t_llegada;
                float auxllegadaSig = procesos[j + 1].t_llegada;
                String auxNomActual = procesos[j].nomProceso;
                String auxNomSig = procesos[j + 1].nomProceso;
                float auxPrioridadActual = procesos[j].prioridad;
                float auxPrioridadSig = procesos[j + 1].prioridad;
                float auxCpuActual = procesos[j].t_cpu;
                float auxCpuSig = procesos[j + 1].t_cpu;

                if (auxllegadaActual > 0) {
                    if (procesos[j].prioridad > procesos[j + 1].prioridad) {
                        procesos[j].t_llegada = auxllegadaSig;
                        procesos[j + 1].t_llegada = auxllegadaActual;
                        procesos[j].nomProceso = auxNomSig;
                        procesos[j + 1].nomProceso = auxNomActual;
                        procesos[j].prioridad = auxPrioridadSig;
                        procesos[j + 1].prioridad = auxPrioridadActual;
                        procesos[j].t_cpu = auxCpuSig;
                        procesos[j + 1].t_cpu = auxCpuActual;
                    }
                }

            }
        }
    }

    public void prioridadno(Proceso[] procesos) {
        this.ordenarprioridad(procesos);
        for (int x = 0; x < procesos.length; x++) {
            if (x == 0) {
                procesos[x].setT_comienzo(procesos[x].getT_llegada());
                procesos[x].setT_fin(procesos[x].getT_comienzo() + procesos[x].getT_cpu());
                procesos[x].setT_espera(procesos[x].getT_comienzo() - procesos[x].getT_llegada());

            } else {
                if (procesos[x - 1].getT_fin() < procesos[x].getT_llegada()) {
                    procesos[x].setT_comienzo(procesos[x].getT_llegada());
                } else {
                    procesos[x].setT_comienzo(procesos[x - 1].getT_fin());
                }
                procesos[x].setT_fin(procesos[x].getT_comienzo() + procesos[x].getT_cpu());
                procesos[x].setT_espera(procesos[x].getT_comienzo() - procesos[x].getT_llegada());
            }

        }
        Ejecucion h1[] = new Ejecucion[procesos.length];

        for (int i = 0; i < procesos.length; i++) {
            h1[i] = new Ejecucion(procesos[i].getNomProceso(), procesos[i].getT_comienzo(), procesos[i].t_cpu/*, h1[i]*/);
            h1[i].start();
            try {
                h1[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Algoritmo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("");
        for (int x = 0; x < procesos.length; x++) {
            System.out.println(procesos[x].toString());
        }
    }

    public void prioridadExp(Proceso[] procesos) {
        this.ordenar(procesos);

        for(int x = 0; x < procesos.length; x++) {
            for(int y = 0; y < procesos.length; y++) {
                if(x == 0) {
                    procesos[x].setT_comienzo(procesos[x].getT_llegada());
                    if(procesos[x].getPrioridad() > procesos[y].getPrioridad()) {

                    }
                }
            }
        }
    }

    public void ordenartcpu(Proceso[] procesos) {
        for (int i = 0; i < procesos.length; i++) {
            for (int j = 0; j < procesos.length - 1; j++) {

                float auxllegadaActual = procesos[j].t_llegada;
                float auxllegadaSig = procesos[j + 1].t_llegada;
                String auxNomActual = procesos[j].nomProceso;
                String auxNomSig = procesos[j + 1].nomProceso;
                float auxPrioridadActual = procesos[j].prioridad;
                float auxPrioridadSig = procesos[j + 1].prioridad;
                float auxCpuActual = procesos[j].t_cpu;
                float auxCpuSig = procesos[j + 1].t_cpu;

                if (auxllegadaActual > 0 && auxCpuActual > auxCpuSig) {
                    procesos[j].t_llegada = auxllegadaSig;
                    procesos[j + 1].t_llegada = auxllegadaActual;
                    procesos[j].nomProceso = auxNomSig;
                    procesos[j + 1].nomProceso = auxNomActual;
                    procesos[j].prioridad = auxPrioridadSig;
                    procesos[j + 1].prioridad = auxPrioridadActual;
                    procesos[j].t_cpu = auxCpuSig;
                    procesos[j + 1].t_cpu = auxCpuActual;
                }
            }
        }
    }

    public void sjf(Proceso[] procesos) {
        this.ordenartcpu(procesos);

        for (int x = 0; x < procesos.length; x++) {
            if (x == 0) {
                procesos[x].setT_comienzo(procesos[x].getT_llegada());
                procesos[x].setT_fin(procesos[x].getT_comienzo() + procesos[x].getT_cpu());
                procesos[x].setT_espera(procesos[x].getT_comienzo() - procesos[x].getT_llegada());

            } else {
                if (procesos[x - 1].getT_fin() < procesos[x].getT_llegada()) {
                    procesos[x].setT_comienzo(procesos[x].getT_llegada());
                } else {
                    procesos[x].setT_comienzo(procesos[x - 1].getT_fin());
                }
                procesos[x].setT_fin(procesos[x].getT_comienzo() + procesos[x].getT_cpu());
                procesos[x].setT_espera(procesos[x].getT_comienzo() - procesos[x].getT_llegada());
            }

        }
        Ejecucion h1[] = new Ejecucion[procesos.length];

        for (int i = 0; i < procesos.length; i++) {
            h1[i] = new Ejecucion(procesos[i].getNomProceso(), procesos[i].getT_comienzo(), procesos[i].t_cpu);
            h1[i].start();
            try {
                h1[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Algoritmo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("");
        for (int x = 0; x < procesos.length; x++) {
            System.out.println(procesos[x].toString());
        }

    }

    public int min(Proceso[] procesos){
        int pos = 0;
        for (int i = 0; i < procesos.length; i++) {
            if(procesos[i].t_llegada>0 && procesos[i].t_cpu < procesos[i+1].t_cpu){
                pos = i;
                return  pos; 
            }
            
        }
        return 0;
    }
    public void srtf(Proceso[] procesos) {
        Ejecucion h1[] = new Ejecucion[procesos.length];
        
        for (int i = 0; i < procesos.length; i++) {
            h1[min(procesos)] = new Ejecucion(procesos[min(procesos)].nomProceso, procesos[min(procesos)].t_llegada, procesos[min(procesos)].t_cpu);
            h1[min(procesos)].start();
        }
    }
}

class Ejecucion extends Thread {

    protected String nomProceso;
    protected float t_llegada;
    protected float t_cpu;

    public Ejecucion(String nomProceso, float t_llegada, float t_cpu) {

        this.nomProceso = nomProceso;
        this.t_llegada = t_llegada;
        this.t_cpu = t_cpu;
    }

    @Override
    public void run() {
        for (float i = t_llegada; i <= t_cpu + t_llegada; i++) {
            System.out.println("Proceso " + nomProceso + " ejecutandose: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ejecucion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Proceso " + nomProceso + " Terminado");
    }
}
