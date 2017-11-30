
public class Teacher_lesson {
	private int t_id;
	private String t_name;
	private int l_id;
	private int d_hour;
	private int w_hour;
	private String l_name;
	private String l_class;
	private int l_hours;
	
	public Teacher_lesson(int l_id,String l_name,String l_class,int l_hours,int t_id,String t_name,int d_hour,int w_hour){
		this.l_id=l_id;
		this.l_name=l_name;
		this.l_class=l_class;
		this.l_hours=l_hours;
		this.t_id=t_id;
		this.t_name=t_name;
		this.d_hour=d_hour;
		this.w_hour=w_hour;
		
	}
	public Teacher_lesson(){
		this(0,null,null,0,0,null,0,0);
	}

	public int get_lid(){
		return l_id;
	}
	
	public String get_lname(){
		return l_name;
	}
	
	public String get_class(){
		return l_class;
	}
	
	public int get_lhours(){
		return l_hours;
	}
	
	public int get_tid(){
		return t_id;
	}
	
	public String get_tname(){
		return t_name;
	}
	
	
	public int get_td_hour(){
		return d_hour;
	}
	public int get_tw_hour(){
		return w_hour;
	}
	
	
	public void set_tid(int t_id){
		this.t_id=t_id;
	}
	
	public void set_tname(String t_name){
		this.t_name=t_name;
	}
	
	
	public void set_d_hour(int d_hour){
		this.d_hour=d_hour;
	}
	public void set_w_hour(int w_hour){
		this.w_hour=w_hour;
	}
	
	
	public void set_lid(int l_id){
		this.l_id=l_id;
	}
	
	public void set_lname(String l_name){
		this.l_name=l_name;
	}
	
	public void set_class(String l_class){
		this.l_class=l_class;
	}
	
	public void set_lhours(int l_hours){
		this.l_hours=l_hours;
	}
	
	public String toString(){
		return this.t_id+"\t"+ this.t_name+"\t"+this.l_id+"\t"+this.d_hour+"\t"+this.w_hour+"\t"+this.l_name+"\t"+this.l_class;
				
		
	}
	
	public String write(){
		
		return this.t_name+"\n"+this.l_name+"\n"+this.l_class+"\n";
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this==null) { return true;}
		
		return false;
	}
	
}
