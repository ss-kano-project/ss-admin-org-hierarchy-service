package co.deepmindz.adminorghierservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateZoneListDTO {
    //	@NotEmpty(message="Name  can't be null")
    private String name;

    @NotEmpty(message = "belongs_to  can't be null")
    private String belongs_to;
    private String code;
    private String zone_listing_id;
}
