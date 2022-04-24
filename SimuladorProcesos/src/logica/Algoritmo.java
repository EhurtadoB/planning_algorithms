package logica;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.util.Length;

public class Algoritmo {

    public ArrayList<Proceso> suspendidos = new ArrayList();

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
        this.ordenar(procesos);
        System.out.println("");
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
        this.ordenar(procesos);
    }

    public int verificarterminados(int[] terminados) {
        int j = 0;
        for (int i = 0; i < terminados.length; i++) {

            if (terminados[i] == 1) {
                j++;
            }
        }
        if (j == terminados.length - 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public void srtf(Proceso[] procesos) {

        this.ordenar(procesos);
        ArrayList<Proceso> terminados = new ArrayList<Proceso>();
        float aux = 0;
        float tiempo = 0;
        ArrayList<Integer> tamSus = new ArrayList<Integer>();
        //copia de seguridad de los tiempos de cpu
        float[] tiempos = new float[procesos.length];
        float totalTiempo = 0;

        for (int i = 0; i < procesos.length; i++) {
            tiempos[i] = procesos[i].t_cpu;
            aux += procesos[i].t_cpu;
            totalTiempo += procesos[i].t_cpu;
        }

        while (terminados.size() != procesos.length) {

            for (int i = 0; i < procesos.length && terminados.size() != procesos.length; i++) {

                while (aux != 0 && i < procesos.length && procesos[i].t_cpu > 0) {

                    for (int llegados = 0; llegados < procesos.length; llegados++) {
                        if (procesos[llegados].getNomProceso()!= procesos[i].getNomProceso() && procesos[llegados].t_cpu != 0 && procesos[llegados].t_llegada <= tiempo && !buscarProceso(procesos[llegados].nomProceso) && procesos[llegados].t_cpu > procesos[i].t_cpu) {
                            agregarSuspendidos(procesos[llegados]);
                            
                        }
                    }

                    if (procesos[i].t_llegada <= tiempo && procesos[i].t_cpu > 0) {

                        System.out.println("El proceso " + procesos[i].nomProceso + " se esta ejecutando en " + tiempo);
                        procesos[i].t_cpu--;
                        aux--;

                        //AGREGAR DATOS
                        tiempo++;

                    }

                    if (procesos[i].t_cpu == 0) {

                        System.out.println("El proceso " + procesos[i].nomProceso + " se termino en " + tiempo);
                        terminados.add(procesos[i]);

                        procesos[i].setT_fin(tiempo);
                        procesos[i].setT_comienzo(procesos[i].getT_fin() - tiempos[i]);
                        procesos[i].setT_espera(procesos[i].getT_espera() + (procesos[i].getT_comienzo() - procesos[i].getT_llegada()));

                        if (tiempo == totalTiempo - 1) {
                            procesos[i].setT_fin(totalTiempo);
                            procesos[i].setT_comienzo(procesos[i].getT_fin() - tiempos[i]);
                        }

                        i++;

                    } else if (i < procesos.length - 1 && procesos[i + 1].t_cpu < procesos[i].t_cpu && procesos[i + 1].t_cpu != 0 && procesos[i + 1].t_llegada < tiempo + 1) {
                        System.out.println("El proceso " + procesos[i].nomProceso + " se suspendio en " + tiempo);
                        agregarSuspendidos(procesos[i]);
                        procesos[i].setT_espera(procesos[i].getT_espera() + (procesos[i].getT_comienzo() - procesos[i].getT_llegada()));
                        tamSus.add(i);
                        tiempos[i] = procesos[i].getT_cpu() + 1;
                        //i++;
                        //tiempo++;

                    }

                    if (!suspendidos.isEmpty()) {
                        int menor = posMenorTiempoSuspendido();
                        /*if (i > procesos.length) {
                            i = 0;
                        }*/
                        if (menor != 9 && suspendidos.get(menor).t_cpu < procesos[i].t_cpu) {
                            for (int z = 0; z < procesos.length; z++) {
                                if (procesos[z].getNomProceso().equals(suspendidos.get(menor).getNomProceso()) ) {
                                    i = z;
                                    suspendidos.remove(menor);
                                    break;
                                }
                            }
                        }
                    }

                }
            }
        }

        System.out.println("");
        for (int x = 0; x < procesos.length; x++) {
            procesos[x].t_cpu = tiempos[x];
            System.out.println(procesos[x].toString());
        }

    }

    public boolean buscarProceso(String nombre) {
        boolean band = false;

        if (!suspendidos.isEmpty()) {
            for (int i = 0; i < suspendidos.size(); i++) {
                if (suspendidos.get(i).nomProceso.equals(nombre)) {
                    band = true;
                }
            }
        }

        return band;
    }

    public void agregarSuspendidos(Proceso proceso) {

        if (!suspendidos.isEmpty()) {
            for (int i = 0; i < suspendidos.size(); i++) {
                if (buscarProceso(proceso.nomProceso)) {
                    System.out.println("ya está");
                } else {
                    this.suspendidos.add(proceso);

                    System.out.println("Guardó al proceso" + proceso.nomProceso);
                }
            }
        } else {
            this.suspendidos.add(proceso);

            System.out.println("Guardó al proceso" + proceso.nomProceso);
        }

    }

    public int posMenorTiempoSuspendido() {
        float menor = 9999999;
        int pos = 9;

        if (!suspendidos.isEmpty()) {
            for (int i = 0; i < suspendidos.size(); i++) {
                if (suspendidos.get(i).t_cpu < menor) {
                    pos = i;
                    menor = suspendidos.get(i).t_cpu;
                }
            }
        }

        return pos;

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
