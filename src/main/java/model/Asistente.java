package model;
public class Asistente {
    private String nombre;
    private String correoElectronico;
    private String numeroTelefono;
    private String preferenciasMusicales;
    public Asistente(String nombre, String correoElectronico, String numeroTelefono, String preferenciasMusicales) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.preferenciasMusicales = preferenciasMusicales;
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
    @Override
    public String toString() {
        return "Asistente{" +
                "nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", preferenciasMusicales='" + preferenciasMusicales + '\'' +
                '}';
    }
}
