package com.puc.tcc.domain;

import java.util.Set;

import javax.persistence.OneToMany;

public class User extends BaseEntity {

	private final String email;
	private final char[] password;
	@OneToMany(mappedBy = "owner")
	private final Set<Aquarium> aquariums;

	public User(Integer id, String email, char[] password, Set<Aquarium> aquariums) {
		super(id);
		this.email = email;
		this.password = password;
		this.aquariums = aquariums;
	}

	public User(String email, char[] password, Set<Aquarium> aquariums) {
		super(null);
		this.email = email;
		this.password = password;
		this.aquariums = aquariums;
	}

	public String getEmail() {
		return email;
	}

	public char[] getPassword() {
		return password;
	}

	public Set<Aquarium> getAquariums() {
		return aquariums;
	}

}
