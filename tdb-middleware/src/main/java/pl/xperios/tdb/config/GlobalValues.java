package pl.xperios.tdb.config;

public interface GlobalValues {


	interface Principals {
		String GUEST = "guest";
		String ADMIN = "admin";
	}

	interface UserGroups {
		String ANYBODY = "anybody";
		String ANONYMOUS = "anonymous";
		String USER = "user";
		String ADMINISTRATOR = "administrator";
	}

	interface Roles {
		String ROLE_PREFIX = "ROLE_";

		String ANYBODY = userGroupToRole(UserGroups.ANYBODY);
		String ANONYMOUS = userGroupToRole(UserGroups.ANONYMOUS);
		String USER = userGroupToRole(UserGroups.USER);
		String ADMINISTRATOR = userGroupToRole(UserGroups.ADMINISTRATOR);

		static String userGroupToRole(String usergroup) {
			return (ROLE_PREFIX + usergroup).toUpperCase();
		}
	}


}
