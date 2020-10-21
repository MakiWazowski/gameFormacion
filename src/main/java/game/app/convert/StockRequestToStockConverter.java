package game.app.convert;

import org.springframework.core.convert.converter.Converter;
import game.app.dtos.request.StockDto;
import game.app.entities.Stock;

public class StockRequestToStockConverter implements Converter<StockDto, Stock> {

	public Stock convert(StockDto stockRequest) {
		Stock stock = new Stock();
		stock.setCantidad(stockRequest.getCantidad());
		stock.setGame(stockRequest.getGame());
		stock.setShop(stockRequest.getShop());
		return stock;
	}


}
