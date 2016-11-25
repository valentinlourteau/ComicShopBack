package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produits_commentaires")
public class ProduitCommentaire implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRODUIT_COMMENTAIRE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUIT_ID", columnDefinition = "BIGINT(11)")
	private Produit produit;

	@Column(name = "COMMENTAIRE")
	private String commentaire;

	@ManyToOne()
	@JoinColumn(name = "GUIDE_ID", columnDefinition = "BIGINT(11)")
	private Guide guide;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

}
