package game.app.dtos.response;

import java.util.Date;
import lombok.Data;

@Data
public class GameResponse {

	private String title;
	private String description;
	private Date release;
	private Double price;
	
	public GameResponse() {
		
	}
	

}
