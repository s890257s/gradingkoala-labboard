package tw.pers.allen.gradingkoala.labboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.pers.allen.gradingkoala.labboard.model.dto.StudentDto;
import tw.pers.allen.gradingkoala.labboard.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<StudentDto> getAll() {
        return studentService.getAll();
    }
}
