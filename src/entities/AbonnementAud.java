package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "abonnement_aud")
public class AbonnementAud implements Serializable {
	
	@Column(name = "ABONNEMENT_ID")
	private Long abonnementId;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "SERIE_ID")
	private Serie serie;
	
	@Column(name = "B_ENABLED", columnDefinition = "TINYINT")
	private Boolean bEnabled;
	
	@Column(name = "DATE_MAJ")
	private Date dateMaj;
	
	@Id
	@Column(name = "REV", columnDefinition = "INT(11)")
	private Long rev;

	public Long getRev() {
		return rev;
	}

	public void setRev(Long rev) {
		this.rev = rev;
	}

	public Long getAbonnementId() {
		return abonnementId;
	}

	public void setId(Long abonnementId) {
		this.abonnementId = abonnementId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Boolean getbEnabled() {
		return bEnabled;
	}

	public void setbEnabled(Boolean bEnabled) {
		this.bEnabled = bEnabled;
	}

	public Date getDateMaj() {
		return dateMaj;
	}

	public void setDateMaj(Date dateMaj) {
		this.dateMaj = dateMaj;
	}
	
}
