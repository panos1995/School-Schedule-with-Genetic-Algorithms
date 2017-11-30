import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Random;
import java.util.ArrayList;

public class Chromosome implements Comparable<Chromosome> {
	 
	private ArrayList<Teacher_lesson> DataList;
	private  final int number_of_Days=5;
	private  final int number_of_hours=7;
	private  final int number_of_classes=6;
	private  final int number_of_professors=10;
	
	private  final int array_size=number_of_Days*getNumberOfHours()*getNumberOfClasses();
	
	private int[] genes;
	//score//
	private int fitness;
	
	//Constructs a random chromosome//
	//each slot of the array represents a timeslot.//
	//x is number of professors
	public Chromosome(ArrayList<Teacher_lesson> list){
		this.genes=new int[array_size];
		Random r= new Random();
		for(int i=0;i<genes.length;i++){
			
			this.genes[i]=r.nextInt(number_of_professors);
		}
		this.DataList=list;
		this.calculateFitness();
	}
	
	public Chromosome(int[] genes,ArrayList<Teacher_lesson> list){
		
		this.genes = new int[array_size];
		for(int i=0; i<genes.length; i++)
		{
			this.genes[i] = genes[i];
		
		}
		this.DataList=list;
		this.calculateFitness();
	}
	
	public int[] getGenes()
	{
		return this.genes;
	}
	
	public int getFitness()
	{
		return this.fitness;
	}
	
	public void setGenes(int[] genes)
	{
		for(int i=0; i<this.genes.length; i++)
		{
			this.genes[i] = genes[i];
		}
	}
	
	public void setFitness(int fitness)
	{
		this.fitness = fitness;
	}
	public void setList(ArrayList<Teacher_lesson> x){
		this.DataList=x;
	}
	public ArrayList<Teacher_lesson> getList(){
		return this.DataList;
	}

