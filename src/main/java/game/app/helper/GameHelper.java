package game.app.helper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import game.app.dtos.request.GameDto;
import game.app.entities.Game;
import game.app.entities.Genre;

@Service
public class GameHelper {
	
	@Autowired
	private ConversionService converter;
	
	public Game convertGameRequestToGame(GameDto gameRequest) {;
	
	Game game = converter.convert(gameRequest, Game.class);
/*	List<Genre> genres = converter.convert(gameRequest, List<Genre.class>);
	
	for(GenresEnum gr : gameRequest.getGenre()) {
		Genre genre = converter.convert(gr, Genre.class);
		game.getGenre().add(genre);
	}
*/	
	List<Genre> genres = gameRequest.getGenre().stream().map(gr-> converter(gr,Genre.Class)).collect(Collectors.toList());
	game.getGenre().addAll(genres);
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
