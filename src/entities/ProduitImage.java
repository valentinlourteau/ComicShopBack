package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "produit_images")
public class ProduitImage implements Serializable {
	
	@Id
	@Column(name = "prod_image_id", columnDefinition = "INT(11)")
	@Type(type = "long")
	private Long id;
	
	@Column(name = "PROD_EAN")
	private String produitEan;
	
	@Column(name = "prod_image_front")
	private String prodImageFront;
	
	@Transient
	private byte[] image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduitEan() {
		return produitEan;
	}

	public void setProduitEan(String produitEan) {
		this.produitEan = produitEan;
	}

	public String getProdImageFront() {
		return prodImageFront;
	}

	public void setProdImageFront(String prodImageFront) {
		this.prodImageFront = prodImageFront;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
