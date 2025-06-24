package tw.pers.allen.gradingkoala.labboard.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;
import tw.pers.allen.gradingkoala.labboard.model.entity.DefaultAvatar;
import tw.pers.allen.gradingkoala.labboard.repository.DefaultAvatarRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultAvatarService {

    private final DefaultAvatarRepository defaultAvatarRepository;

    public DefaultAvatarService(DefaultAvatarRepository defaultAvatarRepository) {
        this.defaultAvatarRepository = defaultAvatarRepository;
    }

    public boolean isTableNonEmpty() {
        return defaultAvatarRepository.count() != 0;
    }

    public void readAndCreateAvatars() {
        try {
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources("classpath:/default_avatar/*");

            List<DefaultAvatar> defaultAvatars = new ArrayList<>();
            for (Resource r : resources) {
                DefaultAvatar da = new DefaultAvatar().setName(r.getFilename()).setContent(r.getContentAsByteArray());
                defaultAvatars.add(da);
            }

            defaultAvatarRepository.saveAll(defaultAvatars);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
