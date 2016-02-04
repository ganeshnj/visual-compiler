package calculator;


import java.util.ArrayList;

public class MyMethod {
	
	private String name;
	private String accessLevel;
	private String returnType;
	private ArrayList<MyDataMember> arguments;
	
	public MyMethod(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
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
		System.out.println("Method: " + this.name + "'s access level is set " + accessLevel);
	}
	
	public String getReturnType() {
		return returnType;
	}
	
	public void setReturnType(String returnType) {
		this.returnType = returnType;
		System.out.println("Method: " + this.name + "'s return type is set " + returnType);
	}
	
	public ArrayList<MyDataMember> getArguments() {
		
		if(arguments == null)
			arguments = new ArrayList<>();
		
		return arguments;
	}
	
	public void setArguments(ArrayList<MyDataMember> arguments) {
		this.arguments = arguments;
	}
	
	public void addArgument(String argumentName, String type) {
		MyDataMember arg = new MyDataMember(argumentName, type);
		getArguments().add(arg);
		System.out.println("Method: " + this.name + " : argument " + arg.getName() + " of type " + arg.getType()  + " is added");
		
	}
}
