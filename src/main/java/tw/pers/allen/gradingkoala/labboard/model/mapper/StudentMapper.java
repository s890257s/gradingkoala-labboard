package tw.pers.allen.gradingkoala.labboard.model.mapper;


import org.springframework.beans.BeanUtils;
import tw.pers.allen.gradingkoala.labboard.model.dto.StudentDto;
import tw.pers.allen.gradingkoala.labboard.model.entity.Student;

public class StudentMapper {

    public static StudentDto toDto(Student entity) {
        StudentDto dto = new StudentDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
