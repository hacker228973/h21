import java.util.ArrayList;

public class JobQueue {
    ArrayList<Runnable> jobs = new ArrayList<>();
    public synchronized void put(Runnable job) {
        jobs.add(job);
        this.notifyAll();
    }

    public synchronized Runnable get() throws InterruptedException {
        while (jobs.size() == 0) {
            this.wait();
        }
        return jobs.get(0);
    }
}