package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "guide_theme")
public class GuideTheme implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "GUIDE_THEME_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	

}
