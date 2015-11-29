package calculator;


import java.util.ArrayList;

public class MyMethod {
	
	private String name;
	private String accessLevel;
	private String returnType;
	private ArrayList<MyDataMember> arguments;
	
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
	}
	
	public ArrayList<MyDataMember> getArguments() {
		
		if(arguments == null)
			arguments = new ArrayList<>();
		
		return arguments;
	}
	
	public void setArguments(ArrayList<MyDataMember> arguments) {
		
		if(arguments == null)
			arguments = new ArrayList<>();
		
		this.arguments = arguments;
	}
	
	public void addArgument(MyDataMember argument) {
		
		if(arguments == null)
			arguments = new ArrayList<>();
		
		this.arguments.add(argument);
	}
}