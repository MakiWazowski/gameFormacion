package game.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "STOCKS")
@Data
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "CANTIDAD")
	private String cantidad;

	
	//RELACIONES STOCK CON TIENDA Y JUEGO
	@ManyToOne
	@JoinColumn(name="shop")
	Shop shop;
	
	@ManyToOne
	@JoinColumn(name="game")
	Game game;

}
