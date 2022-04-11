/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Eleana Hurtado
 */
public class Proceso {
    protected String nomProceso;
    protected float t_llegada;
    protected float t_cpu;
    protected float prioridad;
    protected float t_comienzo;
    protected float t_fin;
    protected float t_espera;

    public Proceso(String nomProceso, float t_llegada, float t_cpu, float prioridad, float t_comienzo, float t_fin, float t_espera) {
        this.nomProceso = nomProceso;
        this.t_llegada = t_llegada;
        this.t_cpu = t_cpu;
        this.prioridad = prioridad;
        this.t_comienzo = t_comienzo;
        this.t_fin = t_fin;
        this.t_espera = t_espera;
    }

    
    public String getNomProceso() {
        return nomProceso;
    }

    public float getT_llegada() {
        return t_llegada;
    }

    public float getT_cpu() {
        return t_cpu;
    }

    public float getPrioridad() {
        return prioridad;
    }

    public float getT_comienzo() {
        return t_comienzo;
    }

    public float getT_fin() {
        return t_fin;
    }

    public float getT_espera() {
        return t_espera;
    }

    public void setNomProceso(String nomProceso) {
        this.nomProceso = nomProceso;
    }

    public void setT_llegada(float t_llegada) {
        this.t_llegada = t_llegada;
    }

    public void setT_cpu(float t_cpu) {
        this.t_cpu = t_cpu;
    }

    public void setPrioridad(float prioridad) {
        this.prioridad = prioridad;
    }

    public void setT_comienzo(float t_comienzo) {
        this.t_comienzo = t_comienzo;
    }

    public void setT_fin(float t_fin) {
        this.t_fin = t_fin;
    }

    public void setT_espera(float t_espera) {
        this.t_espera = t_espera;
    }

    @Override
    public String toString() {
        return "Proceso{" + "nomProceso=" + nomProceso + ", t_llegada=" + t_llegada + ", t_cpu=" + t_cpu + ", prioridad=" + prioridad + ", t_comienzo=" + t_comienzo + ", t_fin=" + t_fin + ", t_espera=" + t_espera + '}';
    }
    
    
     
    
}
