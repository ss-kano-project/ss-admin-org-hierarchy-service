package co.deepmindz.adminorghierservice.dto;

//@AllArgsConstructor
//@NoArgsConstructor
public class LoginModeStatusDto {

	private boolean twoFA;
	private boolean userCredentials;
	private String countryCode;
	private String digitsLength;
	
	public boolean getIsTwoFA() {
		return twoFA;
	}
	public void setIsTwoFA(boolean isTwoFA) {
		this.twoFA = isTwoFA;
	}
	public boolean isUserCredentials() {
		return userCredentials;
	}
	public void setUserCredentials(boolean userCredentials) {
		this.userCredentials = userCredentials;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDigitsLength() {
		return digitsLength;
	}
	public void setDigitsLength(String digitsLength) {
		this.digitsLength = digitsLength;
	}
	public LoginModeStatusDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginModeStatusDto(boolean twoFA, boolean userCredentials, String countryCode, String digitsLength) {
		super();
		this.twoFA = twoFA;
		this.userCredentials = userCredentials;
		this.countryCode = countryCode;
		this.digitsLength = digitsLength;
	}
	public boolean isTwoFA() {
		return twoFA;
	}
	public void setTwoFA(boolean twoFA) {
		this.twoFA = twoFA;
	}
	
	
	
	
}
