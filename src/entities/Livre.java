//package entities;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
////@Entity
//@Table(name = "LIVRE")
//public class Livre implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//	
//	@Id
//	@Column(name = "LIVRE_ID")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@Column(name = "TITRE")
//	private String titre;
//	
//	@Column(name = "PRIX")
//	private Double prix;
//
//	public String getTitre() {
//		return titre;
//	}
//
//	public void setTitre(String titre) {
//		this.titre = titre;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Double getPrix() {
//		return prix;
//	}
//
//	public void setPrix(Double prix) {
//		this.prix = prix;
//	}
//}
