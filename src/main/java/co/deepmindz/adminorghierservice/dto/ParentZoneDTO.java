package co.deepmindz.adminorghierservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParentZoneDTO {
    private String _id;
    private String name;

    private String linked_zone_list;


    private String code;
    private String belongs_to_zone;

}
