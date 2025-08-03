package tw.pers.allen.gradingkoala.labboard.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController implements ErrorController {
    @GetMapping(value = "/lab/{name}", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> serveHtml(@PathVariable String name) {
        String path = "templates/" + name + ".html";
        Resource resource = new ClassPathResource(path);
        return ResponseEntity.ok().body(resource);
    }
}
