package game.app.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	//relacion tienda con stock
	@OneToMany(mappedBy="shop",cascade=CascadeType.ALL)
	private List<Stock> stocks = new ArrayList<>();
	

}
