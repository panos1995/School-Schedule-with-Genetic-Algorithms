import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class reader_writer{

	private String name;
	
	public reader_writer(String name){
		this.name=name;
		
	}
	public reader_writer(){
		this("AI_PROJECT1_READER_WRITER");
	}
	
	public String getname(){
		return name;
	}
	
	
	
	public ArrayList<Teacher> readfileTeacher(String path){
		
		ArrayList<Teacher> Teachers=new ArrayList();
		File f = null;
		String line;
		int counter = 3;
		BufferedReader reader = null;
		StringTokenizer st;
		String tid="";
		String tname="";
		String lid="";
		String dhour="";
		String whour="";
		Teacher _Teacher=new Teacher();
		try {
			f = new File(path);
			}
			catch (NullPointerException e) {
			System.err.println("File not found.");
			}
			try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			} catch (FileNotFoundException e) {
			System.err.println("Error opening file!");
			}
			try{
				line = reader.readLine();
				line = reader.readLine();
				line = reader.readLine();
				while(line!=null){
					st=new StringTokenizer(line,"\t");
					tid=st.nextToken();
					int Itid=Integer.parseInt(tid);
					tname=st.nextToken();
					lid=st.nextToken();
					int Ilid=Integer.parseInt(lid);
					dhour=st.nextToken();
					int Idhour=Integer.parseInt(dhour);
					whour=st.nextToken();
					int Iwhour=Integer.parseInt(whour);
					_Teacher= new Teacher(Itid,tname,Ilid,Idhour,Iwhour);
					Teachers.add(_Teacher);
					line=reader.readLine();
					++counter;
					if(line.startsWith("END"))break;
					
					
					
					
				}
		
		
		
		
		
		
			}catch (IOException e) {
				
				System.out.println("Line " + counter + ": Sudden end.");
			}
			try {
				reader.close();
				} catch (IOException e) {
				System.err.println("Error closing file.");
				}
		
		
		return Teachers;
		
		
	}
	
	public ArrayList<lesson> readfilelesson(String path){
		
			
			ArrayList<lesson> lessons=new ArrayList();
			File f = null;
			String line;
			int counter = 3;
			BufferedReader reader = null;
			StringTokenizer st;
			String l_id="";
			String l_name="";
			String l_Class="";
			String l_hours="";
			lesson _lesson=null;
			try {
				f = new File(path);
				}
				catch (NullPointerException e) {
				System.err.println("File not found.");
				}
				try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
				} catch (FileNotFoundException e) {
				System.err.println("Error opening file!");
				}
				try{
					line = reader.readLine();
					line=reader.readLine();
					line=reader.readLine();
					while(line!=null){
						st=new StringTokenizer(line,"\t");
						l_id=st.nextToken();
						int Il_id=Integer.parseInt(l_id);
						l_name=st.nextToken();
						l_Class=st.nextToken();
						l_hours=st.nextToken();
						int il_hours=Integer.parseInt(l_hours);
						_lesson=new lesson(Il_id,l_name,l_Class,il_hours);
						lessons.add(_lesson);
						line=reader.readLine();
						++counter;
						if(line.startsWith("END"))break;
					}
					
			
			
			
			
			
			
				}catch (IOException e) {
					
					System.out.println("Line " + counter + ": Sudden end.");
				}
				try {
					reader.close();
					} catch (IOException e) {
					System.err.println("Error closing file.");
					}
			
			
			return lessons;
	}
	
	/*Combines the 2 Lists with the common lesson_id
	  Returns a Arraylist with Teacher_lesson objects in order to take the data that we need to make the fitnessCalculator method.

	*/
	public ArrayList<Teacher_lesson> Combine(ArrayList<Teacher> _Teachers,ArrayList<lesson> _lessons){
			
		ArrayList<Teacher_lesson> Teachers_lessons =new ArrayList<Teacher_lesson>();
		
		
		
		for( int i = 0; i < _Teachers.size(); i++)
		{
			for(int j = 0; j < _lessons.size(); j++)
			{
				if(_Teachers.get(i).get_l_id() == _lessons.get(j).get_id())
				{
					int l_id = _lessons.get(j).get_id();
					String l_name = _lessons.get(j).get_name();
					String l_class = _lessons.get(j).get_class();
					int l_hours = _lessons.get(j).get_hours();
					int t_id = _Teachers.get(i).get_id();
					String t_name = _Teachers.get(i).get_name();
					int d_hour = _Teachers.get(i).get_d_hour();
					int w_hour = _Teachers.get(i).get_w_hour();
					
					Teacher_lesson teacher = new Teacher_lesson(l_id, l_name, l_class, l_hours, t_id, t_name, d_hour, w_hour);
					
					Teachers_lessons.add(teacher);
				}
			}
		}
		
		return Teachers_lessons;
		
	}
}
