import java.io.IOException;
import java.util.ArrayList;

/*
 * AI FIRST PROJECT 3130153_3130053
 * NTOYLOS PANAGIWTHS, DHMHTRHS DIMITRAKOPOYLOS
 * to programma mporei na "crasharei" kapoies fores
 */
public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final long startTime = System.currentTimeMillis();
reader_writer x=new reader_writer();

ArrayList<lesson> y=new ArrayList<lesson>();
y=x.readfilelesson("D:\\eclipse\\AI_PROJECT_1\\src\\Files\\lesson");
ArrayList<Teacher> _Teachers=new ArrayList<Teacher>();
_Teachers=x.readfileTeacher("D:\\eclipse\\AI_PROJECT_1\\src\\Files\\Teacher");
ArrayList<Teacher_lesson> _teacherlesson=new ArrayList<Teacher_lesson>();
_teacherlesson=x.Combine(_Teachers, y);


Genetic g = new Genetic();
Chromosome x1 = g.geneticAlgorithm(10, 0.03, 26, 100,_teacherlesson);
x1.printFile("schedule.txt");
final long endTime = System.currentTimeMillis();

System.out.println("Total execution time: " + (endTime - startTime) +"miliseconds" );

}

}

