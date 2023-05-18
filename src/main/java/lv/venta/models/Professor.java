package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "professor_table")//table in DB
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Professor {

	@Column(name = "Idp")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	
	private long idp;
	
	//TODO add data JPA annotations
	//TODO add validation annotations
	//TODO add, commit and push
	//TODO do this also with Student, Course, Grade
	@Column(name = "Name")
	@NotNull
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[A-Z] {1} [a-z]+")
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[A-Z] {1} [a-z]+")
	private String surname;
	
	@Column(name = "Degree")
	@NotNull
	private Degree degree;
	
	@OneToOne(mappedBy = "professor")
	@ToString
	private Course course; //lūdzu izveidot man ...
	
	
	
	public Professor(String name, String surname, Degree degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}
	
}
	
	