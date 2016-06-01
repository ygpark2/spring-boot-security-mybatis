package com.kdn.kevcs.mobile;

// import de.codecentric.boot.admin.config.EnableAdminServer;
// import com.kdn.kevcs.mobile.data.mybatis.repository.config.EnableMyBatisRepositories;

import com.kdn.kevcs.mobile.repository.UserRepository;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication // (exclude = SecurityAutoConfiguration.class)
// @EnableAdminServer
@MapperScan(basePackages="com.kdn.kevcs.mobile.repository")
// @EnableWebMvc
public class Application {

    @Inject
    private UserRepository userRepo;

    public static void main(String[] args) {

        // List<Class<?>> classes = ClassFinder.find("com.package");

        SpringApplication.run(Application.class, args);
        // AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    }

    @PostConstruct
    private void test() {
        System.out.println("================================================");
        System.out.println(userRepo.findByUsername("kepco"));
        System.out.println("================================================");
    }
}
