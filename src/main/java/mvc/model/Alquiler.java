package mvc.model;

import java.util.Date;

public class Alquiler {
    private int numero;
    private Auto auto;
    private Date fechaInicio;
    private Date fechaFin;
    private float montoAlquiler;
    private float kmRecorridos;

    public Alquiler(int numero, Auto auto, Date fechaInicio, Date fechaFin, float montoAlquiler, float kmRecorridos) {
        this.numero = numero;
        this.auto = auto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.montoAlquiler = montoAlquiler;
        this.kmRecorridos = kmRecorridos;
    }

    public int getNumero() {
        return numero;
    }

    public Auto getAuto() {
        return auto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public float getMontoAlquiler() {
        return montoAlquiler;
    }

    public float getKmRecorridos() {
        return kmRecorridos;
    }
}

