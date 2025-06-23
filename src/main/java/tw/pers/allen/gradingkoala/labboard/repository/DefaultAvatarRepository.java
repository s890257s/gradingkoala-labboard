package tw.pers.allen.gradingkoala.labboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.pers.allen.gradingkoala.labboard.model.entity.DefaultAvatar;

public interface DefaultAvatarRepository extends JpaRepository<DefaultAvatar, Integer> {
}
