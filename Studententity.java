package schooldata.entity;
public class Sudent {
	private int id;
	private String name;
	@Override
	public String toString() {
		return "Sudent [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	private int age;

	public Sudent(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Sudent() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
