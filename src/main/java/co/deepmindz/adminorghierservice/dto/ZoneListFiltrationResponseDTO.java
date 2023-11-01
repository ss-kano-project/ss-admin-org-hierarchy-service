package co.deepmindz.adminorghierservice.dto;

import co.deepmindz.adminorghierservice.utils.AvailableZone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ZoneListFiltrationResponseDTO {
    private int size;
    private String belongs_to_zone;
    private String belongs_to_id;
    private List<AvailableZone> available_list;


}



