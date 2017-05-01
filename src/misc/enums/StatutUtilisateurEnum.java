package misc.enums;

public enum StatutUtilisateurEnum {
	 
	UTILISATEUR {
		@Override
		public Long getId() {
			return 1L;
		}
	},
	ABONNE {
		@Override
		public Long getId() {
			return 2L;
		}
	},
	BANNI {
		@Override
		public Long getId() {
			return 3L;
		}
	};
	
	public abstract Long getId();

	public static StatutUtilisateurEnum findById(Long statutId) {
		for (StatutUtilisateurEnum item : StatutUtilisateurEnum.values()) {
			if (item.getId().equals(statutId))
				return item;
		}
		return null;
	}

}
