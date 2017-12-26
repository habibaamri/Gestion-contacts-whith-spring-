package org.isi;

import org.isi.dao.ContactReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringTestApplication1 implements CommandLineRunner {

	
	@Autowired
	ContactReposetory contactReposetory;
	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class, args);
	}
	@Override
	public void run(String... arg0) throws Exception {
		
		contactReposetory.findAll().forEach(c->{
			System.out.println(c.getNom()+""+c.getPrenom());
		}
		);
	}
	

}
