package game.app.exceptions;

import game.app.exceptions.generic.NotFoundException;

public class GenreNotFoundException extends NotFoundException{

	private static final long serialVersionUID = 1L;
	
	private static final String DETAIL = "Genero no encontrado";
	
	
	public GenreNotFoundException(String detalle) {
		super(detalle);
	}

	public GenreNotFoundException() {
		super(DETAIL);
	}
}
