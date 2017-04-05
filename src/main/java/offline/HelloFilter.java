package offline;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Вадим on 03.04.2017.
 */
@WebFilter(filterName = "HelloFilter",urlPatterns = "/helloOffline")
public class HelloFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        String name = req.getParameter("name");
        if(name==null||name.isEmpty()){
            ((HttpServletResponse) resp).sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
