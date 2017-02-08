package ci.kossovo.ecole;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ci.kossovo.ecole.web.models.personne.ApplicationModelPersonne;

@SpringBootApplication
public class WebEcoleMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebEcoleMongoApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner personneMetier(ApplicationModelPersonne modelPersonne) {
		return (args) -> {
			modelPersonne.spprimer(modelPersonne.findAll());
			// save a couple of customers
			modelPersonne.creer(new Personne("Mr", "Jack", "Bauer","CNI0021"));
			modelPersonne.creer(new Personne("Mlle", "Chloe", "O'Brian","CNI0022"));
			modelPersonne.creer(new Etudiant("Mr", "Traore", "Abou","CNI0023", "E00102"));
			modelPersonne.creer(new Etudiant("Mr", "Koné", "Moussa","CNI0024", "E00103"));
			//modelPersonne.creer(new Enseignant("Mr", "Kanté", "Bakary","CNI0021", "Active"));
			modelPersonne.creer(new Enseignant("Mme", "Fofana", "Fanta","CNI0041", "Active"));
			modelPersonne.creer(new Administrateur("Mr", "Kaba", "Mawa","CNI0065", "Censeur"));
			modelPersonne.creer(new Administrateur("Mme", "Fofana", "Sita","CNI0033", "Comptable"));
			modelPersonne.creer(new Administrateur("Mme", "Diomandé", "Mariam","CNI00541", "Directeur etude"));
		};
		}*/

}
