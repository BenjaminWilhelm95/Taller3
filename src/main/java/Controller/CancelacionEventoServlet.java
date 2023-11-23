package Controller;
import model.EventoMusical;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CancelacionEventoServlet")
public class CancelacionEventoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreEvento = request.getParameter("nombreEvento");
        EventoMusical evento = buscarEventoPorNombre(nombreEvento);
        if (evento != null) {
            evento.cancelarEvento();
            response.sendRedirect("confirmacionCancelacion.jsp");
        } else {
            // Manejar el caso en que el evento no se encuentra
            response.sendRedirect("errorCancelacion.jsp");
        }
    }

    private EventoMusical buscarEventoPorNombre(String nombreEvento) {
        return null;
    }
}
