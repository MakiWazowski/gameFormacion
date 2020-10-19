package game.app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import game.app.convert.GenreRequestToGenreConverter;
import game.app.entities.Genre;
import game.app.enums.GenresEnum;
import game.app.exceptions.GenreNotFoundException;
import game.app.repositories.GenreRepository;
import game.app.services.GenreService;

@Service
public class GenreServiceImpl implements GenreService{

	@Autowired
	private GenreRepository genreRepository;
	
	//PARA ENCONTRAR EN GENERO POR NOMBRE
	@Override
	public Genre findGenreByName(GenresEnum genreEnum) {
		Optional<Genre> genre = genreRepository.findByGenreName(genreEnum);
		//coger el genero si existe
		if (genre.isPresent()) {
			return genre.get();
		}
		//aqui retorna una excepcion de genero si no existe
		throw new GenreNotFoundException();
	}

	//PARA CARGAR LOS GENEROS --> coge los generos del enum y los va añadiendo a la bbdd
	@PostConstruct
	public void loadGenres() {
		
		System.out.println("Insertando generos en la bbdd");
		//conversor de generos
		GenreRequestToGenreConverter genreEnumToGenre = new GenreRequestToGenreConverter();
		//creamos lista 
		List<Genre> genres = new ArrayList<>();
		//va añadiendo los generos hasta que no queda ninguno
		for(int i=0; i< GenresEnum.values().length; i++) {
			//si no esta presente se añade 
			if(!genreRepository.findByGenreName(GenresEnum.values()[i]).isPresent()){
				genres.add(genreEnumToGenre.convert(GenresEnum.values()[i]));
			}
		}
		genreRepository.saveAll(genres);
	}



}
