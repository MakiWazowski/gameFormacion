package game.app.dtos;

import lombok.Data;

@Data
public class GameErrorDto {

	private String code; 
	private String message;
	
	public GameErrorDto(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public GameErrorDto() {

	}
	
}
