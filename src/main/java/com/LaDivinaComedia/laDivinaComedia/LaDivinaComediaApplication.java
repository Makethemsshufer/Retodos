package com.LaDivinaComedia.laDivinaComedia;

import com.LaDivinaComedia.laDivinaComedia.repository.crud.HairProductCrudRepository;
import com.LaDivinaComedia.laDivinaComedia.repository.crud.UsuarioCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaDivinaComediaApplication implements CommandLineRunner{
    
        @Autowired
        private HairProductCrudRepository hairProductCrudRepository;
        @Autowired
        private UsuarioCrudRepository usuarioCrudRepository;

	public static void main(String[] args) {
		SpringApplication.run(LaDivinaComediaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        hairProductCrudRepository.deleteAll();
        usuarioCrudRepository.deleteAll();
    }

}
