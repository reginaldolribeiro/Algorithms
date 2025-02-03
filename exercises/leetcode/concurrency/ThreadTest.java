package exercises.leetcode.concurrency;

public class ThreadTest implements Runnable{
    int threadNumber;
    public ThreadTest(int number){
        this.threadNumber = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " - Thread number: " + threadNumber);
            try {
                Thread.sleep(1000); // 1 second
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread " + threadNumber + " is finished.");
    }

//    @Override
//    public void run(){
//        for (int i = 1; i <= 5; i++) {
//            System.out.println(i + " from thread number: " + threadNumber);
////            if(threadNumber == 3)
////                throw new RuntimeException();
//            try {
//                Thread.sleep(1000); // 1 second
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        System.out.println("Thread " + threadNumber + " is finished.");
//    }
}
