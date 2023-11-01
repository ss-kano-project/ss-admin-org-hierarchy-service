package co.deepmindz.adminorghierservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RolesRequestDto {

	@NotEmpty(message = "Provide valid Title")
	private String title;
	
	@NotEmpty(message = "ManagerCode must be valid")
	private String role_code;
	
	@NotEmpty(message = "ZoneID must be valid")
	private String zone_id;
	
	private String supervisorRole_id;
}
