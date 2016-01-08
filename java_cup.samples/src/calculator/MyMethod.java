package calculator;


import java.util.ArrayList;

public class MyMethod {
	
	private String name;
	private String accessLevel;
	private String returnType;
	private ArrayList<String> arguments;
	
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
	}
	
	public String getReturnType() {
		return returnType;
	}
	
	public void setReturnType(String returnType) {
		this.returnType = returnType;
		System.out.println(MyMethod.class.getName() + ":" + this.getName() + " return type set to " + getReturnType());
	}
	
	public ArrayList<String> getArguments() {
		
		if(arguments == null)
			arguments = new ArrayList<>();
		
		return arguments;
	}
	
	public void setArguments(ArrayList<String> arguments) {
		
		if(arguments == null)
			arguments = new ArrayList<>();
		
		this.arguments = arguments;
	}
	
	public void addArgument(String argument) {
		
		if(arguments == null)
			arguments = new ArrayList<>();
		
		this.arguments.add(argument);
	}
}
