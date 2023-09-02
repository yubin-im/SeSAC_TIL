package test.jdbc;

import java.util.Date;

public class Emp {
	private String gender	;	
	private String name	;	
	private String id	;	
	private String pwd	;	
	private String email	;
	private String phone	;
	private int position	;
	private String hobby	;	
	private Date regdate	;
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(String name, String gender, String id, 
				Date regdate, String pwd, String phone, 
				int position, String email, String hobby) {
		super();
		this.gender = gender;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
		this.position = position;
		this.hobby = hobby;
		this.regdate = regdate;
	}
	public String getGender() {
		return gender;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getEmail() {
		return email;
	}
	public int getPosition() {
		return position;
	}
	public String getHobby() {
		return hobby;
	}
	public Date getRegdate() {
		return regdate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((regdate == null) ? 0 : regdate.hashCode());
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
		Emp other = (Emp) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return true;
	}
	@Override
	public String toString() {
		return "Emp [gender=" + gender + ", name=" + name + ", id=" + id + ", email=" + email + ", phone=" + phone
				+ ", position=" + position + ", hobby=" + hobby + ", regdate=" + regdate + "]";
	}
}
