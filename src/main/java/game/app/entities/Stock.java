package game.app.entities;

import javax.persistence.CascadeType;
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
	private Double cantidad;

	
	//RELACIONES STOCK CON TIENDA Y JUEGO
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shop")
	Shop shop;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="game")
	//@Relation(parentColumn = "title", entityColumn = "game")
	Game game;
	
	

}
