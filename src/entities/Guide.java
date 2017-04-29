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
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "guide")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Guide.class)
public class Guide implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "GUIDE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "TITRE")
	private String titre;

	@Column(name = "RESUME", length = 4000)
	private String resume;
	
	@OneToMany(mappedBy = "guide", fetch = FetchType.LAZY)
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
	
	@ManyToMany(fetch = FetchType.LAZY)
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

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Set<ProduitCommentaire> getProduitsCommentaires() {
		return produitsCommentaires;
	}

	public void setProduitsCommentaires(Set<ProduitCommentaire> produitsCommentaires) {
		this.produitsCommentaires = produitsCommentaires;
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

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

}
