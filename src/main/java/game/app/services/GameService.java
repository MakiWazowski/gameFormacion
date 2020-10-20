package game.app.services;

import game.app.dtos.request.GameDto;
import game.app.dtos.response.GameResponse;
import game.app.entities.Game;

public interface GameService {

	public GameResponse addGame(GameDto gameDto);
	
	public GameResponse getGame(String title);

	//public GameResponse deleteGame(GameDto gameDto, String title);
	public GameResponse deleteGame(String title);
	public GameResponse updateGame(GameDto gameDto, String title);
	//public Game updateGame(GameDto gameDto);

	
}
