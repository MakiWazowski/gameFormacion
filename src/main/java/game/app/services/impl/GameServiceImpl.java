package game.app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import game.app.convert.GameConverter;
import game.app.dtos.request.GameDto;
import game.app.dtos.response.GameResponse;
import game.app.entities.Game;
import game.app.exceptions.GameKONotFoundException;
import game.app.exceptions.generic.GameKOException;
import game.app.helper.GameHelper;
import game.app.repository.GameRepository;
import game.app.services.GameService;

@Service
public class GameServiceImpl implements GameService{

	@Autowired
	private GameHelper gameHelper;
	
	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private ConversionService converter;
	
	@Override
	public GameResponse addGame(GameDto gameDto) {
		Game game = GameConverter.dtoToEntity(gameDto);
		gameRepository.save(game);
		return new GameResponse();
	}
	
	@Override
	public GameResponse getGame(String title) {
		Optional<Game> game = gameRepository.findByTitle(title);
		//GameDto gameRequest = GameConverter.entityToDto(game.get());
		if(game.isPresent()) {
			return converter.convert(game.get(),GameResponse.class);
		}
		else {
			throw new GameKONotFoundException();
		}
		
		//return gameRequest;
	}
	
	
	
/*
 	//ANTES DE CREACION DE REPOSITORIO Y CONVERTER
  
  
  	//lista para guardar los juegos con post 
	List<GameDto> gameList = new ArrayList<>();

	@Override
	public void addGame(GameDto gameDto) {
		gameList.add(gameDto);
	}

	@Override
	public GameDto getGame(String title) {
		Optional<GameDto> gameDto = gameList.stream().filter(g-> g.getTitle().equals(title)).findAny();
		return gameHelper.checkIfExists(gameDto);
	}
*/	

}
