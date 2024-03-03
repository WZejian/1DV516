package task_3;

public class MethodTimer {
    private long startTime;
    private long endTime;

    // Start measuring time.
    public void start() {
        startTime = System.nanoTime();
    }

    //Stop measuring time.
    public void stop() {
        endTime = System.nanoTime();
    }

    //Get running time in nanoseconds.

    //Get running time in seconds.
    public double getRunningTimeInSeconds() {
        return (double) (endTime - startTime) / 1000000000.0;
    }

    //Measure and record the execution time of a method.
    public double measureTime(Runnable methodToMeasure) {
        start();
        methodToMeasure.run();
        stop();
        return getRunningTimeInSeconds();
    }
}

