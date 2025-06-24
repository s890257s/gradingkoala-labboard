package tw.pers.allen.gradingkoala.labboard.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class LabSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer labId;
    private Integer studentId;
    private LocalDate createdAt;

    @Lob
    private byte[] screenshot;

    @ColumnDefault("false")
    private Boolean isIncomplete = false;

}
