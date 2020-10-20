package game.app.services.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import game.app.dtos.request.ShopDto;
import game.app.dtos.response.ShopResponse;
import game.app.entities.Shop;
import game.app.exceptions.GameKONotFoundException;
import game.app.helper.ShopHelper;
import game.app.repositories.ShopRepository;
import game.app.services.ShopService;

@Service
public class ShopServiceImpl implements ShopService{

	
	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private ShopHelper shopHelper;
	
	@Autowired
	private ConversionService converter;
	
	
	//PARA GUARDAR LA TIENDA EN LA BBDD
	
	@Override
	public ShopResponse addShop(ShopDto shopDto) {
		
		System.out.println("Añadiendo tienda a la bbdd");
		
		Shop shop = shopHelper.convertShopRequestToShop(shopDto);
		shopRepository.save(shop);
		return new ShopResponse();
	}
	
	
	//PARA BUSCARLA TIENDA POR ID
	
	@Override
	public ShopResponse getShop(Long id) {
		Optional<Shop> shop = shopRepository.findById(id);
		if(shop.isPresent()) {
			return converter.convert(shop.get(),ShopResponse.class);
		}
		else {
			throw new GameKONotFoundException();
		}

	}


}
