package tw.pers.allen.gradingkoala.labboard.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tw.pers.allen.gradingkoala.labboard.service.DefaultAvatarService;

@Component
public class Initialize implements ApplicationListener<ContextRefreshedEvent> {

    private final DefaultAvatarService defaultAvatarService;

    public Initialize(DefaultAvatarService defaultAvatarService) {
        this.defaultAvatarService = defaultAvatarService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (defaultAvatarService.isTableNonEmpty()) {
            return;
        }

        defaultAvatarService.readAndCreateAvatars();
    }
}
