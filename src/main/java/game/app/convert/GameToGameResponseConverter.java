package game.app.convert;

import org.springframework.core.convert.converter.Converter;
import game.app.dtos.response.GameResponse;
import game.app.entities.Game;

public class GameToGameResponseConverter implements Converter<Game,GameResponse>{

	@Override
	public GameResponse convert(Game game) {
		GameResponse gameResponse = new GameResponse();
		gameResponse.setTitle(game.getTitle());
		gameResponse.setDescription(game.getDescription());
		gameResponse.setRelease(game.getRelease());
		gameResponse.setPrice(game.getPrice());
		return gameResponse;
	}

}
