import java.util.ArrayList;


public class ArraylistLesson {
	
	private ArrayList<class_lid> set;
	ArraylistLesson(){
		this.set=new ArrayList<class_lid>();
	}
	public void add(class_lid i){
		this.set.add(i);
	}
	public boolean contains(class_lid x){
		if(x==null){return false;}
		for(int i=0;i<set.size();i++){
			class_lid check=set.get(i);
			if(check!=null){
				if(check.compareTo(x)>0){
			
				return true;}
			}
				
		}
		return false;
	}
	

}
