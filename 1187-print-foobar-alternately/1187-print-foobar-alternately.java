class FooBar {
    private int n;
    private int turn;
    public FooBar(int n) {
        this.n = n;
        this.turn = 0;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            while(turn != 0)wait();
        	printFoo.run();
            turn = 1;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
        
            // printBar.run() outputs "bar". Do not change or remove this line.
            while(turn != 1)wait();
        	printBar.run();
            turn = 0;
            notifyAll();
        }
    }
}