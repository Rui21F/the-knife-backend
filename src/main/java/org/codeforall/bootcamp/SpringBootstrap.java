package org.codeforall.bootcamp;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class SpringBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
       String [] profiles = event.getApplicationContext().getEnvironment().getActiveProfiles();

        System.out.println("#### Active profiles: ####");
        for (String profile : profiles) {
            System.out.println("=> " + profile);
        }
    }
}
