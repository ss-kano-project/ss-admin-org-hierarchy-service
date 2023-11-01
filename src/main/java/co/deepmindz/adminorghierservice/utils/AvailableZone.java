package co.deepmindz.adminorghierservice.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableZone {
    private String name;
    private String zone_list_id;
    private String zone_code;
    // Constructors, getters and setters
}