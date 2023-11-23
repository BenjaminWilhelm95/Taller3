package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class EventoMusical {
    private String nombreEvento;
    private Date fecha;
    private String lugar;
    private List<Artista> artistas;
    public EventoMusical(String nombreEvento, Date fecha, String lugar) {
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.lugar = lugar;
        this.artistas = new ArrayList<>();
    }
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
    public void agregarArtista(Artista artista) {
        this.artistas.add(artista);
    }
    @Override
    public String toString() {
        return "EventoMusical{" +
                "nombreEvento='" + nombreEvento + '\'' +
                ", fecha=" + fecha +
                ", lugar='" + lugar + '\'' +
                ", artistas=" + artistas +
                '}';
    }
}
