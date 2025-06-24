package tw.pers.allen.gradingkoala.labboard.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController implements ErrorController {

    private final Resource ERROR_PAGE = new ClassPathResource("templates/error.html");

    @GetMapping(value = "/lab/{name}", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> serveHtml(@PathVariable String name) {
        String path = "templates/" + name + ".html";
        Resource resource = new ClassPathResource(path);

        return ResponseEntity.ok().body(resource);
    }

    @RequestMapping("/error")
    public ResponseEntity<Resource> handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String requestURI = request.getRequestURI();

        System.out.println("???"+status);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ERROR_PAGE); // fallback generic error page
    }

}
