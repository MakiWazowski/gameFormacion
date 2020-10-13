package game.app.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import game.app.enums.GenresEnum;
import lombok.Data;

@Entity
@Table(name = "GAMES")
@Data
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	//cascade para poder controlar updates,deletes...
	@ManyToMany(cascade = {CascadeType.PERSIST , CascadeType.MERGE})
	private List<GenresEnum> genre = new ArrayList<>();
	
	@Column(name = "RELEASE")
	private Timestamp release;
	
	@Column(name = "PRICE")
	private BigDecimal price;
}
