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
		
		System.out.println("Añadiendo tienda a la bbdd");
		
		Stock stock = stockHelper.convertStockRequestToStock(stockDto);
		stockRepository.save(stock);
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
	
	//PARA ELIMINAR UN STOCK
	@Override
	public StockResponse deleteStock(Long id) {
		
		System.out.println("Eliminando tienda de la bbdd");
		
		Optional<Stock> stock = stockRepository.findById(id);
		if(stock.isPresent()) {
			stockRepository.deleteById(id);
		}
		else {
			//habria que crear una excepcion para tienda
			throw new GameKONotFoundException();
		}
		System.out.println("Tienda eliminada con exito de la bbdd");
		return converter.convert(stock.get(),StockResponse.class);
		
	}




}
