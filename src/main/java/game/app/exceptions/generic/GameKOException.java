package game.app.exceptions.generic;

public class GameKOException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String detalle;
	
	public GameKOException(String detalle) {
		this.detalle = detalle;
	}

	public String getDetalle() {
		return detalle;
	}	
}

