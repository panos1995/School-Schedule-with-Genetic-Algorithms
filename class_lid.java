
public class class_lid implements Comparable<class_lid>{
	private int classid;
	private String classname;
	
	class_lid(int classid,String classname){
		this.classid=classid;
		this.classname=classname;
	}
	public int getid(){
		return this.classid;
		
	}
	public String getname(){
		return this.classname;
	}
	@Override
	public int compareTo(class_lid o) {
		// TODO Auto-generated method stub
		if(this.classid==o.classid && this.classname.equalsIgnoreCase(o.classname)){
		return 1;}
		return -1;
	}

}
