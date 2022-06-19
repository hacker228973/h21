class NewThread implements Runnable {

    Thread t;

    NewThread() {


        t = new Thread(this, "Demo Thread");

        t.start();

    }


    public void run() {


        System.out.println("lalalala");
    }

}

