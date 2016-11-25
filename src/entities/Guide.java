package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "guide")
public class Guide implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "GUIDE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "TITRE")
	private String titre;

//	@OneToMany(mappedBy = "guide", cascade = CascadeType.REMOVE)
//	private Set<ProduitCommentaire> produitsCommentaires;
	
	@Transient
	private Set<ProduitCommentaire> produitsCommentaires;

	@Column(name = "B_VISIBLE", columnDefinition = "TINYINT")
	private Boolean bVisible;
	
	@Column(name = "DATE_PUBLICATION")
	private Date datePublication;
	
	@Column(name = "DATE_MODIFICATION")
	private Date dateModification;
	
	@Column(name = "IMAGE_COUVERTURE", columnDefinition = "longblob")
	@Lob
	private byte[] imageCouverture;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(
		      name="guide_theme",
		      joinColumns=@JoinColumn(name="GUIDE_ID", referencedColumnName="GUIDE_ID"),
		      inverseJoinColumns=@JoinColumn(name="THEME_ID", referencedColumnName="THEME_ID"))
	private List<Theme> themes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getbVisible() {
		return bVisible;
	}

	public void setbVisible(Boolean bVisible) {
		this.bVisible = bVisible;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	public byte[] getImageCouverture() {
		return imageCouverture;
	}

	public void setImageCouverture(byte[] imageCouverture) {
		this.imageCouverture = imageCouverture;
	}

//	public Set<ProduitCommentaire> getProduitsCommentaires() {
//		return produitsCommentaires;
//	}
//
//	public void setProduitsCommentaires(Set<ProduitCommentaire> produitsCommentaires) {
//		this.produitsCommentaires = produitsCommentaires;
//	}

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	public Set<ProduitCommentaire> getProduitsCommentaires() {
		return produitsCommentaires;
	}

	public void setProduitsCommentaires(Set<ProduitCommentaire> produitsCommentaires) {
		this.produitsCommentaires = produitsCommentaires;
	}

}
