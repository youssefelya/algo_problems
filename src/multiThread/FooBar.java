package multiThread;

public class FooBar{
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) {
        for (int i = 0; i < n; i++) {
            printFoo.run();
        }
    }

    public void bar(Runnable printBar) {
        for (int i = 0; i < n; i++) {
            printBar.run();
        }
    }


}
