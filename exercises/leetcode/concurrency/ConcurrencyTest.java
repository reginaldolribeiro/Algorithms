package exercises.leetcode.concurrency;

public class ConcurrencyTest {
    public static void main(String[] args) {

        var n1 = new ThreadTest(1);
        n1.run();

        var n2 = new ThreadTest(2);
        n2.run();




//        var thread1 = new Thread(new ThreadTest(1));
//        var thread2 = new Thread(new ThreadTest(2));
//        var thread3 = new Thread(new ThreadTest(3));
//        thread1.start();
//        thread2.start();
//        thread3.start();
//
//        try {
//            thread1.join();
//            thread2.join();
//            thread3.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Finished running threads.");
    }
}
