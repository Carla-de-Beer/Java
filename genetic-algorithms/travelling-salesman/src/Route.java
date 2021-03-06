
/**
 * Class that calculates chromosome and the chromosome fitness value.
 */
import java.util.ArrayList;
import java.util.Collections;

public class Route {

	private ArrayList<City> chromosome;
	private double fitness;

	public Route(ArrayList<City> path, boolean isShuffle) {
		this.chromosome = new ArrayList<City>(path);
		if (isShuffle) {
			Collections.shuffle(chromosome);
		}
	}

	public Route(Route other) {
		this.chromosome = new ArrayList<City>(other.getChromosome());
	}

	public double calculateFitness() {
		double sum = sumDistance(chromosome);
		// fitness = 1.0 / sum;
		// fitness = Math.pow(fitness, 4);
		return sum;// fitness;
	}

	private double sumDistance(ArrayList<City> path) {
		double sum = 0.0;
		for (int i = 0; i < path.size() - 1; ++i) {
			City a = path.get(i);
			City b = path.get(i + 1);
			double d = distSq(a.getLon(), a.getLat(), b.getLon(), b.getLat());
			sum += d;
		}
		return sum;
	}

	private double distSq(double x1, double y1, double x2, double y2) {
		return ((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}

	public final double getFitness() {
		return fitness;
	}

	public final ArrayList<City> getChromosome() {
		return chromosome;
	}

	public void setChromosome(ArrayList<City> chromosome) {
		this.chromosome = chromosome;
	}
}
