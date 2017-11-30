
public class Teacher {

	private int t_id;
	private String t_name;
	private int l_id;
	private int d_hour;
	private int w_hour;
	
	public Teacher(int t_id,String t_name,int l_id,int d_hour,int w_hour){
		this.t_id=t_id;
		this.t_name=t_name;
		this.l_id=l_id;
		this.d_hour=d_hour;
		this.w_hour=w_hour;
	
	}
	
	public Teacher(){
		this(0,null,0,0,0);
	}
	
	public int get_id(){
		return t_id;
	}
	
	public String get_name(){
		return t_name;
	}
	
	public int get_l_id(){
		return l_id;
	
	}
	public int get_d_hour(){
		return d_hour;
	}
	public int get_w_hour(){
		return w_hour;
	}
	
	public void set_id(int t_id){
		this.t_id=t_id;
	}
	
	public void set_name(String t_name){
		this.t_name=t_name;
	}
	public void set_l_id(int l_id){
		this.l_id=l_id;
	}
	public void set_d_hour(int d_hour){
		this.d_hour=d_hour;
	}
	public void set_w_hour(int w_hour){
		this.w_hour=w_hour;
	}
	
	public String toString(){
		
		return this.t_id+"\t"+this.t_name+"\t"+this.l_id+"\t"+this.d_hour+"\t"+this.w_hour;
	}
}
