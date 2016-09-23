package entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
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
	@MapKeyColumn(name = "LIVRE_ID", columnDefinition="INT(18)", nullable = false)
	@Column(name = "COMMENTAIRE", length=255, nullable = false)
	private Map<Livre, String> livreCommentaireMap;
	
	//THEMES autocomplete de l'user manytomany avec ajout possible, test sur les libelles identiques ou ressemblents

	@Column(name = "B_VISIBLE")
	private Boolean bVisible;

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
