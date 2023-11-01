package co.deepmindz.adminorghierservice.dto;

public class Zones_list_ResponseDto {

	private String _id;
	private String name;
	private String linked_zone;
	private String code;

	public Zones_list_ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Zones_list_ResponseDto(String _id, String name, String linked_zone, String code) {
		super();
		this._id = _id;
		this.name = name;
		this.linked_zone = linked_zone;
		this.code = code;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLinked_zone() {
		return linked_zone;
	}

	public void setLinked_zone(String linked_zone) {
		this.linked_zone = linked_zone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Zones_list_ResponseDto [_id=" + _id + ", name=" + name + ", linked_zone=" + linked_zone + ", code="
				+ code + "]";
	}

}
