package game.app.services;

import game.app.dtos.request.ShopDto;
import game.app.dtos.response.ShopResponse;

public interface ShopService {

	public ShopResponse addShop(ShopDto shopDto);
	
	public ShopResponse getShop(Long id);

	public ShopResponse deleteShop(Long id);


	
}
