package self.learning;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import self.learning.Interfaces.*;

public class DequeuAndProcess implements Runnable{

    private BlockingQueue<Task> queue;
    HashMap<String , Processor> processorCache;
    ExecutorService ProcessTaskThreads;
    public DequeuAndProcess(BlockingQueue<Task> queue, HashMap<String ,Processor> ProcessorCache)
    {
        this.queue = queue;
        this.processorCache = ProcessorCache;
        this.ProcessTaskThreads = Executors.newFixedThreadPool(2);
    }   
    
    @Override
    public void run() {
        System.out.println("Started Processing...................");
        while(true)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            Task task;
            try {
                task = queue.take();
                System.out.println("Task removed is::" + task + ", Task size is-" + queue.size());
                Processor processor = processorCache.get(task.Processor_name);
                try{
                    
                    processor.setTask(task);
                    ProcessTaskThreads.execute(processor);
                }
                    catch(NullPointerException e){if(processor==null)  System.out.println("procssor cannot be found"); } 

                } catch (InterruptedException e) {
              
                e.printStackTrace();
            }
          
        }
        
        
    }
    
}
