package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "abonnement")
public class Abonnement extends AuditedEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ABONNEMENT_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	@Audited
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "SERIE_ID")
	@Audited
	private Serie serie;
	
	@Column(name = "B_ENABLED", columnDefinition = "TINYINT")
	@Audited
	private Boolean bEnabled;

	public Boolean getbEnabled() {
		return bEnabled;
	}

	public void setbEnabled(Boolean bEnabled) {
		this.bEnabled = bEnabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
