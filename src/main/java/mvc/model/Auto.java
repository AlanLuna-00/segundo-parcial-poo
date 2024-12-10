package mvc.model;

public abstract class Auto {
    private String patente;
    private String modelo;
    private int capacidad;
    private float precioPorKm;

    public Auto(String patente, String modelo, int capacidad, float precioPorKm) {
        this.patente = patente;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.precioPorKm = precioPorKm;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public float getPrecioPorKm() {
        return precioPorKm;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPatente() {
        return patente;
    }

    public abstract float calcularMonto(int km);
}
