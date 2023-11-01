package co.deepmindz.adminorghierservice.service;

import co.deepmindz.adminorghierservice.dto.ParentZoneDTO;
import co.deepmindz.adminorghierservice.dto.ZoneListFiltrationResponseDTO;
import co.deepmindz.adminorghierservice.utils.AvailableZone;

import java.util.List;

public interface ZoneListService {
    List<ZoneListFiltrationResponseDTO> getFiltrationZoneList(String zoneListFiltrationDTO);

    List<AvailableZone> getAllListZonesByLinkedZoneList(String zoneListFiltrationDTO);

    List<ParentZoneDTO> getParentZoneList();

}
