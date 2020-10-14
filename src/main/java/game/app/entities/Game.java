package game.app.entities;


import java.util.ArrayList;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
	private List<Genre> genres = new ArrayList<>();
	
	@Column(name = "RELEASES")
	@Temporal(TemporalType.DATE)
	@NotNull
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date release;
	
	@Column(name = "PRICE")
	private Double price;
}
