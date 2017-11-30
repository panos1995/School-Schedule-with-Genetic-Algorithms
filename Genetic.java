import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Random;

	
	public class Genetic {

		private ArrayList<Chromosome> population;
		private ArrayList<Integer> fitnessBounds;
		public Genetic()
		{
			this.population = null;
			this.fitnessBounds = null;
		}
		public Chromosome geneticAlgorithm(int populationSize, double mutationProbability, int minimumFitness, int maximumSteps,ArrayList<Teacher_lesson> list)
		{
	        //We initialize the population
			initializePopulation(populationSize,list);
			Random r = new Random();
			for(int step=0; step < maximumSteps; step++)
			{
	            //Initialize the new generated population
				ArrayList<Chromosome> newPopulation = new ArrayList<Chromosome>();
				for(int i=0; i < populationSize; i++)
				{
	                //We choose two chromosomes from the population
	                //Due to how fitnessBounds ArrayList is generated, the propability of
	                //selecting a specific chromosome depends on its fitness score
					
					int xIndex = this.fitnessBounds.get(r.nextInt(this.fitnessBounds.size()));
					Chromosome x = this.population.get(xIndex);
					int yIndex = this.fitnessBounds.get(r.nextInt(this.fitnessBounds.size()));
					while(yIndex == xIndex)
					{
						yIndex = this.fitnessBounds.get(r.nextInt(this.fitnessBounds.size()));
					}
					Chromosome y = this.population.get(yIndex);
	                //We generate the "child" of the two chromosomes
					Chromosome child = this.reproduce(x, y,list);
	                //We might then mutate the child
					if(r.nextDouble() < mutationProbability)
					{
						child.mutate();
					}
	                //...and finally add it to the new population
					newPopulation.add(child);
				}
				this.population = new ArrayList<Chromosome>(newPopulation);

	            //We sort the population so the one with the greater fitness is first
				Collections.sort(this.population, Collections.reverseOrder());
	            //If the chromosome with the best fitness is acceptable we return it
				if(this.population.get(0).getFitness() >= minimumFitness)
				{
	                System.out.println("Finished after " + step + " steps...");
					return this.population.get(0);
				}
	            //We update the fitnessBounds arrayList
				this.updateFitnessBounds();
			}

	        System.out.println("Finished after " + maximumSteps + " steps...");
			return this.population.get(0);
		}

	    //We initialize the population by creating random chromosomes
		public void initializePopulation(int populationSize,ArrayList<Teacher_lesson> list)
		{
			this.population = new ArrayList<Chromosome>();
			for(int i=0; i<populationSize; i++)
			{	
				Chromosome temp=new Chromosome(list);
				
				this.population.add(temp);
			}
			this.updateFitnessBounds();
		}

	    //Updates the arraylist that contains indexes of the chromosomes in the population ArrayList
		public void updateFitnessBounds()
		{
			this.fitnessBounds = new ArrayList<Integer>();
			for (int i=0; i<this.population.size(); i++)
			{
				for(int j=0; j<this.population.get(i).getFitness(); j++)
				{
					
					
	                //Each chromosome index exists in the ArrayList as many times as its fitness score
	                //By creating this ArrayList so, and choosing a random index from it,
	                //the greater the fitness score of a chromosome the greater chance it will be chosen.
					fitnessBounds.add(i);
				}
			}
		}

	    //"Reproduces" two chromosomes and generated their "child"
		public Chromosome reproduce(Chromosome x, Chromosome y,ArrayList<Teacher_lesson> list)
		{
			Random r = new Random();
	        //Randomly choose the intersection point
			int intersectionPoint = r.nextInt(x.getGenes().length-1) + 1;
			int [] childGenes = new int[x.getGenes().length];
	        //The child has the left side of the x chromosome up to the intersection point...
			for(int i=0; i<intersectionPoint; i++)
			{
				childGenes[i] = x.getGenes()[i];
			}
	        //...and the right side of the y chromosome after the intersection point
			for(int i=intersectionPoint; i<childGenes.length; i++)
			{
				childGenes[i] = y.getGenes()[i];
			}
			return new Chromosome(childGenes,list);
		}
	
	
}
