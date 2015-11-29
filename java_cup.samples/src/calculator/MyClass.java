package calculator;
import java.awt.Point;
import java.util.ArrayList;

public class MyClass {
	
	private String name;
	private String accessLevel;
	private Point position;
	
	private ArrayList<MyDataMember> dataMembers;
	private ArrayList<MyMethod> methods;
	
	public MyClass() {
		dataMembers = new ArrayList<>();
		methods = new ArrayList<>();
	}
	
	public MyClass(String classname) {
		dataMembers = new ArrayList<>();
		methods = new ArrayList<>();
		
		this.name = classname;
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
	
	public ArrayList<MyDataMember> getDataMembers() {
		
		if(dataMembers == null)
			dataMembers = new ArrayList<>();
		
		return dataMembers;
	}
	
	public void setDataMembers(ArrayList<MyDataMember> dataMembers) {
		
		if(dataMembers == null)
			dataMembers = new ArrayList<>();
		
		this.dataMembers = dataMembers;
	}
	
	public void addDataMember(MyDataMember dataMember) {
		
		if(dataMembers == null)
			dataMembers = new ArrayList<>();
		
		this.dataMembers.add(dataMember);
	}
	
	public ArrayList<MyMethod> getMethods() {
		
		if(methods == null)
			methods = new ArrayList<>();
		
		return methods;
	}
	
	public void setMethods(ArrayList<MyMethod> methods) {
		
		if(methods == null)
			methods = new ArrayList<>();
		
		this.methods = methods;
	}
	
	public void addMethod(MyMethod method) {
		
		if(methods == null)
			methods = new ArrayList<>();
		
		this.methods.add(method);
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	public void setPosition(int x, int y) {
		this.position = new Point(x, y);
	}
	
	public void draw() {
		if(!name.isEmpty()) {
			System.out.println(name);
		}
	}
}
