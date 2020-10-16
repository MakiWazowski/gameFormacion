package game.app.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import game.app.convert.GenreRequestToGenreConverter;
import game.app.entities.Genre;
import game.app.enums.GenresEnum;
import game.app.repositories.GenreRepository;


public interface GenreService {

	
	public Genre findGenreByName(GenresEnum genre);
	
	//PARA CARGAR LOS GENEROS 
	public static CommandLineRunner loadGenres(GenreRepository genreRepo) {
		System.out.println("Cargando con CommandLineRunner");
		GenreRequestToGenreConverter genreEnumToGenre = new GenreRequestToGenreConverter();
		List<Genre> genre = new ArrayList<>();
		for(int i=0; i< GenresEnum.values().length; i++) {
			genre.add(genreEnumToGenre.convert(GenresEnum.values()[i]));
		}
		
		return args -> {
			genreRepo.saveAll(genre);
		};
	}
	
	//CommandLineRunner --> para correr el codigo al arranque, es una interfaz utilizada para indicar que un bean debe ejecutarse cuando está contenido dentro de una SpringApplication.
	//args--> aparece como argumento del método main, es un array de strings que debe aparecer como argumento del método main en un programa Java.Es el encargado de recoger y almacenar estos valores.
	
}
