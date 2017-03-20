package entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "personne")
@PrimaryKeyJoinColumn(name = "PERSONNE_ID")
public class Personne extends Contact implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "PRENOM")
	private String prenom;
	
	@Column(name = "NOM")
	private String nom;

	@Column(name = "AGE")
	private Integer age;

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
