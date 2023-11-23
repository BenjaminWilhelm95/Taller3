package Controller;
import model.Entrada;
import model.EventoMusical;
import model.Asistente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VentaEntradasServlet")
public class VentaEntradasServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreAsistente = request.getParameter("nombre");
        String correoAsistente = request.getParameter("correo");
        String eventoSeleccionado = request.getParameter("evento");
        String tipoEntrada = request.getParameter("tipoEntrada");
        double precioEntrada = Double.parseDouble(request.getParameter("precioEntrada"));
        int cantidadEntradas = Integer.parseInt(request.getParameter("cantidadEntradas"));
        EventoMusical evento = buscarEventoPorNombre(eventoSeleccionado);
        Asistente asistente = new Asistente(nombreAsistente, correoAsistente, "123456789", "Rock");
        if (evento != null) {
            Entrada entrada = new Entrada(Entrada.TipoEntrada.valueOf(tipoEntrada), precioEntrada, cantidadEntradas, evento);
            asistente.comprarEntrada(entrada, cantidadEntradas);
        } else {
            System.out.println("Evento no encontrado.");
        }
        response.sendRedirect("paginaDeConfirmacion.jsp");
    }
    private EventoMusical buscarEventoPorNombre(String nombreEvento) {
        return null;
    }
}
