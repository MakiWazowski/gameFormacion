package game.app.dtos.request;

import game.app.entities.Game;
import game.app.entities.Shop;
import lombok.Data;

@Data
public class StockDto {

	private Long id;
	private Double cantidad;
	private Shop shop;
	private Game game;

	


	
}
