package game.app.services;

import game.app.entities.Genre;
import game.app.enums.GenresEnum;


public interface GenreService {


	public Genre findGenreByName(GenresEnum genre);

}
