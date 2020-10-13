package game.app.services;

import game.app.dtos.request.GameDto;
import game.app.dtos.response.GameResponse;

public interface GameService {

	public GameResponse addGame(GameDto gameDto);
	
	public GameResponse getGame(String title);
	
	
}
