package com.kdn.kevcs.mobile.web.config;

import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.reflect.ClassPath;
import lombok.extern.log4j.Log4j2;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import java.io.IOException;

@Profile("web")
@Log4j2
@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    @Value("${spring.jersey.resource.package}")
    private String resourcePackageName;

    public JerseyConfig() {

    }

    @PostConstruct
    public void configure() {

        final ClassLoader loader = Thread.currentThread().getContextClassLoader();

        try {
            UnmodifiableIterator<ClassPath.ClassInfo> cls = ClassPath.from(loader).getTopLevelClasses(resourcePackageName).iterator();
            while(cls.hasNext()) { this.registerClazz(cls.next()); }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registerClazz(final ClassPath.ClassInfo clazzInfo) {
        try {
            register(Class.forName(clazzInfo.getName()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

