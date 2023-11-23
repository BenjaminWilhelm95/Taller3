package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventoMusical {
    private String nombreEvento;
    private Date fecha;
    private String lugar;
    private List<Artista> artistas;
    private List<Asistente> asistentes;

    // Constructor
    public EventoMusical(String nombreEvento, Date fecha, String lugar) {
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.lugar = lugar;
        this.artistas = new ArrayList<>();
        this.asistentes = new ArrayList<>();
    }

    // Métodos de acceso (getters y setters)
    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    public List<Asistente> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(List<Asistente> asistentes) {
        this.asistentes = asistentes;
    }

    // Método para agregar un artista al evento
    public void agregarArtista(Artista artista) {
        if (!artistas.contains(artista)) {
            artistas.add(artista);
            artista.agregarEvento(this);
        }
    }

    // Método para eliminar un artista del evento
    public void eliminarArtista(Artista artista) {
        artistas.remove(artista);
        artista.eliminarEvento(this);
    }

    // Método para agregar un asistente al evento
    public void agregarAsistente(Asistente asistente) {
        if (!asistentes.contains(asistente)) {
            asistentes.add(asistente);
            asistente.agregarEventoAsistido(this);
        }
    }

    // Método para eliminar un asistente del evento
    public void eliminarAsistente(Asistente asistente) {
        asistentes.remove(asistente);
        asistente.eliminarEventoAsistido(this);
    }

    // Otros métodos relevantes

    // Método toString para obtener una representación de cadena del objeto
    @Override
    public String toString() {
        return "EventoMusical{" +
                "nombreEvento='" + nombreEvento + '\'' +
                ", fecha=" + fecha +
                ", lugar='" + lugar + '\'' +
                ", artistas=" + artistas +
                ", asistentes=" + asistentes +
                '}';
    }
}
