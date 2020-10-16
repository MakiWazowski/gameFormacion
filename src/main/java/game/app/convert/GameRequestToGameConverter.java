package game.app.convert;

import org.springframework.core.convert.converter.Converter;
import game.app.dtos.request.GameDto;
import game.app.entities.Game;

public class GameRequestToGameConverter implements Converter<GameDto,Game> {

	public Game convert(GameDto gameRequest) {
		Game game = new Game();
		game.setTitle(gameRequest.getTitle());
		game.setDescription(gameRequest.getDescription());
		game.setRelease(gameRequest.getRelease());
		game.setPrice(gameRequest.getPrice());
		
		return game;
	}

	
}
