package ci.kossovo.ecole.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import ci.kossovo.ecole.entity.Administrateur;
import ci.kossovo.ecole.entity.Enseignant;
import ci.kossovo.ecole.entity.Etudiant;
import ci.kossovo.ecole.entity.Matiere;
import ci.kossovo.ecole.entity.Personne;

@RunWith(SpringRunner.class)
@DataMongoTest
public class PersonneTest {
	
	@Autowired
	PersonneRepository personneRepository;
	
	  @Before
	    public void setUp() {

	        personneRepository.deleteAll();

	        
	    }

	@Test
	public void findByType() {
		personneRepository.save(new Enseignant("Mme", "Koné", "Asta", "Active"));
		personneRepository.save(new Personne("Mme", "Koné", "Asta"));
		personneRepository.save(new Etudiant("Mme", "Diabaté", "Mawa", "E00102"));
		personneRepository.save(new Administrateur("Mme", "Bamba", "Asta", "Directeur"));

		List<Personne> ps = personneRepository.findAllBy().filter(
				p -> p.getClass().equals(Personne.class)
				).collect(Collectors.toList());
		
		assertThat(ps.size()).isEqualTo(1);

		List<Personne> ps1 = personneRepository.findAllBy().filter(
				p-> p.getClass().equals(Etudiant.class)
				).collect(Collectors.toList());
		Etudiant e=(Etudiant) ps1.get(0);
		assertThat(ps1.size()).isEqualTo(1);
		assertThat(e.getMatricule()).isEqualTo("E00102");
		

		List<Personne> ps2 = personneRepository.findAllBy().filter(
				p->p.getClass().equals(Enseignant.class)
				).collect(Collectors.toList());
		Enseignant en=(Enseignant) ps2.get(0);
		assertThat(ps2.size()).isEqualTo(1);
		assertThat(en.getStatus()).isEqualTo("Active");

		List<Personne> ps3 = personneRepository.findAllBy().filter(
				p->p.getClass().equals(Administrateur.class)
				).collect(Collectors.toList());
		assertThat(ps3.size()).isEqualTo(1);

		List<Personne> pes4 = personneRepository.findAllBy().filter(
				p-> p.getClass().equals(Matiere.class)
				).collect(Collectors.toList());
		assertThat(pes4.size()).isEqualTo(0);

	}

	

	
	@Test
	public void findAllEtudiant() {
		personneRepository.save(new Personne("Mme", "Koné", "Asta"));
		personneRepository.save(new Etudiant("Mme", "Diabaté", "Mawa", "E00102"));
		personneRepository.save(new Enseignant("Mme", "Koné", "Asta", "Active"));
		List<Personne> ets = personneRepository.findAllBy().filter(
				p-> p.getClass().equals(Etudiant.class)
				).collect(Collectors.toList());
		
		assertThat(ets.size()).isEqualTo(1);

	}
	
	
	@Test
	public void deleteAll() {
		personneRepository.save(new Personne("Mme", "Koné", "Asta"));
		personneRepository.save(new Etudiant("Mme", "Diabaté", "Mawa", "E00102"));
		personneRepository.save(new Enseignant("Mme", "Koné", "Asta", "Active"));
		List<Personne> ets = personneRepository.findAll();
		personneRepository.delete(ets);
		List<Personne> ets1 = personneRepository.findAll();
		assertThat(ets1.size()).isEqualTo(0);
		
	}
	
	@Test
	public void findByNomCompletRegexAndfindByNomCompletContainingIgnoreCase() {
		Personne p=new Personne("Mme", "Koné", "Asta");
		p.setNomComplet();
		personneRepository.save(p);
		
		Etudiant e=new Etudiant("Mme", "Diabaté", "Mawa", "E00102");
		e.setNomComplet();
		personneRepository.save(e);
		
		Enseignant ens=new Enseignant("Mme", "Koné", "Asta", "Active");
		ens.setNomComplet();
		personneRepository.save(ens);
		
		List<Personne> ets1 = personneRepository.findByNomCompletContainingIgnoreCase("ko");
		assertThat(ets1.size()).isEqualTo(2);
		
		List<Personne> ets2 = personneRepository.findByNomCompletRegex("Dia");
		assertThat(ets2.size()).isEqualTo(1);
		Etudiant e1 = (Etudiant) ets2.get(0);
		assertThat(e1.getNom()).isEqualTo("Diabaté");

	}
	
	

	
	

	@Test
	public void findByNom() {
		Administrateur ad=new Administrateur("Mme", "Asta", "Koné", "Comptable");
		ad.setNomComplet();
		personneRepository.save(ad);
		Enseignant ens=new Enseignant("Mme", "Koné", "Asta", "Active");
		ens.setNomComplet();
		personneRepository.save(ens);
		List<Personne> pers = personneRepository.findByNomIgnoreCase("koné");
		assertThat(pers.size()).isEqualTo(1);
		Personne p = pers.get(0);
		assertThat(p.getNom()).isEqualTo("Koné");
	}
	
	@Test
	public void findByNomAndPrenomIgnoreCase() {
		Administrateur ad=new Administrateur("Mr", "Kaba", "Amara", "Comptable");
		ad.setNomComplet();
		personneRepository.save(ad);
		Enseignant ens=new Enseignant("Mme", "Koné", "Asta", "Active");
		ens.setNomComplet();
		personneRepository.save(ens);
		
		List<Personne> pers = personneRepository.findByNomIgnoreCaseAndPrenomIgnoreCase("KABA", "AMARA");
		assertThat(pers.size()).isEqualTo(1);
		Personne p = pers.get(0);
		assertThat(p.getNomComplet()).isEqualTo("Kaba Amara");
	}
	
	@Test
	public void findAllAndfindOneAndsave() {
		personneRepository.save(new Personne("Mme", "Koné", "Asta"));
		personneRepository.save(new Etudiant("Mme", "Diabaté", "Mawa", "E00102"));
		personneRepository.save(new Administrateur("Mme", "Koné", "Asta", "Comptable"));
		List<Personne> ets1 = personneRepository.findAll();
		assertThat(ets1.size()).isEqualTo(3);
		String id = ets1.get(0).getId();
		Personne p = personneRepository.findOne(id);
		assertNotNull(p);
		p.setNom("Diarra");
		p = personneRepository.save(p);
		assertThat(p.getNom()).isEqualTo("Diarra");
		personneRepository.delete(id);
		assertThat(personneRepository.findAll().size()).isEqualTo(2);
		assertNull(personneRepository.findOne(id));
		assertNotNull(personneRepository.save(new Personne("Mme", "Koné", "Asta")));
		assertThat(personneRepository.findAll().size()).isEqualTo(3);
	}
	
	@Test
	public void findByNumCni(){
		Personne p1=new Personne("Mlle", "Camara", "Moussa", "CN00210045");
		p1.setNomComplet();
		personneRepository.save(p1);
		Etudiant e=new Etudiant("Mr", "Gondo", "Jules", "CN00210050", "E00108");
		e.setNomComplet();
		personneRepository.save(e);
		Personne p2=new Personne("Mme", "Soro", "jean", "CN00210060");
		p2.setNomComplet();
		personneRepository.save(p2);
		
		Personne p =personneRepository.findByNumCni("CN00210050");
		assertNotNull(p);
		assertThat(p.getNumCni()).isEqualTo("CN00210050");
		assertThat(p.getNomComplet()).isEqualTo("Gondo Jules");
	}



}
