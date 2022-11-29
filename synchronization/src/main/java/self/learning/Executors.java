package self.learning;
import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;


public class Executors {
    
    BlockingQueue<Task> queue;
    Cache cache;

    public void Start() throws InterruptedException
    {
        Comparator<Task> Taskcomparator = Comparator.comparing(Task->Task.taskName);
        queue = new PriorityBlockingQueue<>();
        cache = new Cache();
        cache.BuildProcessorCache();

        ExecutorService NewTasksThreads = java.util.concurrent.Executors.newSingleThreadExecutor();
        AddTaskQueue addToTasks = new AddTaskQueue(queue);
        NewTasksThreads.execute(addToTasks);


        Thread.sleep(5000);
        NewTasksThreads.shutdown();
       
        // while((queue.size())>0)
        // {
        //     Thread.sleep(5000);
        //     System.out.println("Task removed is:" + queue.take()+ ", Task size is" + queue.size());
        // }


        ExecutorService RunTasksThread = java.util.concurrent.Executors.newSingleThreadExecutor();
        DequeuAndProcess p = new DequeuAndProcess(queue, cache.processorCache);
        RunTasksThread.execute(p);
       
       

       
        //Pushng processors into thread pool(Queue): We are using thread pool of 10 threads size so 10 threads will be created
        // and we have 60 processors.
        //So first all the 60 processors will be added to ExecutorService's Queue.
        //At a given time 10 processors will be picked and will be in running state and other 50 will be waiting state
        //can we choose which thread to run ? i think it is discretionary to framework. 

        //How to check whether all thread pools are done execution and are free.
        //Wht about using barriers.......

    }
    


    
}


