package logica;

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

        // Algoritmo.ordenar(procesos);

        for (Proceso proceso : procesos) {

        }

    }
}
