package logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Algoritmo {

    public ArrayList<Proceso> suspendidos = new ArrayList();

    public void reinicio(Proceso[] procesos) {

        for (int i = 0; i < procesos.length; i++) {
            procesos[i].setT_comienzo(0);
            procesos[i].setT_fin(0);
            procesos[i].setT_espera(0);
        }
    }

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
        this.reinicio(procesos);
        this.ordenar(procesos);
        ArrayList<Proceso> terminados = new ArrayList<Proceso>();
        float aux = 0;
        float tiempo = procesos[0].t_llegada;
        ArrayList<Integer> tamSus = new ArrayList<Integer>();
        //copia de seguridad de los tiempos de cpu
        float[] tiempos = new float[procesos.length];
        float[] cpu = new float[procesos.length];
        for(int i=0; i<cpu.length; i++){
            cpu[i] = procesos[i].getT_cpu();
        }
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
                        if (procesos[llegados].getNomProceso() != procesos[i].getNomProceso() && procesos[llegados].t_cpu != 0 && procesos[llegados].t_llegada <= tiempo && !buscarProceso(procesos[llegados].nomProceso) && procesos[llegados].prioridad >= procesos[i].prioridad) {
                            agregarSuspendidos(procesos[llegados]);
                            System.out.println("Llego " + procesos[llegados]);
                        }
                    }

                    if (procesos[i].t_llegada <= tiempo && procesos[i].t_cpu > 0) {

                        System.out.println("El proceso " + procesos[i].nomProceso + " se esta ejecutando en " + tiempo);
                        procesos[i].t_cpu--;
                        aux--;
                        tiempo++;
                    }
                    if (procesos[i].t_cpu == 0) {

                        System.out.println("El proceso " + procesos[i].nomProceso + " se termino en " + tiempo);
                        terminados.add(procesos[i]);

                        procesos[i].setT_fin(tiempo);
                        procesos[i].setT_comienzo(procesos[i].getT_comienzo() + (procesos[i].getT_fin() - tiempos[i]));
                        procesos[i].setT_espera(procesos[i].getT_espera() + (procesos[i].getT_comienzo() - procesos[i].getT_llegada()));

                        if (tiempo == totalTiempo - 1) {
                            procesos[i].setT_fin(tiempo + 1);
                            procesos[i].setT_comienzo(procesos[i].getT_fin() - tiempos[i]);
                        }
                        for (int k = 0; k < procesos.length; k++) {
                            if (procesos[k].t_llegada == tiempo && procesos[k].prioridad < procesos[i].prioridad) {
                                i = k;
                            }
                        }
                        if (!suspendidos.isEmpty()) {
                            int menor = posMenorTiempoSuspendidoPrioridad();
                            if (i < procesos.length-1 && menor != 9 && suspendidos.get(menor).prioridad <= procesos[i+1].prioridad && suspendidos.get(menor).t_llegada < procesos[i+1].t_llegada) {
                                for (int z = 0; z < procesos.length; z++) {
                                    if (procesos[z].getNomProceso() == suspendidos.get(menor).getNomProceso()) {
                                        i = z;
                                        System.out.println("Entro Suspendido " + procesos[i]);
                                        System.out.println("este es menor"+suspendidos.get(menor));
                                        break;
                                    }
                                }
                            }
                        }

                    } else if (i < procesos.length - 1 && procesos[i + 1].prioridad < procesos[i].prioridad && procesos[i + 1].t_cpu != 0 && procesos[i + 1].t_llegada < tiempo + 1) {
                        System.out.println("El proceso " + procesos[i].nomProceso + " se suspendio en " + tiempo);
                        agregarSuspendidos(procesos[i]);
                        procesos[i].setT_espera(procesos[i].getT_espera() + (procesos[i].getT_comienzo() - procesos[i].getT_llegada()));
                        tamSus.add(i);
                        tiempos[i] = procesos[i].getT_cpu() + 1;
                        if (i == 0) {
                            procesos[i].setT_comienzo(1);
                        }
                         if (!suspendidos.isEmpty()) {
                            int menor = posMenorTiempoSuspendidoPrioridad();
                            if (i < procesos.length-1 && menor != 9 && suspendidos.get(menor).prioridad <= procesos[i+1].prioridad && suspendidos.get(menor).t_llegada < procesos[i+1].t_llegada) {
                                for (int z = 0; z < procesos.length; z++) {
                                    if (procesos[z].getNomProceso() == suspendidos.get(menor).getNomProceso()) {
                                        i = z;
                                        System.out.println("Entro Suspendido " + procesos[i]);
                                        
                                        break;
                                    }
                                }
                            }
                            else{
                                i++;
                            }
                        }
                        
                        //i++;
                        //tiempo++;

                    }
                }
            }
        }

        System.out.println("");
        for (int x = 0; x < procesos.length; x++) {
            procesos[x].t_cpu = tiempos[x];
            System.out.println(procesos[x].toString());
        }
        for(int i=0; i<cpu.length; i++){
            procesos[i].setT_cpu(cpu[i]);
        }
        if (!suspendidos.isEmpty()) {
            suspendidos.clear();
        }

    }

    public int posMenorTiempoSuspendidoPrioridad() {
        float menor = 999999999;
        int pos = 9;
        
        if (!suspendidos.isEmpty()) {
            for (int i = 0; i < suspendidos.size(); i++) {
                for (int j = 0; j < suspendidos.size(); j++) {
                    if (suspendidos.get(i).prioridad < menor && suspendidos.get(j).prioridad>=suspendidos.get(i).prioridad && suspendidos.get(i).getT_cpu()!=0) {
                        pos = i;
                        menor = suspendidos.get(i).prioridad;

                    }
                }

            }
        }

        return pos;

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
        this.reinicio(procesos);
        this.ordenar(procesos);
        ArrayList<Proceso> terminados = new ArrayList<Proceso>();
        float aux = 0;
        float tiempo = procesos[0].t_llegada;
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
                        if (procesos[llegados].getNomProceso() != procesos[i].getNomProceso() && procesos[llegados].t_cpu != 0 && procesos[llegados].t_llegada <= tiempo && !buscarProceso(procesos[llegados].nomProceso) && procesos[llegados].t_cpu > procesos[i].t_cpu) {
                            agregarSuspendidos(procesos[llegados]);
                        }
                    }

                    if (procesos[i].t_llegada <= tiempo && procesos[i].t_cpu > 0) {

                        System.out.println("El proceso " + procesos[i].nomProceso + " se esta ejecutando en " + tiempo);
                        procesos[i].t_cpu--;
                        aux--;
                        tiempo++;
                    }
                    if (procesos[i].t_cpu == 0) {

                        System.out.println("El proceso " + procesos[i].nomProceso + " se termino en " + tiempo);
                        terminados.add(procesos[i]);

                        procesos[i].setT_fin(tiempo);
                        procesos[i].setT_comienzo(procesos[i].getT_comienzo() + (procesos[i].getT_fin() - tiempos[i]));
                        procesos[i].setT_espera(procesos[i].getT_espera() + (procesos[i].getT_comienzo() - procesos[i].getT_llegada()));

                        if (tiempo == totalTiempo - 1) {
                            procesos[i].setT_fin(tiempo + 1);
                            procesos[i].setT_comienzo(procesos[i].getT_fin() - tiempos[i]);
                        }
                        if (!suspendidos.isEmpty()) {
                            int menor = posMenorTiempoSuspendido();
                            if (i < procesos.length - 1 && menor != 9 && suspendidos.get(menor).t_cpu < procesos[i + 1].t_cpu) {
                                for (int z = 0; z < procesos.length; z++) {
                                    if (procesos[z].getNomProceso() == suspendidos.get(menor).getNomProceso()) {
                                        i = z;
                                        break;
                                    }
                                }
                            }
                        }

                    } else if (i < procesos.length - 1 && procesos[i + 1].t_cpu < procesos[i].t_cpu && procesos[i + 1].t_cpu != 0 && procesos[i + 1].t_llegada < tiempo + 1) {
                        System.out.println("El proceso " + procesos[i].nomProceso + " se suspendio en " + tiempo);
                        agregarSuspendidos(procesos[i]);
                        procesos[i].setT_espera(procesos[i].getT_espera() + (procesos[i].getT_comienzo() - procesos[i].getT_llegada()));
                        tamSus.add(i);
                        tiempos[i] = procesos[i].getT_cpu() + 1;
                        if (i == 0) {
                            procesos[i].setT_comienzo(1);
                            procesos[i].setT_espera(procesos[i].getT_espera()-1);
                        }
                        i++;
                        //tiempo++;

                    }
                }
            }
        }

        System.out.println("");
        for (int x = 0; x < procesos.length; x++) {
            procesos[x].t_cpu = tiempos[x];
            System.out.println(procesos[x].toString());
        }
        

        if (!suspendidos.isEmpty()) {
            suspendidos.clear();
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

                    System.out.println("Guardó al proceso " + proceso.nomProceso);
                }
            }
        } else {
            this.suspendidos.add(proceso);

            System.out.println("Guardó al proceso " + proceso.nomProceso);
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
