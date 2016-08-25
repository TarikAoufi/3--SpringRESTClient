package fr.aoufi.springrestclient.dao;

import fr.aoufi.springrestclient.model.Personne;

public class PersonneJDBCDAO implements PersonneDAO {

	public Personne save(Personne personne) {
		System.out.println("Méthode JDBC");
		return null;
	}
}
