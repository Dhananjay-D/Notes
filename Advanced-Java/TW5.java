//Write a multithreaded Java program to work with numbers.
//Multithreading in Java is a process of executing multiple threads simultaneously

package advancedJava;

public class TW5 {
    public static void main(String[] args) {
        Runnable hello = new DisplayMessage("Hello");
        Thread thread1 = new Thread(hello);
        thread1.setDaemon(true);
        thread1.setName("hello");
        System.out.println("Starting hello thread...");
        thread1.start();

        Runnable bye = new DisplayMessage("Goodbye");
        Thread thread2 = new Thread(bye);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.setDaemon(true);
        System.out.println("Starting goodbye thread...");
        thread2.start();

        System.out.println("Starting thread3...");
        Thread thread3 = new GuessANumber(27);
        thread3.start();

        try {
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        System.out.println("Starting thread4...");
        Thread thread4 = new GuessANumber(75);
        thread4.start();

        System.out.println("main() is ending...");
    }
}

class DisplayMessage implements Runnable {
    private String message;

    public DisplayMessage(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 0; i < 10; i++) { // Add a condition to exit the loop
            System.out.println(message);
        }
    }
}

class GuessANumber extends Thread {
    private int number;

    public GuessANumber(int number) {
        this.number = number;
    }

    public void run() {
        int counter = 0;
        int guess = 0;
        do {
            guess = (int) (Math.random() * 100 + 1);
            System.out.println(this.getName() + " guesses " + guess);
            counter++;
        } while (guess != number);
        System.out.println("** Correct! " + this.getName() + " in " + counter + " guesses. **");
    }
}


//is this a program which shows Multithreading??
//        ChatGPT
//        Yes, the provided Java program demonstrates multithreading. Let's go through the main aspects related to multithreading in this program:
//
//        Thread Creation:
//
//        Two threads, thread1 and thread2, are created using the Thread class. They are associated with the Runnable objects
//        hello and bye, respectively. These Runnable objects represent tasks that the threads will execute.
//        Runnable Interface:
//
//        The DisplayMessage class implements the Runnable interface. The run method of this class contains the code that will be executed when the thread is started.
//        In this case, it prints a message in a loop.
//        Thread Starting:
//
//        The threads are started using the start() method. This invokes the run method of the corresponding Runnable or Thread
//class in a new thread.
//        Thread Daemon and Naming:
//
//        thread1 and thread2 are set as daemon threads using setDaemon(true). Daemon threads are background threads that do not prevent the
//        program from exiting if they are still running.
//        thread1 is given the name "hello" using setName("hello"). Naming threads can be helpful for identification and debugging.
//        Thread Priority:
//
//        thread2 is set to have the minimum priority (Thread.MIN_PRIORITY). Thread priorities range from 1 (lowest) to 10 (highest), and the
//default priority is 5.
//        Thread Joining:
//
//        The program uses thread3.join() to make the main thread wait for thread3 to finish before proceeding. This demonstrates synchronization between threads.
//        Random Number Generation:
//
//        The GuessANumber class extends the Thread class and generates random numbers in a loop until it matches a target number. This is an example of a concurrent task.
//        Printing Messages:
//
//        The program prints messages to the console from different threads concurrently, demonstrating the interleaved execution of multiple threads.
//        In summary, the program showcases various aspects of multithreading, including thread creation, synchronization, daemon threads, thread naming,
//        and concurrent execution of tasks. The use of different threads for displaying messages and guessing numbers demonstrates the concurrent nature of multithreading.