package co.deepmindz.adminorghierservice.utils;

public class Templates {
	public enum LOGINMODES {
		Two_FA, USER_CREDENTIALS
	}

	public enum VISITTYPES {
		Team_Visit, Individual_Visit
	}

	public enum ALLSERVICES {
		admin_main {
			public String toString() {
				return "http://admin-main-service";
			}
		},

		admin_org {
			public String toString() {
				return "http://admin-org-hierarchy-service";
			}
		}
	}
}
