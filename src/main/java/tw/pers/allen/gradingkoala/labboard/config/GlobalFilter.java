package tw.pers.allen.gradingkoala.labboard.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class GlobalFilter implements Filter {

    private final List<String> ALLOWED_PREFIXES = List.of(
            "/lab/board", "/lab/admin", "/grading-koala-404.webp", "/favicon.ico",
            "/api"
    );

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String requestURI = req.getRequestURI();
        boolean allowed = ALLOWED_PREFIXES.stream().anyMatch(requestURI::startsWith);

        if (!allowed) {
            resp.sendRedirect("/lab/board");
            return;
        }

        chain.doFilter(req, resp);
    }
}
