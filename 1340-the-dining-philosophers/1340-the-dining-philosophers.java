class DiningPhilosophers {
    Semaphore[] s;

    public DiningPhilosophers() {
        s = new Semaphore[5]; 
        for(int i = 0;i<5;i++){
            s[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public synchronized void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {


        if (philosopher % 2 == 0) {
            s[philosopher].acquire();
            s[(philosopher + 1) % 5].acquire();
        } else {
            s[(philosopher + 1) % 5].acquire();
            s[philosopher].acquire();
        }


        pickLeftFork.run();
        pickRightFork.run();

        eat.run();


        putLeftFork.run();
        putRightFork.run();


        s[philosopher].release();
        s[(philosopher + 1) % 5].release();
    }
}
