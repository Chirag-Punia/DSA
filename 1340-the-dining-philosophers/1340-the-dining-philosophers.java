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


        s[philosopher].acquire();
        s[(philosopher+1)%5].acquire();
        
        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        s[philosopher].release();
        putRightFork.run();
        s[(philosopher+1)%5].release();
        
        
    }
}