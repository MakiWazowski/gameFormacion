package game.app.repository;

import java.util.Optional;
import game.app.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
	
	public Optional<Game> findByTitle(String title);
}
