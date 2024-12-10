package mvc.model;

public class AutoDeportivo extends Auto {
    private float precioAdicional;

    public AutoDeportivo(String patente, String modelo, int capacidad, float precioPorKm, float precioAdicional) {
        super(patente, modelo, capacidad, precioPorKm);
        this.precioAdicional = precioAdicional;
    }

    public float getPrecioAdicional() {
        return precioAdicional;
    }

    @Override
    public float calcularMonto(int km) {
        return (super.getPrecioPorKm() + precioAdicional) * km;
    }


}
