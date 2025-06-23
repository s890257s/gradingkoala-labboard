package tw.pers.allen.gradingkoala.labboard.service;

import org.springframework.stereotype.Service;
import tw.pers.allen.gradingkoala.labboard.model.dto.StudentDto;
import tw.pers.allen.gradingkoala.labboard.model.mapper.StudentMapper;
import tw.pers.allen.gradingkoala.labboard.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getAll() {
        return studentRepository.findAll().stream().map(StudentMapper::toDto).toList();
    }

}
