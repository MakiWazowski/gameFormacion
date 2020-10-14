package game.app.helper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import game.app.dtos.request.GameDto;
import game.app.entities.Game;
import game.app.entities.Genre;
import game.app.repositories.GameRepository;

@Service
public class GameHelper {
	

	@Autowired
	private ConversionService converter;
	
	public Game convertGameRequestToGame(GameDto gameRequest) {;
	
	Game game = converter.convert(gameRequest, Game.class);
	List<Genre> genres = gameRequest.getGenre().stream().map(g->converter.convert(g, Genre.class)).collect(Collectors.toList());
	
	game.getGenres().addAll(genres);	
	return game;
			
	}
/*
	//para chequear si el juego existe o no 
	public GameDto checkIfExists(Optional<GameDto> gameDto) {
		if(gameDto.isPresent()) {
			return gameDto.get();
		}
		else {
			throw new GameKOException("Game not found");
		}
	}
	
*/
	
}
