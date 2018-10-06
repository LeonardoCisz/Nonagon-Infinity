package entity;

public class Task {

	private long id;
	private String Name;
	private String Desc;
	private Integer dono; 

	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name='" + Name + '\'' + ", descricao'" + Desc + '\'' + '}';
	}

	public Integer getDono() {
		return dono;
	}
	
	public void setDono(Integer dono) {
		this.dono = dono;
	}

}
