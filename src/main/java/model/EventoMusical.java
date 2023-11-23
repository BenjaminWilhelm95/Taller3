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
    private List<Entrada> entradas;
    private boolean cancelado;
    public EventoMusical(String nombreEvento, Date fecha, String lugar) {
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.lugar = lugar;
        this.artistas = new ArrayList<>();
        this.asistentes = new ArrayList<>();
        this.entradas = new ArrayList<>();
        this.cancelado = false;
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
    public List<Asistente> getAsistentes() {
        return asistentes;
    }
    public void setAsistentes(List<Asistente> asistentes) {
        this.asistentes = asistentes;
    }
    public List<Entrada> getEntradas() {
        return entradas;
    }
    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }
    public boolean isCancelado() {
        return cancelado;
    }
    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }
    public void agregarAsistente(Asistente asistente) {
        if (!asistentes.contains(asistente)) {
            asistentes.add(asistente);
            asistente.agregarEventoAsistido(this);
        }
    }
    public void eliminarAsistente(Asistente asistente) {
        asistentes.remove(asistente);
        asistente.eliminarEventoAsistido(this);
    }
    public void agregarArtista(Artista artista) {
        if (!artistas.contains(artista)) {
            artistas.add(artista);
            artista.agregarEvento(this);
        }
    }
    public void eliminarArtista(Artista artista) {
        artistas.remove(artista);
        artista.eliminarEvento(this);
    }
    public void agregarEntrada(Entrada entrada) {
        if (!entradas.contains(entrada)) {
            entradas.add(entrada);
            entrada.setEvento(this);
        }
    }
    public void cancelarEvento() {
        for (Entrada entrada : entradas) {
            entrada.anularEntrada(entrada.getCantidadDisponible());
        }
        entradas.clear();
        cancelado = true;
    }
    @Override
    public String toString() {
        return "EventoMusical{" +
                "nombreEvento='" + nombreEvento + '\'' +
                ", fecha=" + fecha +
                ", lugar='" + lugar + '\'' +
                ", artistas=" + artistas +
                ", asistentes=" + asistentes +
                ", entradas=" + entradas +
                ", cancelado=" + cancelado +
                '}';
    }
}