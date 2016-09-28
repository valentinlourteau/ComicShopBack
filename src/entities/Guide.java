package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GUIDE")
public class Guide implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "GUIDE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "LIVRES_COMMENTAIRES")
	private Map<Livre, String> livreCommentaireMap;
	
	//THEMES autocomplete de l'user manytomany avec ajout possible, test sur les libelles identiques ou ressemblents

	@Column(name = "B_VISIBLE")
	private Boolean bVisible;
	
	@Column(name = "DATE_PUBLICATION")
	private Date datePublication;
	
	@Column(name = "DATE_DERNIERE_MODIFICATION")
	private Date dateDerniereModification;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "THEME_ID")
	private List<Theme> themes;

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public Date getDateDerniereModification() {
		return dateDerniereModification;
	}

	public void setDateDerniereModification(Date dateDerniereModification) {
		this.dateDerniereModification = dateDerniereModification;
	}

	public Map<Livre, String> getLivreCommentaireMap() {
		return livreCommentaireMap;
	}

	public void setLivreCommentaireMap(Map<Livre, String> livreCommentaireMap) {
		this.livreCommentaireMap = livreCommentaireMap;
	}

	public Boolean getbVisible() {
		return bVisible;
	}

	public void setbVisible(Boolean bVisible) {
		this.bVisible = bVisible;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
