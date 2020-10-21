package game.app.dtos.request;

import javax.validation.constraints.NotBlank;

import game.app.entities.Game;
import game.app.entities.Shop;
import lombok.Data;

@Data
public class StockDto {
	
	@NotBlank(message = "Quantity cant be null or empty, try adding a quantity")
	private Long cantidad;
	private Shop shop;
	private Game game;

	
}
