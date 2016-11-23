package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "STOCK")
public class Stock implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "STOCK_EAN") 
	private String ean;
	
	@Column(name = "STOCK_QTE")
	private Integer quantite;

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

}
