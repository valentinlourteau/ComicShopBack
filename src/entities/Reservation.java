package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import misc.enums.StatutReservationEnum;

@Entity
@Table(name = "reservation")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Reservation.class)
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "RESERVATION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Audited
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUIT_ID")
	@ForeignKey(name = "none")
	private Produit produit;
	
	@Column(name = "DATE_RESERVATION")
	private Date dateReservation;
	
	@Column(name = "B_FINALISE")
	private Boolean bFinalise = false;

	@Column(name = "DATE_RETRAIT_MAX")
	private Date dateRetraitMax;
	
	@Column(name = "STATUT_RESERVATION")
	@Enumerated(EnumType.STRING)
    private StatutReservationEnum statutReservation;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Date getDateRetraitMax() {
		return dateRetraitMax;
	}

	public void setDateRetraitMax(Date dateRetraitMax) {
		this.dateRetraitMax = dateRetraitMax;
	}

	public StatutReservationEnum getStatutReservation() {
		return statutReservation;
	}

	public void setStatutReservation(StatutReservationEnum statutReservation) {
		this.statutReservation = statutReservation;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Boolean getbFinalise() {
		return bFinalise;
	}

	public void setbFinalise(Boolean bFinalise) {
		this.bFinalise = bFinalise;
	}

}
