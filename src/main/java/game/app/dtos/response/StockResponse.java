package game.app.dtos.response;

import game.app.entities.Game;
import game.app.entities.Shop;
import lombok.Data;

@Data
public class StockResponse {

	
	private Integer cantidad;
	private Shop shop;
	private Game game;


	
	public StockResponse() {
		
	}

	

}
