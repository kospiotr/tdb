package pl.xperios.tdb.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "name"})
@Entity
public class Instrument {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private DepartmentUnit departmentUnit;

	private String name;

	@Lob
	@Column
	private String description;

	private String contact;

	private String indexNo;



}
