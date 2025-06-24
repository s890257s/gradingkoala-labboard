package tw.pers.allen.gradingkoala.labboard.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer defaultAvatarId;
    private String classId;
    private String name;

    @Lob
    private byte[] avatar;

}
