package game.app.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "SHOPS")
@Data
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DIRECCION")
	private String direccion;
	
	@Column(name = "CP")
	private int codigoPostal;
	
	//cascade para poder controlar updates,deletes...
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST , CascadeType.MERGE})
	private List<Game> games = new ArrayList<>();
	
//hay que cambiar el many to many por una tabla creada a mano , ya que hay que añadir un atributo cantidad a la tabla de relacion


}
