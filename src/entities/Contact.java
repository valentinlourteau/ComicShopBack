package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "contact")
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public abstract class Contact implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CONTACT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Audited
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}