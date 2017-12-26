package org.isi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.isi.dao.ContactReposetory;
import org.isi.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTestApplication implements CommandLineRunner {

	@Autowired
	private ContactReposetory contactReposetory;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		DateFormat  df=new SimpleDateFormat("dd/MM/yy");
		//contactReposetory.save(new Contact("amri","nada",df.parse("12/12/1235"),"x"));	
		contactReposetory.findAll().forEach(c->{
			System.out.println(c.getNom()+"**"+c.getPrenom());
		});
	}
}
