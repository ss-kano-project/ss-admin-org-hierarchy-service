package co.deepmindz.adminorghierservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Zones_list_ResponseDto {

	private String _id;
	private String name;
	private String linked_zone;
	private String code;
	private String belongs_to;

}
