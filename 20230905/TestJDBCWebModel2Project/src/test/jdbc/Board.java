package test.jdbc;

import java.util.Date;

public class Board {
	private int num	;	
	private String name	;	
	private String email	;	// web id 데이터와 매핑.
	private String pwd	;  // web pwd 데이터와 매핑.
	private String subject	;	
	private String content	;	
	private Date regdate	; //kdtå�� ���� SimpleDateFormat�� �̿��Ͽ� ��¥�� �̻ڰ�...
	private int hit	;	
	private int parent	;	
	private int sort	;	
	private int tab	;	
	private String original;
	
	public Board(int num, String name, String email, String pwd, String subject, String content, 
			Date regdate, int hit,	int parent, int sort, int tab, String original) {
		this( name,  email,  pwd,  subject, content,  hit,   sort,  tab,  original);
		this.num = num;		this.parent = parent;		this.regdate = regdate;
	}
	public Board(String name, String email, String pwd, String subject, 
			String content, int hit, int sort, int tab, String original) {
		this.name = name;		this.email = email;		this.pwd = pwd;		this.subject = subject;
		this.content = content;		this.hit = hit;		this.sort = sort;		this.tab = tab;		
		this.original = original;
	}
	
	public Board(String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNum() {		return num;	}
	public String getName() {		return name;	}
	public String getEmail() {		return email;	}
	public String getPwd() {		return pwd;	}
	public String getSubject() {		return subject;	}
	public String getContent() {		return content;	}
	public Date getRegdate() {		return regdate;	}
	public int getHit() {		return hit;	}
	public int getParent() {		return parent;	}
	public int getSort() {		return sort;	}
	public int getTab() {		return tab;	}
	public String getOriginal() {		return original;	}

	public void setNum(int num) {		this.num = num;	}
	public void setName(String name) {		this.name = name;	}
	public void setEmail(String email) {		this.email = email;	}
	public void setId(String email) {		this.email = email;	}
	public void setPwd(String pwd) {		this.pwd = pwd;	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public void setTab(int tab) {
		this.tab = tab;
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
		result = prime * result + num;
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
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
		if (num != other.num)
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}
}
