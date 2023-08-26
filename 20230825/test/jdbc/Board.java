package test.jdbc;

import java.util.Date;

public class Board {
	private int num;
	private String name;
	private String email;
	private String pwd;
	private String subject;
	private String content;
	private Date regdate;
	private int hit;
	private int parent;
	private int sort;
	private int tab;
	private String original;
	
	// 메소드 오버로딩(method overloading)
	public Board(int num, String name, String email, String pwd, String subject, String content, Date regdate, int hit,
			int parent, int sort, int tab, String original) {
		this(name, email, pwd, subject, content, hit, sort, tab, original);
		this.num = num;
		this.parent = parent;
		this.regdate = regdate;
	}
	
	public Board(String name, String email, String pwd, String subject, String content, int hit, int sort, int tab, String original) {
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.subject = subject;
		this.content = content;
		this.hit = hit;
		this.sort = sort;
		this.tab = tab;
		this.original = original;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getTab() {
		return tab;
	}
	public void setTab(int tab) {
		this.tab = tab;
	}
	public String getOriginal() {
		return original;
	}
	public void setOriginal(String original) {
		this.original = original;
	}

	@Override
	public String toString() {
		return "Board [num=" + num + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", subject=" + subject
				+ ", content=" + content + ", regdate=" + regdate + ", hit=" + hit + ", parent=" + parent + ", sort="
				+ sort + ", tab=" + tab + ", original=" + original + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + hit;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		result = prime * result + ((original == null) ? 0 : original.hashCode());
		result = prime * result + parent;
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((regdate == null) ? 0 : regdate.hashCode());
		result = prime * result + sort;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + tab;
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
		Board other = (Board) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (hit != other.hit)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		if (original == null) {
			if (other.original != null)
				return false;
		} else if (!original.equals(other.original))
			return false;
		if (parent != other.parent)
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (regdate == null) {
			if (other.regdate != null)
				return false;
		} else if (!regdate.equals(other.regdate))
			return false;
		if (sort != other.sort)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (tab != other.tab)
			return false;
		return true;
	}
	
	

}
