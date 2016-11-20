package entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "PRODUITS")
public class Produit implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "PROD_ID")
	private Integer id;
	
	@Column(name = "PROD_PRIXHT")
	private BigDecimal prixHt;
	
	@Column(name = "PROD_PRIXTTC")
	private BigDecimal prixTtc;
	
	@Column(name = "PROD_PRIXPROMO")
	private BigDecimal prixPromo;
	
	@Column(name = "PROD_TITRE")
	private String titre;
	
	@Column(name = "PROD_TITRE_SECONDAIRE")
	private String titreSecondaire;
	
	@Column(name = "PROD_EAN")
	private String ean;
	
	@Transient
	private Stock stock;

	public BigDecimal getPrixHt() {
		return prixHt;
	}

	public void setPrixHt(BigDecimal prixHt) {
		this.prixHt = prixHt;
	}

	public BigDecimal getPrixTtc() {
		return prixTtc;
	}

	public void setPrixTtc(BigDecimal prixTtc) {
		this.prixTtc = prixTtc;
	}

	public BigDecimal getPrixPromo() {
		return prixPromo;
	}

	public void setPrixPromo(BigDecimal prixPromo) {
		this.prixPromo = prixPromo;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTitreSecondaire() {
		return titreSecondaire;
	}

	public void setTitreSecondaire(String titreSecondaire) {
		this.titreSecondaire = titreSecondaire;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}
	
}
