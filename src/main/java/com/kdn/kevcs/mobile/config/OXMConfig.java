package com.kdn.kevcs.mobile.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.bind.Marshaller;

@Configuration
public class OXMConfig {

    @Value("${spring.oxm.package.name}")
    private String entityPackageName;

    @Bean
    public Jaxb2Marshaller getJaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setLazyInit(true);
        // jaxb2Marshaller.setClassesToBeBound(String.class);
        jaxb2Marshaller.setPackagesToScan(entityPackageName);
        Map<String,Object> map = new HashMap<String,Object>();
        // To disable standalone attribute
        // map.put(Marshaller.JAXB_ENCODING, "UTF-8");
        // map.put(Marshaller., "<?xml version=\"1.0\"?>");
        map.put(Marshaller.JAXB_FRAGMENT, false);
        // end of standalone attribute config
        map.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxb2Marshaller.setMarshallerProperties(map);
        return jaxb2Marshaller;
    }
}
