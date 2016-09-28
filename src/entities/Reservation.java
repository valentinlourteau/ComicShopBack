package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import misc.enums.StatutReservationEnum;

@Entity
@Table(name = "RESERVATION")
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "RESERVATION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@JoinColumn(name = "LIVRE_ID")
	private Livre livre;
	
	@Column(name = "DATE_RESERVATION")
	private Date dateReservation;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
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

	@Column(name = "DATE_RETRAIT_MAX")
	private Date dateRetraitMax;
	
	@Enumerated(EnumType.STRING)
    private StatutReservationEnum statutReservation;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
