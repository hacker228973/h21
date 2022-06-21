import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        JobQueue jobQueue = new JobQueue();
        Thread job =  new Thread(() -> {
            while (true){
                Runnable job1 = jobQueue.get();
                job1.run();
            }
        });
        job.start();
for(int i =0;i<100;i++){
    jobQueue.put(getJob());
}


    }
    public static Runnable getJob(){
        return new Runnable() {
            @Override
            public void run() {


                System.out.println("Job is started "+this);
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Job have finished "+this);
            }
        };
    }


    static class JobQueue {
        ArrayList<Runnable> jobs = new ArrayList<>();

        public synchronized void put(Runnable job) {
            jobs.add(job);
            notify();
        }

        public synchronized Runnable get()  {
            while (jobs.isEmpty()) {
                try {
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            Runnable job = jobs.get(0);
            jobs.remove(job);
            return job;
        }
    }
}
