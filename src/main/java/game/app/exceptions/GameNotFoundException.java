package game.app.exceptions;

import game.app.exceptions.generic.NotFoundException;

public class GameNotFoundException extends NotFoundException{

	private static final long serialVersionUID = 1L;
	
	private static final String DETAIL = "Juego no encontrado";
	
	
	public GameNotFoundException(String detalle) {
		super(detalle);
	}

	public GameNotFoundException() {
		super(DETAIL);
	}
}
