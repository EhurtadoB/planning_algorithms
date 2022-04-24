package logica;

import java.util.ArrayList;
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
                float auxTComActual = procesos[j].t_comienzo;
                float auxTComSig = procesos[j + 1].t_comienzo;
                float auxTTfinActual = procesos[j].t_fin;
                float auxTTfinSig = procesos[j + 1].t_fin;
                float auxTesperaActual = procesos[j].t_espera;
                float auxTesperaSig = procesos[j + 1].t_espera;

                if (auxllegadaActual > auxllegadaSig) {
                    procesos[j].t_llegada = auxllegadaSig;
                    procesos[j + 1].t_llegada = auxllegadaActual;
                    procesos[j].nomProceso = auxNomSig;
                    procesos[j + 1].nomProceso = auxNomActual;
                    procesos[j].prioridad = auxPrioridadSig;
                    procesos[j + 1].prioridad = auxPrioridadActual;
                    procesos[j].t_cpu = auxCpuSig;
                    procesos[j + 1].t_cpu = auxCpuActual;
                    procesos[j].t_comienzo = auxTComSig;
                    procesos[j + 1].t_comienzo = auxTComActual;
                    procesos[j].t_fin = auxTTfinSig;
                    procesos[j + 1].t_fin = auxTTfinActual;
                    procesos[j].t_espera = auxTesperaSig;
                    procesos[j + 1].t_espera = auxTesperaActual;

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

                if (j > 0) {
                    if (procesos[j].prioridad > procesos[j + 1].prioridad) {
                        {
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
        }
    }

    public void prioridadno(Proceso[] procesos) {
        this.ordenar(procesos);
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
        this.ordenar(procesos);
    }

    public void prioridadExp(Proceso[] procesos) {
        this.ordenar(procesos);
        this.ordenarprioridad(procesos);
        float[] copiaSeguridad = new float[procesos.length];
        ArrayList<Proceso> noEjecutados = new ArrayList<Proceso>();
        ArrayList<Proceso> suspendidos = new ArrayList<Proceso>();
        float auxTiempo;
        int si = 0, i = 1, pos = 0;
        //copia de seguridad
        for (int x = 0; x < procesos.length; x++) {
            copiaSeguridad[x] = procesos[x].getT_cpu();
        }
        //1

        System.out.println("------");
        System.out.println(suspendidos);
        for (int x = 0; x < procesos.length; x++) {
            System.out.println(procesos[x].toString());
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

                if (j > 0) {
                    if (procesos[j].t_llegada != 0) {
                        if (auxllegadaActual < (procesos[j - 1].t_cpu + procesos[j - 1].t_llegada)) {
                            if (procesos[j].t_cpu > procesos[j + 1].t_cpu) {
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
        }
    }

    public void sjf(Proceso[] procesos) {
        this.ordenar(procesos);
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
        this.ordenar(procesos);

    }

    public void srtf(Proceso[] procesos) {

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
