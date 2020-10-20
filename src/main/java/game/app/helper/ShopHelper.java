package game.app.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import game.app.dtos.request.ShopDto;
import game.app.entities.Shop;

@Service
public class ShopHelper {
	

	@Autowired
	private ConversionService converter;

	
	public Shop convertShopRequestToShop(ShopDto shopRequest) {
	
	Shop shop = converter.convert(shopRequest, Shop.class);
	return shop;
			
	}

	
}
