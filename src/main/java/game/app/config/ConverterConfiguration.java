package game.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import game.app.convert.GameRequestToGameConverter;
import game.app.convert.GameToGameResponseConverter;
import game.app.convert.GenreRequestToGenreConverter;
import game.app.convert.ShopRequestToShopConverter;
import game.app.convert.ShopToShopResponseConverter;
import game.app.convert.StockRequestToStockConverter;
import game.app.convert.StockToStockResponseConverter;

@Configuration
public class ConverterConfiguration implements WebMvcConfigurer{

	
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new GameRequestToGameConverter());
		registry.addConverter(new GameToGameResponseConverter());
		registry.addConverter(new GenreRequestToGenreConverter());
		registry.addConverter(new ShopRequestToShopConverter());
		registry.addConverter(new ShopToShopResponseConverter());
		registry.addConverter(new StockRequestToStockConverter());
		registry.addConverter(new StockToStockResponseConverter());
		
	}
}
