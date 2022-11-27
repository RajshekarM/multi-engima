package self.learning;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import self.learning.processors.Processor;

public class TaskProcssingThread implements Runnable{

    Queue<TaskModel> taskQueue;
    HashMap<String, Processor> processorCache;
    public ExecutorService ProcessingThread = Executors.newFixedThreadPool(10);
    public CacheBuilder cache ;
    public TaskProcssingThread(Queue<TaskModel> TaskQueue, HashMap<String, Processor> ProcessorCache ) {

        this.processorCache = ProcessorCache;
    }

    @Override
    public void run() {
      while(!taskQueue.isEmpty())
      {
        TaskModel task = taskQueue.peek();
        
        if(processorCache.containsKey(task.processor_name))
             task.processor = processorCache.get(task.processor_name);
        else taskQueue.add(task);

        ProcessingThread.execute(task.processor);

        
      } 
        
    }
    
}
