package calculator;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

import org.apache.batik.swing.*;
import org.apache.batik.svggen.*;
import org.apache.batik.dom.svg.SVGDOMImplementation;

import org.w3c.dom.*;
import org.w3c.dom.svg.*;

public class MyClass {
	private static final int OFFSET = 15;
	private static final int GAP = 15;
	private String name;
	private String accessLevel;
	private Point position;
	private int width;
	
	private SVGGraphics2D graphics;
	
	private ArrayList<MyDataMember> datas;
	private ArrayList<MyMethod> methods;
	
	public MyClass() {
		datas = new ArrayList<>();
		methods = new ArrayList<>();
		
		this.position = new Point(100, 100);
	}
	
	public MyClass(String classname) {
		datas = new ArrayList<>();
		methods = new ArrayList<>();
		
		this.name = classname;
		this.position = new Point(100, 100);
	}
	
	public MyClass(String classname, SVGGraphics2D g) {
		datas = new ArrayList<>();
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
	
	public ArrayList<MyDataMember> getDatas() {
		
		if(datas == null)
			datas = new ArrayList<>();
		
		return datas;
	}
	
	public void setDatas(ArrayList<MyDataMember> dataMembers) {
		
		if(dataMembers == null)
			dataMembers = new ArrayList<>();
		
		this.datas = dataMembers;
	}
	
	public void addData(MyDataMember dataMember) {
		this.getDatas().add(dataMember);
		System.out.println("Datamember: " + dataMember.getName() + " added to Class: " + this.name);
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
		System.out.println("Method: " + method.getName() + " added to Class: " + this.name);
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
		y = y + GAP;
		
		if(!name.isEmpty()) {
			System.out.println("Drawing class: " + getName());
			graphics.drawString(getName(), getPosition().x, y);
			y = y + GAP;
		}
		
		for (MyDataMember dataMember : getDatas()) {
			StringBuilder builder = new StringBuilder();
			builder.append(dataMember.getAccessLevel());
			builder.append("\t");
			builder.append(dataMember.getName().toString());
			builder.append(" : ");
			builder.append(dataMember.getType());
			
			System.out.println(builder.toString());
			graphics.drawString(builder.toString(), getPosition().x, y);
			y = y + GAP;
		}
		
		for (MyMethod method : getMethods()) {
			StringBuilder builder = new StringBuilder();
			builder.append(method.getAccessLevel());
			builder.append("\t");
			builder.append(method.getName().toString());
			builder.append("(");
			
			for (MyDataMember arg : method.getArguments()) {
				builder.append(arg.getName());
				builder.append(" : ");
				builder.append(arg.getType());
				builder.append(",");
			}
			
			builder.deleteCharAt(builder.length()-1);
			
			builder.append(")");
			builder.append(" : ");
			builder.append(method.getReturnType().toString());
			
			System.out.println(builder.toString());
			graphics.drawString(builder.toString(), getPosition().x, y);
			y = y + GAP;
		}
		
		graphics.drawRect(getPosition().x - OFFSET, getPosition().y, getWidth(), getHeight(y));
		
	}

	public SVGGraphics2D getGraphics() {
		return graphics;
	}

	public void setGraphics(SVGGraphics2D graphics) {
		this.graphics = graphics;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		System.out.println("Class: " + this.name + " : width is set to " + width);
	}

	public int getHeight(int y) {
		return  y - getPosition().y;
	}
}
