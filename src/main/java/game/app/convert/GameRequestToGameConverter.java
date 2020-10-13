package game.app.convert;

import org.springframework.core.convert.converter.Converter;

import game.app.dtos.request.GameDto;
import game.app.entities.Game;
import game.app.entities.Genre;
import game.app.enums.GenresEnum;

public class GameRequestToGameConverter implements Converter<GameDto,Game> {

	public Game convert(GameDto gameRequest) {
		Game game = new Game();
		game.setTitle(gameRequest.getTitle());
		game.setDescription(gameRequest.getDescription());
		game.setRelease(gameRequest.getRelease());
		game.setPrice(gameRequest.getPrice());
		
		//añadir un nuevo genero
		for(GenresEnum genre : gameRequest.getGenre()) {
			Genre genreEntity = new Genre();
			game.getGenre().add(genreEntity);
		}
		return game;
	}

	
}