	private void calculateFitness() {
		
		
		//**********************BEGIN OF DAYLY EVALUATION***********************//
		int day1=this.getNumberOfHours()*this.getNumberOfClasses();
		int day2=2*day1;
		int day3=3*day1;
		int day4=4*day1;
		int day5=5*day1;
		Teacher_lesson temp=null;
		//day 1//
		HashSet<Integer> closedSet=new HashSet<Integer>();
		
		
		
		for(int i=0;i<day1;i++){
			temp=getdata(this.genes[i]);
			if(temp !=null){
				if(!(closedSet.contains(temp.get_tid()))){
			
				 	
				for(int j=i+1;j<day1;j++){
			
			if(temp.get_tid()==this.genes[j]){
				temp.set_d_hour(temp.get_td_hour()-1);
											}
			}
			closedSet.add(temp.get_tid());
			
			
		}
				//-1 giati den aferesame thn prwti wra otan to vriskei ston pinaka//
				temp.set_d_hour(temp.get_td_hour()-1);
				if(temp.get_td_hour()>0){++this.fitness;}
		}
			
		}
	
		
		
		
		//day2//
		closedSet.clear();;
		
		for(int i=day1;i<day2;i++){
			temp=getdata(this.genes[i]);
			if(temp !=null){
				if(!(closedSet.contains(temp.get_tid()))){
			
				 	
				for(int j=i+1;j<day2;j++){
			
			if(temp.get_tid()==this.genes[j]){
				temp.set_d_hour(temp.get_td_hour()-1);
											}
			}
			closedSet.add(temp.get_tid());
			
			
		}
				//-1 giati den aferesame thn prwti wra otan to vriskei ston pinaka//
				temp.set_d_hour(temp.get_td_hour()-1);
				if(temp.get_td_hour()>0){++this.fitness;}
		}
			
		}
		//day3//
		closedSet.clear();;
		for(int i=day2;i<day3;i++){
			temp=getdata(this.genes[i]);
			if(temp !=null){
				if(!(closedSet.contains(temp.get_tid()))){
			
				 	
				for(int j=i+1;j<day3;j++){
			
			if(temp.get_tid()==this.genes[j]){
				temp.set_d_hour(temp.get_td_hour()-1);
											}
			}
			closedSet.add(temp.get_tid());
			
			
		}
				//-1 giati den aferesame thn prwti wra otan to vriskei ston pinaka//
				temp.set_d_hour(temp.get_td_hour()-1);
				if(temp.get_td_hour()>0){++this.fitness;}
		}
			
		}
		
		//day4//
		closedSet.clear();;
		for(int i=day3;i<day4;i++){
			temp=getdata(this.genes[i]);
			if(temp !=null){
				if(!(closedSet.contains(temp.get_tid()))){
			
				 	
				for(int j=i+1;j<day4;j++){
			
			if(temp.get_tid()==this.genes[j]){
				temp.set_d_hour(temp.get_td_hour()-1);
											}
			}
			closedSet.add(temp.get_tid());
			
			
		}
				//-1 giati den aferesame thn prwti wra otan to vriskei ston pinaka//
				
				temp.set_d_hour(temp.get_td_hour()-1);
				if(temp.get_td_hour()>0){++this.fitness;}
		}
			
		}
		//day5//
		closedSet.clear();;
		for(int i=day4;i<day5;i++){
			temp=getdata(this.genes[i]);
			if(temp !=null){
				if(!(closedSet.contains(temp.get_tid()))){
			
				 	
				for(int j=i+1;j<day5;j++){
			
			if(temp.get_tid()==this.genes[j]){
				temp.set_d_hour(temp.get_td_hour()-1);
											}
			}
			closedSet.add(temp.get_tid());
			
			
		}
				//-1 giati den aferesame thn prwti wra otan to vriskei ston pinaka//
				temp.set_d_hour(temp.get_td_hour()-1);
				if(temp.get_td_hour()>0){++this.fitness;}
				
		}
			/*if(temp.get_td_hour()<0){this.fitness=this.fitness-100;}//adunato na ginei giati o ka8igitis exei parapanw wres apo oti mporei na kanei//
				else if (temp.get_td_hour()==0){this.fitness=this.fitness-2;}//meiwnoume giati o ka8igitis 8a epivarin8ei oles tou tis wres thn idia mera//
				else{++this.fitness;}//kalh prosegisi*/
		}
		//*********************END OF DAILY EVALUATION*****************************//
		
		//**********************START OF WEEKLY EVALUATION************************//
		
		closedSet.clear();
		
	   int 	_weeklyhours = 1;
	   
		for(int i=0;i<day5;i++){
			temp=getdata(this.genes[i]);
			if(temp!=null){
			if(!closedSet.contains(this.genes[i])){
				
			
			for(int j=i+1;j<day5;j++){
				if(temp.get_tid()==this.genes[j]){
					++_weeklyhours;              }
				
			}
			
									
			/*if(_weeklyhours>temp.get_tw_hour()){
				this.fitness=this.fitness-100 ; //adunato na kanei parapanw wres ma8hma//
			}else
				{++this.fitness;}*/
			if(_weeklyhours<temp.get_tw_hour()){++this.fitness;}
			closedSet.add(this.genes[i]);}
			}
		}
		
		//*************END OF WEEKLY EVALUATION**********//
	
		//**START OF LESSON EVALUATION***//
		ArraylistLesson set=new ArraylistLesson();
		class_lid templ=null;
		Teacher_lesson tempj=null;
		int lid=0;
		String _class;
		int _classhours=1;
		for(int i=0;i<day5;i++){
			temp=getdata(this.genes[i]);
			if(temp!=null){
			lid=temp.get_lid();
			_class=temp.get_class();
			templ=new class_lid(lid,_class);
			if(!set.contains(templ)){
				
				for(int j=i+1;j<day5;j++){
					tempj=getdata(this.genes[j]);{
						if(tempj!=null){
							if(temp.get_tid()==tempj.get_tid()){
								if(temp.get_lid()==tempj.get_lid()&&temp.get_class().equalsIgnoreCase(tempj.get_class())){
									++_classhours;
								}
							}
						}
					}
				}
			}
				int hours;
				hours=temp.get_lhours();
			
		if(_classhours==hours){
			++this.fitness;
		}
		set.add(templ);
			}
		}
				
	}
	
	
	public Teacher_lesson getdata (int id){
		
		Teacher_lesson _data=null;
		for(int i=0;i<this.DataList.size();i++){
			
			if(this.DataList.get(i).get_tid()==id){
				_data=this.DataList.get(i);
				return _data;
			}
		}
	return _data;}
		
		
		
	
	
	public void mutate()
	{
		Random r = new Random();
		this.genes[r.nextInt(array_size)] = r.nextInt(array_size);
		this.calculateFitness();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		for(int i=0; i<this.genes.length; i++)
		{
			if(this.genes[i] != ((Chromosome)obj).genes[i])
			{
					return false;
			}
		}
		return true;
	}

	@Override
	public int compareTo(Chromosome o) {
		// TODO Auto-generated method stub

		return this.fitness - o.fitness;
	}

	public  int getNumberOfClasses() {
		return number_of_classes;
	}

	public int getNumberOfHours() {
		return number_of_hours;
	}
	
