package mvc.dto;

public class AutoDTO {
    private String patente;
    private String modelo;
    private int capacidad;
    private float precioPorKm;
    private Float precioAdicional;

    public AutoDTO(String patente, String modelo, int capacidad, float precioPorKm,  Float precioAdicional) {
        this.patente = patente;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.precioPorKm = precioPorKm;
        this.precioAdicional = precioAdicional;
    }

    public AutoDTO(String patente, String modelo, int capacidad, float precioPorKm) {
        this.patente = patente;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.precioPorKm = precioPorKm;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public float getPrecioPorKm() {
        return precioPorKm;
    }

    public void setPrecioPorKm(float precioPorKm) {
        this.precioPorKm = precioPorKm;
    }

    public Float getPrecioAdicional() {
        return precioAdicional;
    }

    public void setPrecioAdicional(Float precioAdicional) {
        this.precioAdicional = precioAdicional;
    }

    @Override
    public String toString() {
        return "AutoDTO{" +
                "patente='" + patente + '\'' +
                ", modelo='" + modelo + '\'' +
                ", capacidad=" + capacidad +
                ", precioPorKm=" + precioPorKm +
                ", precioAdicional=" + precioAdicional  +
                '}';
    }
}
