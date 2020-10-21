package game.app.services;

import game.app.dtos.request.StockDto;
import game.app.dtos.response.StockResponse;

public interface StockService {

	public StockResponse addStock(StockDto stockDto);
	
	public StockResponse getStock(Long id);

	public StockResponse deleteStock(Long id);


	
}
