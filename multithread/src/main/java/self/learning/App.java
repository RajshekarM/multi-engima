package self.learning;
import self.learning.processors.Processor;
import java.util.HashMap;
import java.util.PriorityQueue;import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
       
      Queue<TaskModel> TasksQueue = new PriorityQueue<TaskModel>();
        
      CacheBuilder cache = new CacheBuilder();

      
      ExecutorService threads = Executors.newFixedThreadPool(4);
       /*  Thread t1 = new Thread(new WorkerThread1(10)); Thread t2 = new Thread(new WorkerThread2(20)); t1.start(); t2.start(); t2.join();  System.out.println("main done");*/
       
      // Thread t1 = new Thread(new TaskReadingThread(TasksQueue));
      threads.execute(new TaskReadingThread(TasksQueue));  
      //factory build pattern to build processors
       Thread t2 = new Thread();


       Thread t3 = new Thread(new TaskProcssingThread(TasksQueue, cache.ProcessorCache));

       Thread t4 = new Thread(new TaskStoringThread());

       System.out.println("Hello Mom");
       
      


    }
   
}
