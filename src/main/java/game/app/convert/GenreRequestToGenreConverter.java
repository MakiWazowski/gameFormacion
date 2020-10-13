package game.app.convert;

import java.util.List;

import org.springframework.core.convert.converter.Converter;

import game.app.entities.Genre;
import game.app.enums.GenresEnum;

public class GenreRequestToGenreConverter implements Converter<GenresEnum,Genre>{

	@Override
	public Genre convert(GenresEnum genreEnum) {
		Genre genre = new Genre();
		genre.setGenreName(genreEnum);
		return genre;
	}


	
	
}
