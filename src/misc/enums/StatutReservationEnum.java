package misc.enums;

public enum StatutReservationEnum {
	 
	ANNULEE {
		@Override
		public Long getId() {
			return 1L;
		}
	},
	PAYEE {
		@Override
		public Long getId() {
			return 2L;
		}
	},
	EN_ATTENTE {
		@Override
		public Long getId() {
			return 3L;
		}
	};
	
	public abstract Long getId();

	public static StatutReservationEnum findById(Long reservationId) {
		for (StatutReservationEnum item :StatutReservationEnum.values()) {
			if (item.getId().equals(reservationId))
				return item;
		}
		return null;
	}

}
