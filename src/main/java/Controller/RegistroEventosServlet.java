package Controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EventoMusical;
@WebServlet("/RegistroEventosServlet")
public class RegistroEventosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreEvento = request.getParameter("nombreEvento");
        String fechaStr = request.getParameter("fecha");
        String lugar = request.getParameter("lugar");
        Date fecha = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fecha = sdf.parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        EventoMusical evento = new EventoMusical(nombreEvento, fecha, lugar);
        response.sendRedirect("PaginaConfirmacion.jsp");
    }
}
