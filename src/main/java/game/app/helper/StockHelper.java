package game.app.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import game.app.dtos.request.StockDto;
import game.app.entities.Stock;

@Service
public class StockHelper {
	

	@Autowired
	private ConversionService converter;

	public Stock convertStockRequestToStock(StockDto stockRequest) {
	Stock stock = converter.convert(stockRequest, Stock.class);
	return stock;
			
	}

	
}
