package game.app.dtos.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import game.app.enums.GenresEnum;
import lombok.Data;

@Data
public class GameDto {
	
	@NotBlank(message = "Title cant be null or empty, try adding a title")
	private String title;
	private String description;
	private List<GenresEnum> genre = new ArrayList<>();
	private Date release;
	private Double price;


	
}
