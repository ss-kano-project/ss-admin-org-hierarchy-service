package co.deepmindz.adminorghierservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
//@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Zones_list")
public class Zones_list {

    
    
	public Zones_list(String _id, @NotNull String name, String linked_zone_list, String code, String belongs_to_zone) {
		super();
		this._id = _id;
		this.name = name;
		this.linked_zone_list = linked_zone_list;
		this.code = code;
		this.belongs_to_zone = belongs_to_zone;
	}


	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String _id;
    @NotNull
    @Column(unique = true)
    private String name;
    private String linked_zone_list;
    private String code;
    private String belongs_to_zone;

}
