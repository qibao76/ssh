package cn.tedu.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Post implements Serializable{
	private static final long serialVersionUID = 4052088422727902898L;
	
	private Integer id;
	private PUser user;
	private String content;
	private Timestamp time;
	private Set<Comment> comments =
			new HashSet<Comment>();
	
	public Post() {
	}

	public Post(Integer id, PUser user, String content, Timestamp time, Set<Comment> comments) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.time = time;
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PUser getUser() {
		return user;
	}

	public void setUser(PUser user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", user=" + user + ", content=" + content + ", time=" + time + ", comments="
				+ comments + "]";
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
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
