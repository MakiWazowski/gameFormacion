package game.app.dtos;

import lombok.Data;

@Data
public class GenreErrorDto {

	private String code; 
	private String message;
	
	public GenreErrorDto(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public GenreErrorDto() {

	}
	
}
