package br.com.elasticsearchcluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.elasticsearchcluster.*")
public class ElasticsearchClusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchClusterApplication.class, args);
	}

}
