package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "produits_commentaires")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope = ProduitCommentaire.class)
public class ProduitCommentaire implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRODUIT_COMMENTAIRE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@ForeignKey(name = "none")
	@JoinColumn(name = "PRODUIT_ID", columnDefinition = "INT(11)")
	private Produit produit;

	@Column(name = "COMMENTAIRE", columnDefinition = "longtext")
	@Lob
	private String commentaire;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GUIDE_ID", columnDefinition = "BIGINT(11)")
	private Guide guide;
	
	@Column(name = "ORDRE_AFFICHAGE")
	private Integer ordre = 99;

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

	@JsonIgnore
	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	public Integer getOrdre() {
		return ordre;
	}

	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}

}
