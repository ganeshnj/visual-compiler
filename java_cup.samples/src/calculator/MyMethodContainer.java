package calculator;

import java.util.ArrayList;

public class MyMethodContainer {
	private ArrayList<MyMethod> methods;
	
	public void addMethod(String methodName){
		MyMethod method = new MyMethod(methodName);
		getMethods().add(method);
		System.out.println("Method: " + method.getName() + " created successfully");
	}
	
	public MyMethod getMethod(String mn){
		for (MyMethod method : getMethods()) {
			if(method.getName().equals(mn)) {
				return method;
			}
		}
		return null; 
	}

	public ArrayList<MyMethod> getMethods() {
		if(methods == null){
			methods = new ArrayList<>();
		}
		return methods;
	}

	public void setMethods(ArrayList<MyMethod> methods) {
		this.methods = methods;
	}
}
