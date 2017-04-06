package pl.xperios.tdb.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPrincipal {

	private String username;
	private String password;
	private List<String> authorities = new ArrayList<>();

}
