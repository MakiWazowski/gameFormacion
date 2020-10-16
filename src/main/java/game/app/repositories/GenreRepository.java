package game.app.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import game.app.entities.Genre;
import game.app.enums.GenresEnum;


@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

	public Optional<Genre> findByGenreName(GenresEnum genre);
}
