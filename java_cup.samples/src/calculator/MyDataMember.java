package calculator;



public class MyDataMember {
	
	private String name;
	private String accessLevel;
	private String type;
	
	public MyDataMember(String name) {
		this.name = name;
	}
	
	public MyDataMember(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAccessLevel() {
		return accessLevel;
	}
	
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
		System.out.println("Data: " + getName() + "'s type is set to" + getType());
	}
}
