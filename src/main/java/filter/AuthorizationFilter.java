package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        //HttpServletRequest request = (HttpServletRequest) req;
        //HttpServletResponse response = (HttpServletResponse) resp;
        //
        //String authToken = request.getHeader("Authorization");
        //if(!OAuthUtil.validate(authToken)) {
        //    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        //    return;
        //}
        //
        //filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
