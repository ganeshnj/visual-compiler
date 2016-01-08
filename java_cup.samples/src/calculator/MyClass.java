package calculator;
import java.awt.Point;
import java.util.ArrayList;

import org.apache.batik.svggen.SVGGraphics2D;

public class MyClass {
	
	private String name;
	private String accessLevel;
	private Point position;
	
	private SVGGraphics2D graphics;
	
	private ArrayList<MyDataMember> dataMembers;
	private ArrayList<MyMethod> methods;
	
	public MyClass() {
		dataMembers = new ArrayList<>();
		methods = new ArrayList<>();
		
		this.position = new Point(100, 100);
	}
	
	public MyClass(String classname) {
		dataMembers = new ArrayList<>();
		methods = new ArrayList<>();
		
		this.name = classname;
		this.position = new Point(100, 100);
	}
	
	public MyClass(String classname, SVGGraphics2D g) {
		dataMembers = new ArrayList<>();
		methods = new ArrayList<>();
		
		this.name = classname;
		this.graphics = g;
		this.position = new Point(100, 100);
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
		System.out.println("Class: " + this.name + " is set " + accessLevel);
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
		this.getDataMembers().add(dataMember);
	}
	
	public ArrayList<MyMethod> getMethods() {
		
		if(methods == null)
			methods = new ArrayList<>();
		
		return methods;
	}
	
	public void setMethods(ArrayList<MyMethod> methods) {
		this.methods = methods;
	}
	
	public void addMethod(MyMethod method) {
		this.getMethods().add(method);
		System.out.println("Method: " + method.getName() + " added successfully to Class: " + this.name);
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	public void setPosition(int x, int y) {
		this.position = new Point(x, y);
		System.out.println("Class: " + this.name + " position is set to " + this.position.toString());
	}
	
	public void draw() {
		
		int y = getPosition().y;
		
		if(!name.isEmpty()) {
			System.out.println(name);
			graphics.drawString(getName(), getPosition().x, y);
			y += 15;
		}
		
		for (MyMethod method : getMethods()) {
			StringBuilder builder = new StringBuilder();
			builder.append(method.getAccessLevel());
			builder.append("\t");
			builder.append(method.getName().toString());
			builder.append("(");
			
			for (String arg : method.getArguments()) {
				builder.append(arg);
				builder.append(",");
			}
			
			builder.deleteCharAt(builder.length()-1);
			
			builder.append(")");
			builder.append(" : ");
			builder.append(method.getReturnType().toString());
			
			System.out.println(builder.toString());
			graphics.drawString(builder.toString(), getPosition().x, y);
			y += 15;
		}
		
		
	}

	public SVGGraphics2D getGraphics() {
		return graphics;
	}

	public void setGraphics(SVGGraphics2D graphics) {
		this.graphics = graphics;
	}
}
