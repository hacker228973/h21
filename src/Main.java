
public class Main {
    public static void main(String[] args) throws InterruptedException {
        JobQueue jobQueue = new JobQueue();

        for(int i =0;i<100;i++){
            jobQueue.put(new NewThread());
        }
    }
}
