package co.deepmindz.adminorghierservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Zones_list_RequestDto {


    //	@NotEmpty(message="Name  can't be null")
    private String Name;

    @NotEmpty(message = "Linked_zone  can't be null")
    private String Linked_zone;

    private String Code;
    private String zone_listing_id;
    private String parent_zone_list_id;

}
