package tn.esprit.spring;


import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.spring.service.ClientService;
import tn.esprit.spring.service.FactureService;
import tn.esprit.spring.service.RelanceService;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.Relance;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@SpringBootApplication
@EnableAutoConfiguration
public class ProjetPfeApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjetPfeApplication.class, args);
	}
	@Override
    public void run(String... args) throws Exception {
        System.out.println("this is testing");
    }
}
