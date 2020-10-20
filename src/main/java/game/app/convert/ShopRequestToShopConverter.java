package game.app.convert;

import org.springframework.core.convert.converter.Converter;
import game.app.dtos.request.ShopDto;
import game.app.entities.Shop;

public class ShopRequestToShopConverter implements Converter<ShopDto, Shop> {

	public Shop convert(ShopDto shopRequest) {
		Shop shop = new Shop();
		shop.setDireccion(shopRequest.getDireccion());
		shop.setCodigoPostal(shopRequest.getCodigoPostal());
		return shop;
	}

}
