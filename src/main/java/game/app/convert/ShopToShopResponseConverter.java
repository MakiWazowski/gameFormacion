package game.app.convert;

import org.springframework.core.convert.converter.Converter;
import game.app.dtos.response.ShopResponse;
import game.app.entities.Shop;

public class ShopToShopResponseConverter implements Converter<Shop,ShopResponse>{

	@Override
	public ShopResponse convert(Shop shop) {
		ShopResponse shopResponse = new ShopResponse();
		shopResponse.setDireccion(shop.getDireccion());
		shopResponse.setCodigoPostal(shop.getCodigoPostal());
		return shopResponse;
	}

}
