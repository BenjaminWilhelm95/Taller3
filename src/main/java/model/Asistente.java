package model;
import java.util.ArrayList;
import java.util.List;
public class Asistente {
    private String nombre;
    private String correoElectronico;
    private String numeroTelefono;
    private String preferenciasMusicales;
    private List<EventoMusical> eventosAsistidos;

    // Constructor
    public Asistente(String nombre, String correoElectronico, String numeroTelefono, String preferenciasMusicales) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.preferenciasMusicales = preferenciasMusicales;
        this.eventosAsistidos = new ArrayList<>();
    }

    // Métodos de acceso (getters y setters)
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

    // Método para agregar un evento asistido por el asistente
    public void agregarEventoAsistido(EventoMusical evento) {
        if (!eventosAsistidos.contains(evento)) {
            eventosAsistidos.add(evento);
            evento.agregarAsistente(this);
        }
    }

    // Método para eliminar un evento asistido por el asistente
    public void eliminarEventoAsistido(EventoMusical evento) {
        eventosAsistidos.remove(evento);
        evento.eliminarAsistente(this);
    }

    // Método para darse de baja en el sistema
    public void darseDeBaja() {
        // Eliminar la relación con los eventos al darse de baja
        for (EventoMusical evento : eventosAsistidos) {
            evento.eliminarAsistente(this);
        }
        eventosAsistidos.clear();
        // Otras acciones de baja, si es necesario
    }

    // Método toString para obtener una representación de cadena del objeto
    @Override
    public String toString() {
        return "Asistente{" +
                "nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", preferenciasMusicales='" + preferenciasMusicales + '\'' +
                ", eventosAsistidos=" + eventosAsistidos +
                '}';
    }
}
