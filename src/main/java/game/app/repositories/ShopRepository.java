package game.app.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import game.app.entities.Shop;

//AQUI REALIZAMOS NUESTRAS CONSULTAS

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>{

	public Optional<Shop> findById(Long id);

	public Optional<Shop> findByDireccion(String direccion);

	
}
