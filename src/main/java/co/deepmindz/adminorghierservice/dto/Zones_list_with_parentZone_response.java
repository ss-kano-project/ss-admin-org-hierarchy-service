package co.deepmindz.adminorghierservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Zones_list_with_parentZone_response {

	private String _id;
	private String name;
	private String linked_zone_id;
	private String linked_zone_name;
	private String code;

	
}





