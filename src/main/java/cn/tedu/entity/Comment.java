package cn.tedu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable {
	private static final long serialVersionUID = -1277268959640830134L;

	private Integer id;
	private Integer postId;
	private String name;
	private Timestamp time;
	private String content;
	
	public Comment() {
	}

	public Comment(Integer id, Integer postId, String name, Timestamp time, String content) {
		super();
		this.id = id;
		this.postId = postId;
		this.name = name;
		this.time = time;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", postId=" + postId + ", name=" + name + ", time=" + time + ", content=" + content
				+ "]";
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
		Comment other = (Comment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
