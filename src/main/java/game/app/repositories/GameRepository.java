package game.app.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import game.app.dtos.request.GameDto;
import game.app.entities.Game;

//AQUI REALIZAMOS NUESTRAS CONSULTAS

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

	public Optional<Game> findByTitle(String title);
	
	public Optional<Game> deleteByTitle(String title);

}
