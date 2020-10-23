package game.app.services.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import game.app.dtos.request.StockDto;
import game.app.dtos.response.StockResponse;
import game.app.entities.Stock;
import game.app.exceptions.GameKONotFoundException;
import game.app.helper.StockHelper;
import game.app.repositories.StockRepository;
import game.app.services.StockService;

@Service
@Transactional
public class StockServiceImpl implements StockService{

	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private StockHelper stockHelper;
	
	@Autowired
	private ConversionService converter;
	
	
	//PARA GUARDAR EL STOCK EN LA BBDD
	
	@Override
	public StockResponse addStock(StockDto stockDto) {
		
		System.out.println("Añadiendo stock a la bbdd");
		Optional<Stock> game = stockRepository.findByGameTitle(stockDto.getGame().getTitle());
		//Optional<Stock> shop = stockRepository.findByShopDireccion(stockDto.getShop().getDireccion());
		
		//hay que arreglarlo, por que si existe el juego , aun que sea otra tienda no lo guarda
		if(!game.isPresent() /*&& !shop.isPresent()*/) {
			Stock stock = stockHelper.convertStockRequestToStock(stockDto);
			stockRepository.save(stock);
			return new StockResponse();
		}
		game.get().setCantidad(stockDto.getCantidad());
		
		stockRepository.saveAndFlush(game.get());
		
		return new StockResponse();
		
	}
	
	
	//PARA BUSCAR EL STOCK POR ID
	
	@Override
	public StockResponse getStock(Long id) {
		Optional<Stock> stock = stockRepository.findById(id);
		if(stock.isPresent()) {
			return converter.convert(stock.get(),StockResponse.class);
		}
		else {
			throw new GameKONotFoundException();
		}

	}
		
	//UPDATE DE STOCK PRUEBAS
	@Override
	public StockResponse updateStock(StockDto stockDto) {
		
		System.out.println("Actualizando el stock de la bbdd");
		
		Optional<Stock> updatedStock = stockRepository.findById(stockDto.getId());
		
		if(updatedStock.isPresent()) {
			updatedStock.get().setCantidad(stockDto.getCantidad());
			
			Stock stock = stockRepository.saveAndFlush(updatedStock.get());
			System.out.println(stock.getCantidad());
			
			if(stock.getCantidad().equals("0")) {
				System.out.println("No queda este stock");
			}
		}
		else {
			//habria que crear una excepcion para stock
			throw new GameKONotFoundException();
		}
		
		System.out.println("Stock actualizado con exito de la bbdd");
		return converter.convert(updatedStock.get(),StockResponse.class);
		
	}



	/*	//PARA ELIMINAR UN STOCK -->el problema es que elimina la tienda y el juego asociado tambien
	//abria que ponerlo para que en vez de eliminarlo , dejase el stock a 0.
	@Override
	public StockResponse deleteStock(Long id) {
		
		System.out.println("Dejando en 0 el stock de la bbdd");
		
		Optional<Stock> stock = stockRepository.findById(id);
		if(stock.isPresent()) {
			Stock updatedStock = stockRepository.saveAndFlush(stock.get());
			//updatedStock.getCantidad().equals("0"); -->comprobar
			//stockRepository.deleteById(id);
		}
		else {
			//habria que crear una excepcion para tienda
			throw new GameKONotFoundException();
		}
		System.out.println("Stock en 0 con exito de la bbdd");
		return converter.convert(stock.get(),StockResponse.class);
		
	}
*/
}
