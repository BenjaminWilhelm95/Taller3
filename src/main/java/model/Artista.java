package model;
public class Artista {
    private String nombreArtistico;
    private String generoMusical;
    public Artista(String nombreArtistico, String generoMusical) {
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
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
    @Override
    public String toString() {
        return "Artista{" +
                "nombreArtistico='" + nombreArtistico + '\'' +
                ", generoMusical='" + generoMusical + '\'' +
                '}';
    }
}
