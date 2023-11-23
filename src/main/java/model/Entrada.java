package model;
public class Entrada {
    public enum TipoEntrada {
        VIP,
        GENERAL
    }
    private TipoEntrada tipo;
    private double precio;
    private int cantidadDisponible;
    public Entrada(TipoEntrada tipo, double precio, int cantidadDisponible) {
        this.tipo = tipo;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    public TipoEntrada getTipo() {
        return tipo;
    }
    public void setTipo(TipoEntrada tipo) {
        this.tipo = tipo;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    public void comprarEntrada() {
        if (cantidadDisponible > 0) {
            cantidadDisponible--;
            System.out.println("Entrada comprada con éxito.");
        } else {
            System.out.println("Lo siento, no hay entradas disponibles de este tipo.");
        }
    }
    @Override
    public String toString() {
        return "Entrada{" +
                "tipo=" + tipo +
                ", precio=" + precio +
                ", cantidadDisponible=" + cantidadDisponible +
                '}';
    }
}
