package task_4;

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
    public long getRunningTimeInSeconds() {
        return (long) (endTime - startTime);
    }

    //Measure and record the execution time of a method.
    public double measureTime(Runnable methodToMeasure) {
        start();
        methodToMeasure.run();
        stop();
        return getRunningTimeInSeconds();
    }
}


