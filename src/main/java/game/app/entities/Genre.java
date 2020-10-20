package game.app.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import game.app.enums.GenresEnum;
import lombok.Data;

@Entity
@Table(name = "GENRES")
@Data
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "GENRE")
	@Enumerated(EnumType.STRING)
	private GenresEnum genreName;
	
	//mappedby "genres" para hacer referencia a Game.java , donde hemos llamado a la lista genres
	//many to many para declarar el tipo de relacion
	@ManyToMany(mappedBy = "genres")
	private List<Game> games;
	
}
