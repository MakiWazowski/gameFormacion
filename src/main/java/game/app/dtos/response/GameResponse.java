package game.app.dtos.response;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class GameResponse {

	private String title;
	private String description;
	private Timestamp release;
	private BigDecimal price;
	
	public GameResponse() {
		
	}
	

}
