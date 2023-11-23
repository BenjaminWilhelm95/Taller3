package Controller;
import model.Asistente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistroAsistenteServlet")
public class RegistroAsistenteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreAsistente = request.getParameter("nombre");
        String correoAsistente = request.getParameter("correo");
        String numeroTelefono = request.getParameter("telefono");
        String preferenciasMusicales = request.getParameter("preferenciasMusicales");
        Asistente asistente = new Asistente(nombreAsistente, correoAsistente, numeroTelefono, preferenciasMusicales);
        response.sendRedirect("confirmacionAsistente.jsp");
    }
}
