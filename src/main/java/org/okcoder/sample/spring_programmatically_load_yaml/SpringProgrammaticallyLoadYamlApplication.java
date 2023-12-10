package org.okcoder.sample.spring_programmatically_load_yaml;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Properties;

@SpringBootApplication
public class SpringProgrammaticallyLoadYamlApplication {

	public static void main(String[] args) {
		System.out.println(loadYaml(new ClassPathResource("test1.yaml"), "test1"));
		System.out.println(loadYaml(new ClassPathResource("test2.yaml"), "test2"));
		//SpringApplication.run(SpringProgrammaticallyLoadYamlApplication.class, args);
	}


	private static TestConfig loadYaml(Resource resource, String prefix) {
		YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
		yaml.setResources(resource);
		Properties properties = yaml.getObject();
		ConfigurationPropertySource propertySource= new MapConfigurationPropertySource(properties);
		Binder binder = new Binder(propertySource);
        BindResult<TestConfig> result =  binder.bind(prefix, TestConfig.class);
		return result.get();
	}

}
