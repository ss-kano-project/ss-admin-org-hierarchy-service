package co.deepmindz.adminorghierservice.dto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConfigManagementRequestDto {

	private String id;

	@NotNull
	private String configuration;

	@NotNull
	private boolean locked;

}
