package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet")
public class Sesiones extends HttpServlet {
    //Sobreescribimos el metodo doGet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //Creamos la sesion
        HttpSession session = req.getSession();
        //Creamos una Variable de tipo String
        String titulo = null;
        Integer contadorVisitas = (Integer) session.getAttribute("contadorVisitas");
        //Evaluamos con una condicion si es la
        //primera ve que ingresa a la app
        if (contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido a mi aplicacion por Primera vez";
        }else{
            contadorVisitas=contadorVisitas+1;
            titulo = "Bienvenido a mi aplicacion nuevamente";
        }
        //seteamos o agragamos los nuevos valores de la sesion
        session.setAttribute("contadorVisitas", contadorVisitas);
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Manejo de Sesiones</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + titulo + "</h1>");
        out.println("<h1>" + contadorVisitas+ "</h1>");
        out.println("</body>");
        out.println("</html>");


    }
}
