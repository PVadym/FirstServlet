package offline;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Вадим on 03.04.2017.
 */
@WebServlet(name = "HelloWorldServlet",loadOnStartup = 1,urlPatterns = "/helloOffline")
public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        System.out.println("session" + session.getId() +":" + session.getCreationTime());

        String name = request.getParameter("name");

        response.setStatus(HttpServletResponse.SC_OK);
        try (OutputStream outputStream = response.getOutputStream()){
            outputStream.write(("Hello" + name).getBytes());
            outputStream.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
