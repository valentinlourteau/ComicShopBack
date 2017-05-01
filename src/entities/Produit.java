package entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "produits")
public class Produit implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "PROD_ID", columnDefinition = "INT(11)")
	@Type(type = "integer")
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
	
	@Column(name = "PROD_EAN" , insertable = false, updatable = false)
	private String ean;
	
	@OneToOne(fetch = FetchType.LAZY)
	@ForeignKey(name = "none")
	@JoinColumn(name = "PROD_EAN", referencedColumnName = "PROD_EAN", insertable = false, updatable = false)
	private ProduitImage image;
	
	@OneToOne(fetch = FetchType.LAZY)
	@ForeignKey(name = "none")
	@JoinColumn(name = "PROD_EAN", referencedColumnName = "STOCK_EAN", insertable = false, updatable = false)
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

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public ProduitImage getImage() {
		return image;
	}

	public void setImage(ProduitImage image) {
		this.image = image;
	}
	
}
