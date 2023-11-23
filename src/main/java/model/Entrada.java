package model;
public class Entrada {
    public enum TipoEntrada {
        VIP,
        GENERAL
    }
    private TipoEntrada tipo;
    private double precio;
    private int cantidadDisponible;
    private EventoMusical evento;  // Nueva relación con EventoMusical

    // Constructor
    public Entrada(TipoEntrada tipo, double precio, int cantidadDisponible, EventoMusical evento) {
        this.tipo = tipo;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.evento = evento;
    }

    // Métodos de acceso (getters y setters)
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

    public EventoMusical getEvento() {
        return evento;
    }

    public void setEvento(EventoMusical evento) {
        this.evento = evento;
    }

    // Método para comprar una entrada
    public void comprarEntrada(int cantidad) {
        if (cantidadDisponible >= cantidad) {
            cantidadDisponible -= cantidad;
            System.out.println(cantidad + " entradas compradas con éxito.");
        } else {
            System.out.println("Lo siento, no hay suficientes entradas disponibles.");
        }
    }

    // Método para anular una entrada
    public void anularEntrada(int cantidad) {
        cantidadDisponible += cantidad;
        System.out.println(cantidad + " entradas anuladas con éxito.");
    }

    // Otros métodos relevantes

    // Método toString para obtener una representación de cadena del objeto
    @Override
    public String toString() {
        return "Entrada{" +
                "tipo=" + tipo +
                ", precio=" + precio +
                ", cantidadDisponible=" + cantidadDisponible +
                ", evento=" + evento.getNombreEvento() +
                '}';
    }
}