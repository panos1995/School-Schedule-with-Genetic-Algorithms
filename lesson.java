
public class lesson {

	private int l_id;
	private String l_name;
	private String l_class;
	private int l_hours;
	
	
	
	public lesson(int l_id,String l_name,String l_class,int l_hours){
		this.l_id=l_id;
		this.l_name=l_name;
		this.l_class=l_class;
		this.l_hours=l_hours;
	}
	
	public lesson(){
		this(0,null,null,0);
	}
	
	public int get_id(){
		return l_id;
	}
	
	public String get_name(){
		return l_name;
	}
	
	public String get_class(){
		return l_class;
	}
	
	public int get_hours(){
		return l_hours;
	}
	
	
	public void set_id(int l_id){
		this.l_id=l_id;
	}
	
	public void set_name(String l_name){
		this.l_name=l_name;
	}
	
	public void set_class(String l_class){
		this.l_class=l_class;
	}
	
	public void set_hours(int l_hours){
		this.l_hours=l_hours;
	}
	
	public String toString(){
		
		return this.l_id+"\t"+this.l_name+"\t"+this.l_class+"\t"+this.l_hours;
	}
	
}
