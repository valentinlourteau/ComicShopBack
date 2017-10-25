package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import misc.enums.StatutReservationEnum;
import misc.enums.StatutUtilisateurEnum;

@Entity
@Table(name = "user")
@PrimaryKeyJoinColumn(name = "USER_ID")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope = User.class)
public class User extends Personne implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String pwd;
	
	@Column(name = "EMAIL")
	private String email;
	
	@OneToMany(mappedBy = "user")
	private List<Abonnement> abonnements;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	private List<Reservation> reservations;
	
	@Column(name = "STATUT_UTILISATEUR")
	@Enumerated(EnumType.STRING)
    private StatutUtilisateurEnum statutUtilisateur;	

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

	public List<Abonnement> getAbonnements() {
		return abonnements;
	}

	public void setAbonnements(List<Abonnement> abonnements) {
		this.abonnements = abonnements;
	}

	public StatutUtilisateurEnum getStatutUtilisateur() {
		return statutUtilisateur;
	}

	public void setStatutUtilisateur(StatutUtilisateurEnum statutUtilisateur) {
		this.statutUtilisateur = statutUtilisateur;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}
