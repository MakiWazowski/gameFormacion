package game.app.convert;

import org.springframework.core.convert.converter.Converter;
import game.app.dtos.request.GameDto;
import game.app.entities.Game;

public class GameToGameResponseConverter implements Converter<Game,GameDto>{

	@Override
	public GameDto convert(Game source) {
		// TODO Auto-generated method stub
		return null;
	}

}
