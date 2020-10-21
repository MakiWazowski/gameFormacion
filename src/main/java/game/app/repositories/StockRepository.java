package game.app.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import game.app.entities.Stock;

//AQUI REALIZAMOS NUESTRAS CONSULTAS

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

	public Optional<Stock> findById(Long id);
	
	public Optional<Stock> findByGameTitle(String title);

	
}
