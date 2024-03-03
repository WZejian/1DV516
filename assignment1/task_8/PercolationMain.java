package task_8;

import java.util.Random;

public class PercolationMain {

  public static void main(String[] args) {
    Random random = new Random();
    int times = 10000;
    int gridSize = 20;
    double[] probability = new double[times];

    for (int i = 0; i < times; i++) {
      Percolation p = new Percolation(gridSize);
      while(!p.percolates()) {
        int row = random.nextInt(gridSize) + 1;
        int col = random.nextInt(gridSize) + 1;
        p.open(row, col);
      }
      probability[i] = ((double) p.numOfOpenSites()) / (gridSize * gridSize);
      //System.out.println("Probability is " + probability[i]);
    }
    System.out.println(times + " percolates: ");
    System.out.println("The average threshold P* is " + avgThreshold(probability));
    System.out.println("The standard deviation of threshold is " + stdDev(probability));
  }

  /*
   * Calculates the avarage probability.
   */
  public static double avgThreshold(double[] probabilities) {
    int n = probabilities.length;

    double sum = 0;
    for (double p : probabilities) {
        sum += p;
    }

    return sum / n;
  }

  /*
   * Calculates the Standard Deviation of the probabilities 
   */
  public static double stdDev(double[] probabilities) {
    int n = probabilities.length;

    double avg = avgThreshold(probabilities);
    double sumSquaredDiffs = 0;
    for (double p: probabilities) {
        double difference = p - avg;
        sumSquaredDiffs += difference * difference;
    }
    double variance = sumSquaredDiffs / (n - 1); 

    double stdDeviation = Math.sqrt(variance);

    return stdDeviation;
}


  
}