	public void printFile(String name) throws IOException{
		
		int[] hours=new int[(this.number_of_Days*7)];//pinakas pou apo8hkeuei ta oria twn for gia tis wres ,+1 giati xanete mia 8esi logo 0
			hours[0]=6;
		for(int i=1;i<hours.length;i++){
			hours[i]=(i+1)*6;
		}//{0,7,14,21.....29*7}
		
		BufferedWriter output = null;
		try {
			Teacher_lesson temp =null;
            File file = new File(name);
            output = new BufferedWriter(new FileWriter(file));
            //**** writing info***//
            output.write("\t \t \t \t SCHOOL SCHEDULE      \n\n\n\n");
            output.write("MONDAY 9:00-10:00\t\t\n\n");
            for(int i=0;i<hours[0];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}
            	
            }
            output.write("10:00-11:00\t\t\n\n");
            for(int i=hours[0];i<hours[1];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}
            }
            output.write("11:00-12:00\t\t\n\n");
            for(int i=hours[1];i<hours[2];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}
            }
            output.write("12:00-13:00\t\t\n\n");
            for(int i=hours[2];i<hours[3];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}
            }
            output.write("13:00-14:00\t\t\n\n");
            for(int i=hours[3];i<hours[4];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}
            }
            output.write("14:00-15:00\t\t\n\n");
            for(int i=hours[4];i<hours[5];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}
            }
            output.write("15:00-16:00\t\t\n\n");
            for(int i=hours[5];i<hours[6];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}
            }
            //*********END OF MONDAY********///
            
            output.write("Tuesday 9:00-10:00\t\t\n\n");
            for(int i=hours[6];i<hours[7];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}
            }
            output.write("10:00-11:00\t\t\n\n");
            for(int i=hours[7];i<hours[8];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}
            }
            output.write("11:00-12:00\t\t\n\n");
            for(int i=hours[8];i<hours[9];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}
            }
            output.write("12:00-13:00\t\t\n\n");
            for(int i=hours[9];i<hours[10];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}
            }
            output.write("13:00-14:00\t\t\n\n");
            for(int i=hours[10];i<hours[11];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}
            }
            output.write("14:00-15:00\t\t\n\n");
            for(int i=hours[11];i<hours[12];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}
            }
            output.write("15:00-16:00\t\t\n\n");
            for(int i=hours[12];i<hours[13];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            //*****END OF TUESDAY******/
            output.write("Wednesday 9:00-10:00\t\t\n\n");
            for(int i=hours[13];i<hours[14];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("10:00-11:00\t\t\n\n");
            for(int i=hours[14];i<hours[15];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("11:00-12:00\t\t\n\n");
            for(int i=hours[15];i<hours[16];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("12:00-13:00\t\t\n\n");
            for(int i=hours[16];i<hours[17];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("13:00-14:00\t\t\n\n");
            for(int i=hours[17];i<hours[18];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("14:00-15:00\t\t\n\n");
            for(int i=hours[18];i<hours[19];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("15:00-16:00\t\t\n\n");
            for(int i=hours[19];i<hours[20];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            //***************END OF WEDNESDAY**************//
            output.write("Thursday 9:00-10:00\t\t\n\n");
            for(int i=hours[20];i<hours[21];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("10:00-11:00\t\t\n\n");
            for(int i=hours[21];i<hours[22];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("11:00-12:00\t\t\n\n");
            for(int i=hours[22];i<hours[23];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("12:00-13:00\t\t\n\n");
            for(int i=hours[23];i<hours[24];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("13:00-14:00\t\t\n\n");
            for(int i=hours[24];i<hours[25];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("14:00-15:00\t\t\n\n");
            for(int i=hours[25];i<hours[26];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("15:00-16:00\t\t\n\n");
            for(int i=hours[26];i<hours[27];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            //*END OF THURSDAY//
            output.write("Friday 9:00-10:00\t\t\n\n");
            for(int i=hours[27];i<hours[28];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("10:00-11:00\t\t\n\n");
            for(int i=hours[28];i<hours[29];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("11:00-12:00\t\t\n\n");
            for(int i=hours[29];i<hours[30];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("12:00-13:00\t\t\n\n");
            for(int i=hours[30];i<hours[31];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("13:00-14:00\t\t\n\n");
            for(int i=hours[31];i<hours[32];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("14:00-15:00\t\t\n\n");
            for(int i=hours[32];i<hours[33];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            output.write("15:00-16:00\t\t\n\n");
            for(int i=hours[33];i<hours[34];i++){
            	temp=getdata(this.genes[i]);
            	if(temp==null){
            		output.write("-----\n\n");}
            	else{
            		output.write(temp.write()+"\n\n");
            			}            }
            	//**********END OF FRIDAY*************//
            
            	
            
            
            
            
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) output.close();
        }
    }
		
	}
	

