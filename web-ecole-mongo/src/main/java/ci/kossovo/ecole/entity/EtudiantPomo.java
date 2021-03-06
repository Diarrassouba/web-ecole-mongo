//
// This file was generated by the JPA Modeler
//
package ci.kossovo.ecole.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EtudiantPomo extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private int annee;

	private Etudiant etudiant;

	private Promotion promotion;

	public EtudiantPomo() {

	}

	

	public EtudiantPomo(int annee, Etudiant etudiant, Promotion promotion) {
		super();
		this.annee = annee;
		this.etudiant = etudiant;
		this.promotion = promotion;
	}



	@Override
	public String toString() {
		return String.format("EtudiantPromo[%s,%s,%s]", etudiant.id, promotion.id, annee);
	}

	public Etudiant getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}


	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

}
