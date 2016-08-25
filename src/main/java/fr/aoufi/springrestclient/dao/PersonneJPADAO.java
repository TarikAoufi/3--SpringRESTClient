package fr.aoufi.springrestclient.dao;

import javax.persistence.EntityManager;
import fr.aoufi.springrestclient.model.Personne;

public class PersonneJPADAO implements PersonneDAO {
	
	private EntityManager em;
	
	public Personne save(Personne personne) {
		em.persist(personne);
		return personne;
	}

	public EntityManager getEm() {
		return em;
	}
	
	//@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}
		
}
