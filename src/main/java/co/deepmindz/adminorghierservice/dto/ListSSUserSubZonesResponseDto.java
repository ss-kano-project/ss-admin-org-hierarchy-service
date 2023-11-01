package co.deepmindz.adminorghierservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ListSSUserSubZonesResponseDto {

	private String sub_zone;
	
	private List<Zones_list_ResponseDto> items;
}
