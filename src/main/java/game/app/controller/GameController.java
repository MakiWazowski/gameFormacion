package game.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import game.app.dtos.request.GameDto;
import game.app.dtos.request.ShopDto;
import game.app.dtos.response.GameResponse;
import game.app.dtos.response.ShopResponse;
import game.app.services.GameService;
import game.app.services.ShopService;

@RestController
@Transactional
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private ShopService shopService;
	

	//GET TITLE GAME 
	@GetMapping("/game")
	public ResponseEntity<Object> getID(@RequestParam("title") String title, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.OK).body(gameService.getGame(title));
	}

	
	//POST REQUEST BODY y GUARDAR JUEGO EN LISTA CON RESPONSE Y REQUEST
	@PostMapping("/game")
	public ResponseEntity<Object> addGame(@RequestBody @Valid GameDto gameRequest, HttpServletRequest request){
		GameResponse gameResponse = gameService.addGame(gameRequest);
		return ResponseEntity.status(HttpStatus.OK).body(gameResponse);
	}
	
	
	//PRUEBAS METODO UPDATE GAME 
	@PutMapping("/game")
	public ResponseEntity<Object> updateGame(@RequestBody @Valid GameDto gameRequest, HttpServletRequest request){
		GameResponse gameResponse = gameService.updateGame(gameRequest);
		return ResponseEntity.status(HttpStatus.OK).body(gameResponse);
	}
	
	
	//METODO DELETE GAME
	@DeleteMapping("/game")
	public ResponseEntity<Object> deleteGame(@RequestParam("title") String title, HttpServletRequest request){
		GameResponse gameResponse = gameService.deleteGame(title);
		return ResponseEntity.status(HttpStatus.OK).body(gameResponse);
	}
	
	
	//GET ID SHOP
	@GetMapping("/shop")
	public ResponseEntity<Object> getID(@RequestParam("id") Long id, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.OK).body(shopService.getShop(id));
	}

	
	//POST REQUEST BODY y GUARDAR TIENDA EN LISTA CON RESPONSE Y REQUEST
	@PostMapping("/shop")
	public ResponseEntity<Object> addShop(@RequestBody @Valid ShopDto shopRequest, HttpServletRequest request){
		ShopResponse shopResponse = shopService.addShop(shopRequest);
		return ResponseEntity.status(HttpStatus.OK).body(shopResponse);
	}
	
	//METODO DELETE SHOP
	@DeleteMapping("/shop")
	public ResponseEntity<Object> deleteShop(@RequestParam("id") Long id, HttpServletRequest request){
		ShopResponse shopResponse = shopService.deleteShop(id);
		return ResponseEntity.status(HttpStatus.OK).body(shopResponse);
	}


/*
	//POST REQUEST BODY y GUARDAR JUEGO EN LISTA CON SERVICE
	@PostMapping("/game")
	public ResponseEntity<Object> addGame(@RequestBody @Valid GameDto gameDto, HttpServletRequest request){
		gameService.addGame(gameDto);
		//gameList.add(gameDto);
		return ResponseEntity.status(HttpStatus.OK).body("The game is now in the list!!");
	}
*/

/*
	// METODO DELETE GAME PRUEBAS 
	@DeleteMapping("/game")
	public ResponseEntity<Object> deleteGame(@RequestBody @Valid GameDto gameRequest,@RequestParam("title") String title, HttpServletRequest request){
		GameResponse gameResponse = gameService.deleteGame(gameRequest,title);
		return ResponseEntity.status(HttpStatus.OK).body(gameResponse);
	}
*/	
	
	// OTRAS OPERACIONES COMENTADAS
	
/*	
	//GET GENEROS POR TITULO DE JUEGO CON OPTIONAL --> sin gameService , con la lista en el controller
	@GetMapping("/gameGenre")
	public ResponseEntity<Object> getGame(@RequestParam("title") String title, HttpServletRequest request){
	
		Optional<GameDto> gameDto = gameList.stream().filter(g-> g.getTitle().equals(title)).findAny();
		if(gameDto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(gameDto.get().getGenre());
		}
		else {
			//return ResponseEntity.status(HttpStatus.OK).body("No hay ningun juego con ese nombre: ".concat(title) + ".Inserte el nombre de nuevo");
			throw new GameKOException("Game no encontrado");
		}
		
	}	
*/
	
	
//HttpServletRequest request --> permite obtener los argumentos que el cliente envía como parte de la petición.
//@ResponseBody --> para indicar que el resultado del método lo vuelque en el cuerpo de la respuesta.
				//Spring coge el resultado, lo representa en JSON y lo escribe en el cuerpo de la respuesta.
	

/*	
	//GET MENSAJE
	@GetMapping("/bienvenido")
	public String bienvenido() {
		return "Bienvenido a la nueva tienda de juegos !!";
	}
	
*/	

/*
	//GET GENEROS POR TITULO DE JUEGO CON FOR --> sin gameService , con la lista en el controller
	@GetMapping("/gameGenre")
	public ResponseEntity<Object> getGameGenre(@RequestParam("title") String title, HttpServletRequest request){
		for (GameDto gameDto : gameList) {
			if(gameDto.getTitle().contentEquals(title)) {
				return gameDto.getGenre();
			}
			else {
				return ResponseEntity.status(HttpStatus.OK).body("No hay ningun juego con ese nombre: ".concat(title) + ".Inserte el nombre de nuevo");
			}
		}
	}
*/

/*
	//GET ID --> sin gameService , con la lista en el controller
	@GetMapping("/game")
	public ResponseEntity<Long> getID(@RequestParam("id") Long id, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}
*/	
	
}
