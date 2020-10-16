package game.app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import game.app.convert.GameConverter;
import game.app.dtos.request.GameDto;
import game.app.dtos.response.GameResponse;
import game.app.entities.Game;
import game.app.entities.Genre;
import game.app.enums.GenresEnum;
import game.app.exceptions.GameKONotFoundException;
import game.app.exceptions.generic.GameKOException;
import game.app.helper.GameHelper;
import game.app.repositories.GameRepository;
import game.app.repositories.GenreRepository;
import game.app.services.GameService;
import game.app.services.GenreService;

@Service
public class GenreServiceImpl implements GenreService{

	@Autowired
	private GenreRepository genreRepository;
	
	
	@Override
	public Genre findGenreByName(GenresEnum genreEnum) {
		Optional<Genre> genre = genreRepository.findByGenreName(genreEnum);
		
		if (genre.isPresent()) {
			return genre.get();
		}
		//aqui retorna una excepcion de genero si no existe
		return null;
	}



}
