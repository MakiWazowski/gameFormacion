package game.app.dtos.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ShopDto {
	
	@NotBlank(message = "Direction cant be null or empty, try adding a direction")
	private String direccion;
	private int codigoPostal;

	
}
