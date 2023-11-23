package model;
import java.util.ArrayList;
import java.util.List;
public class Artista {
    private String nombreArtistico;
    private String generoMusical;
    private List<EventoMusical> eventos;
    public Artista(String nombreArtistico, String generoMusical) {
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.eventos = new ArrayList<>();
    }
    public String getNombreArtistico() {
        return nombreArtistico;
    }
    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }
    public String getGeneroMusical() {
        return generoMusical;
    }
    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }
    public List<EventoMusical> getEventos() {
        return eventos;
    }
    public void setEventos(List<EventoMusical> eventos) {
        this.eventos = eventos;
    }
    public void agregarEvento(EventoMusical evento) {
        if (!eventos.contains(evento)) {
            eventos.add(evento);
            evento.agregarArtista(this);
        }
    }
    public void eliminarEvento(EventoMusical evento) {
        eventos.remove(evento);
        evento.getArtistas().remove(this);
    }
    @Override
    public String toString() {
        return "Artista{" +
                "nombreArtistico='" + nombreArtistico + '\'' +
                ", generoMusical='" + generoMusical + '\'' +
                ", eventos=" + eventos +
                '}';
    }
}
