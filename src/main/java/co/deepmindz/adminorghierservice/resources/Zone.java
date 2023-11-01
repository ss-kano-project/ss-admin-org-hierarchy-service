package co.deepmindz.adminorghierservice.resources;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Zone {
    private String _id;
    private String name;
    private String linked_zone_list;
    private String code;
    private String belongs_to_zone;

    // Constructors, getters, and setters
}
