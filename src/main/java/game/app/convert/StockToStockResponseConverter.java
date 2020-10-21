package game.app.convert;

import org.springframework.core.convert.converter.Converter;
import game.app.dtos.response.StockResponse;
import game.app.entities.Stock;

public class StockToStockResponseConverter implements Converter<Stock,StockResponse>{

	@Override
	public StockResponse convert(Stock stock) {
		StockResponse stockResponse = new StockResponse();
		stockResponse.setCantidad(stock.getCantidad());
		stockResponse.setGame(stock.getGame());
		stockResponse.setShop(stock.getShop());
		return stockResponse;
	}

}
