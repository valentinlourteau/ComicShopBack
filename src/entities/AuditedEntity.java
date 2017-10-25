package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.envers.Audited;

@MappedSuperclass
public class AuditedEntity {
	
	@Audited
	@Column(name = "DATE_MAJ")
	private Date dateMaj;

	/**
	 * La date de mise � jour de l'entit�
	 * @return
	 */
	public Date getDateMaj() {
		return dateMaj;
	}

	public void setDateMaj(Date dateMaj) {
		this.dateMaj = dateMaj;
	}

}
