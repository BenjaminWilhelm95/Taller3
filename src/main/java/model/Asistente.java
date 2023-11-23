package model;
import java.util.ArrayList;
import java.util.List;
public class Asistente {
    private String nombre;
    private String correoElectronico;
    private String numeroTelefono;
    private String preferenciasMusicales;
    private List<EventoMusical> eventosAsistidos;
    private List<Entrada> compras;
    public Asistente(String nombre, String correoElectronico, String numeroTelefono, String preferenciasMusicales) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.preferenciasMusicales = preferenciasMusicales;
        this.eventosAsistidos = new ArrayList<>();
        this.compras = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public String getNumeroTelefono() {
        return numeroTelefono;
    }
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    public String getPreferenciasMusicales() {
        return preferenciasMusicales;
    }
    public void setPreferenciasMusicales(String preferenciasMusicales) {
        this.preferenciasMusicales = preferenciasMusicales;
    }
    public List<EventoMusical> getEventosAsistidos() {
        return eventosAsistidos;
    }
    public void setEventosAsistidos(List<EventoMusical> eventosAsistidos) {
        this.eventosAsistidos = eventosAsistidos;
    }
    public List<Entrada> getCompras() {
        return compras;
    }
    public void setCompras(List<Entrada> compras) {
        this.compras = compras;
    }
    public void comprarEntrada(Entrada entrada, int cantidad) {
        if (entrada.getCantidadDisponible() >= cantidad) {
            for (int i = 0; i < cantidad; i++) {
                compras.add(entrada);
            }
            entrada.comprarEntrada(cantidad);
        } else {
            System.out.println("Lo siento, no hay suficientes entradas disponibles.");
        }
    }
    public void cancelarCompraEntrada(Entrada entrada, int cantidad) {
        if (compras.contains(entrada)) {
            for (int i = 0; i < cantidad; i++) {
                compras.remove(entrada);
            }
            entrada.anularEntrada(cantidad);
        } else {
            System.out.println("No se encontró la compra asociada a la entrada.");
        }
    }
    public void agregarEventoAsistido(EventoMusical evento) {
        eventosAsistidos.add(evento);
    }
    public void eliminarEventoAsistido(EventoMusical evento) {
        eventosAsistidos.remove(evento);
    }
    @Override
    public String toString() {
        return "Asistente{" +
                "nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", preferenciasMusicales='" + preferenciasMusicales + '\'' +
                ", compras=" + compras +
                '}';
    }
}

