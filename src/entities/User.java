package entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.querydsl.core.annotations.PropertyType;
import com.querydsl.core.annotations.QueryType;

import misc.enums.StatutUtilisateurEnum;

@Entity
@Table(name = "user")
@PrimaryKeyJoinColumn(name = "USER_ID")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope = User.class)
public class User extends Personne implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String pwd;
	
	@Column(name = "EMAIL")
	private String email;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Abonnement> abonnements;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private Set<Reservation> reservations;
	
	@Column(name = "STATUT_UTILISATEUR")
	@Enumerated(EnumType.STRING)
    private StatutUtilisateurEnum statutUtilisateur;	
	
	@QueryType(PropertyType.NUMERIC)
	@Transient
	private Long nbAbonnements;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Abonnement> getAbonnements() {
		return abonnements;
	}

	public void setAbonnements(Set<Abonnement> abonnements) {
		this.abonnements = abonnements;
	}

	public StatutUtilisateurEnum getStatutUtilisateur() {
		return statutUtilisateur;
	}

	public void setStatutUtilisateur(StatutUtilisateurEnum statutUtilisateur) {
		this.statutUtilisateur = statutUtilisateur;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Long getNbAbonnements() {
		return nbAbonnements;
	}

	public void setNbAbonnements(Long nbAbonnements) {
		this.nbAbonnements = nbAbonnements;
	}

}
