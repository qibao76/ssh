package cn.tedu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class PUser implements Serializable {
	private static final long serialVersionUID = -2723787919195549266L;

	private Integer id;
	private String name;
	private String password;
	private String nick;
	private Timestamp regDate;
	
	public PUser() {
	}

	public PUser(Integer id, String name, String password, String nick, Timestamp regDate) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.nick = nick;
		this.regDate = regDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PUser other = (PUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PUser [id=" + id + ", name=" + name + ", password=" + password + ", nick=" + nick + ", regDate="
				+ regDate + "]";
	}

	
}
