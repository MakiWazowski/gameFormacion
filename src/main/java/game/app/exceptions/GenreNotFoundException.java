package game.app.exceptions;

import game.app.exceptions.generic.GameKOException;

//EXCEPCION DE GENERO NO ENCONTRADO EN LA BBDD

public class GenreNotFoundException extends GameKOException{

	private static final long serialVersionUID = 1L;
	
	private static final String DETAIL = "Genero no encontrado";
	
	
	public GenreNotFoundException(String detalle) {
		super(detalle);
	}

	public GenreNotFoundException() {
		super(DETAIL);
	}
}
