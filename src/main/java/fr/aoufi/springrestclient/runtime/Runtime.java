package fr.aoufi.springrestclient.runtime;


import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import fr.aoufi.springrestclient.model.Personne;


public class Runtime {

	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Personne[]> entity = restTemplate.getForEntity("http://localhost:8085/springwebmvc/personnes", Personne[].class);
		System.out.println(Arrays.deepToString(entity.getBody()));		
		
//		ResponseEntity<Personne> entity = restTemplate.getForEntity("http://localhost:8080/springwebmvc/personnes/6", Personne.class);
//		System.out.println(entity.getBody());
		
	}

}
