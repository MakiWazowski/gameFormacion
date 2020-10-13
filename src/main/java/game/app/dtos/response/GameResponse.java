package game.app.dtos.response;

import java.util.Date;

import lombok.Data;

@Data
public class GameResponse {

	private String title;
	private Date date;
	
	public GameResponse() {
		
	}
	

}
