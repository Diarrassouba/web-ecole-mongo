//
// This file was generated by the JPA Modeler
//
package ci.kossovo.ecole.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Enseigne extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private String annee;
	// Enseigne lié à eneignant
	private Enseignant enseignant;
	private boolean active;
	// Enseigne lié à matiere
	private Matiere matiere;
	private Promotion promotion;

	public Enseigne() {

	}

	public Enseigne(String annee, boolean active) {
		super();
		
		this.annee = annee;
		this.active = active;
	}

	

	public Enseigne(Enseignant enseignant, boolean active, Matiere matiere, Promotion promotion) {
		super();
		this.enseignant = enseignant;
		this.active = active;
		this.matiere = matiere;
		this.promotion = promotion;
	}

	@Override
	public String toString() {
		return String.format("Enseigne[%s,%s,%s,%s,%s]", enseignant.id,matiere.id,promotion.id, annee,active);
	}
	
	public String getAnnee() {
		return this.annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public Enseignant getEnseignant() {
		return this.enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Matiere getMatiere() {
		return this.matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	
}
