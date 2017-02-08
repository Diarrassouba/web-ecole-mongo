package ci.kossovo.ecole.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ci.kossovo.ecole.entity.Personne;

public interface PersonneRepository extends MongoRepository<Personne, String> {

	List<Personne> findByNomCompletContainingIgnoreCase(String mc);

	List<Personne> findByNomIgnoreCase(String nom);

	List<Personne> findByNomIgnoreCaseAndPrenomIgnoreCase(String nom, String prenom);

	List<Personne> findByTypeAndNomAndPrenom(String type, String nom, String prenom);

	Personne findByNumCni(String numcni);
}
