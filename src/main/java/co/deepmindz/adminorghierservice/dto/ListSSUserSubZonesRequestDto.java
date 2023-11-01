package co.deepmindz.adminorghierservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ListSSUserSubZonesRequestDto {

	private String zone_id;

	private String type;

}
