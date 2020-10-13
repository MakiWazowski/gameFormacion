package game.app.convert;

import game.app.dtos.request.GameDto;
import game.app.entities.Game;

public class GameConverter {

	public static Game dtoToEntity(GameDto gameDto) {
		Game game = new Game();
		game.setTitle(gameDto.getTitle());
		game.setDescription(gameDto.getDescription());
		game.setRelease(gameDto.getRelease());
		game.setPrice(gameDto.getPrice());
		return game;
	}
	
	public static GameDto entityToDto(Game game) {
		GameDto gameRequest= new GameDto();
		gameRequest.setTitle(game.getTitle());
		gameRequest.setDescription(game.getDescription());
		gameRequest.setRelease(game.getRelease());
		gameRequest.setPrice(game.getPrice());
		return gameRequest;
	}
}
