package calculator;

import java.util.ArrayList;

public class MyDataMemberContainer {
	private ArrayList<MyDataMember> dataMembers;

	public ArrayList<MyDataMember> getDataMembers() {
		if (dataMembers == null){
			dataMembers = new ArrayList<>();
		}
		return dataMembers;
	}

	public void setDataMembers(ArrayList<MyDataMember> dataMembers) {
		this.dataMembers = dataMembers;
	}
	
	public void addDataMember(String memberName){
		MyDataMember member = new MyDataMember(memberName);
		getDataMembers().add(member);
		System.out.println("Datamember: " + member.getName() + " created successfully");
	}
	
	public MyDataMember getDataMember(String mn){
		for (MyDataMember dataMember : getDataMembers()) {
			if(dataMember.getName().equals(mn)) {
				return dataMember;
			}
		}
		return null; 
	}
}
