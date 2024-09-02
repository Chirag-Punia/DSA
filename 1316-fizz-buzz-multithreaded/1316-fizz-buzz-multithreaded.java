class FizzBuzz {
    private int n;
    private int i;
    public FizzBuzz(int n) {
        this.n = n;
        this.i = 1;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while(i <= n){
            while(i <= n && !(i % 3 == 0 && i % 5 != 0)){
                wait();
            }
            if(i <= n){
                i++;
                printFizz.run();
            }
            notifyAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while(i <= n){
            while(i <= n && !(i % 3 != 0 && i % 5 == 0)){
                wait();
            }
            if(i <= n){
                i++;
                printBuzz.run();
            }
            notifyAll();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(i <= n){
            while(i <= n && !(i % 3 == 0 && i % 5 == 0)){
                wait();
            }
            if(i <= n){
                i++;
                printFizzBuzz.run();
            }
            notifyAll();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while(i <= n){
            while(i <= n && !(i % 3 != 0 && i % 5 != 0)){
                wait();
            }
            if(i <= n){
                printNumber.accept(i++);
            }
            notifyAll();
        }
    }
}