package game.app.services.impl;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import game.app.dtos.request.GameDto;
import game.app.dtos.response.GameResponse;
import game.app.entities.Game;
import game.app.exceptions.GameKONotFoundException;
import game.app.helper.GameHelper;
import game.app.repositories.GameRepository;
import game.app.services.GameService;

@Service
public class GameServiceImpl implements GameService{


	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private GameHelper gameHelper;
	
	@Autowired
	private ConversionService converter;
	
	
	
	//PARA GUARDAR EL JUEGO EN LA BBDD
	
	@Override
	public GameResponse addGame(GameDto gameDto) {
		
		System.out.println("Añadiendo juego a la bbdd");
		
		//Game game = GameConverter.dtoToEntity(gameDto);
		Game game = gameHelper.convertGameRequestToGame(gameDto);
		gameRepository.save(game);
		return new GameResponse();
	}
	
	
	//PARA BUSCAR EL JUEGO POR TITULO
	
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
	
	
// PRUEBAS ELIMINAR Y ACTUALIZAR POR TITULO 

	//PARA ELIMINAR UN JUEGO
	@Override
	public GameResponse deleteGame(GameDto gameDto,String title) {
		
		System.out.println("Eliminando juego de la bbdd");
		
		Optional<Game> game = gameRepository.findByTitle(title);
		if(game.isPresent()) {
			Game gamePedido = gameHelper.convertGameRequestToGame(gameDto);
			gameRepository.delete(gamePedido);
		}
		else {
			throw new GameKONotFoundException();
		}
		return converter.convert(game.get(),GameResponse.class);
	}

	//PARA ACTUALIZAR UN JUEGO
	@Override
	public GameResponse updateGame(GameDto gameDto,String title) {
		
		System.out.println("Actualizado juego de la bbdd");
		
		Optional<Game> game = gameRepository.findByTitle(title);
		if(game.isPresent()) {
			Game gamePedido = gameHelper.convertGameRequestToGame(gameDto);
			gameRepository.save(gamePedido);
		}
		else {
			throw new GameKONotFoundException();
		}
		return converter.convert(game.get(),GameResponse.class);
	}
	
	
	//OTRAS PRUEBAS 
//	@Override
//	public GameResponse deleteGame(GameDto gameDto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public Game updateGame(GameDto gameDto) {
//		Game game = gameHelper.convertGameRequestToGame(gameDto);
//		return gameRepository.save(game);
//	}
//	}
//
	
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
