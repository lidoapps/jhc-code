package cn.jhc.module;

import java.io.Serializable;
import java.security.Principal;

public class MyPrincipal implements Principal, Serializable {

	private String name;

	public MyPrincipal(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "MyPrincipal: " + name;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;

		if (this == o)
			return true;

		if (!(o instanceof MyPrincipal))
			return false;
		MyPrincipal that = (MyPrincipal) o;

		if (this.getName().equals(that.getName()))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
