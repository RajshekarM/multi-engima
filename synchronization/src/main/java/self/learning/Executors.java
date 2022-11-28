package self.learning;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

import self.learning.Interfaces.Processor;

public class Executors {
    
    public void Start()
    {
        ExecutorService NewTasksThreads = java.util.concurrent.Executors.newFixedThreadPool(1);
        // ExecutorService ReadyTasksThreads = java.util.concurrent.Executors.newFixedThreadPool(1);
        
        ExecutorService ProcessTaskThreads = java.util.concurrent.Executors.newFixedThreadPool(3);

        Queue<Task> TaskQueue = new LinkedList<Task>();

        Task t1 = new Task("first"); t1.Processor_name = "AMD";
        Task t2 = new Task("second"); t2.Processor_name = "Intel";
        Task t3 = new Task("third"); t3.Processor_name ="Mac";

        TaskQueue.add(t1);  TaskQueue.add(t2);  TaskQueue.add(t3);

        HashMap<String, Processor> ProcessorCache = new HashMap<>();

        List<String> ProcessorList = getProcessor();

        ProcessorList.forEach((Processor)->{
            try 
            {
                ProcessorCache.put(Processor, BuildProcessors(Processor));
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                e.printStackTrace();
            }
        });

        TaskQueue.forEach(Task->{
            Processor processor = ProcessorCache.get(Task.Processor_name);
        
            try{
            processor.setTask(Task);
            ProcessTaskThreads.execute(processor);
            }
                catch(NullPointerException e){if(processor==null)  System.out.println("procssor cannot be found"); };
        //  System.out.println("working");
        });

        System.out.println("Processors working");

        //Pushng processors into thread pool(Queue): We are using thread pool of 10 threads size so 10 threads will be creayed
        // and we have 60 processors.
        //So first all the 60 processors will be added to ExecutorService's Queue.
        //At a given time 10 processors will be picked and will be in running state and other 50 will be waiting state
        //can we choose which thread to run ? i think it is discretionary to framework. 

        //How to check whether all thread pools are done execution and are free.

    }
    private List<String> getProcessor() 
    {
        List<String> res=new ArrayList<>();
        res.add("AMD");
        res.add("Intel");
        res.add("Mac");
        return res;
    }


    public Processor BuildProcessors(String Processor) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
    {
        Class<?> claszz = Class.forName("self.learning.Processors."+Processor+"Processor");
        Processor p;
        p = (self.learning.Interfaces.Processor) claszz.getDeclaredConstructor().newInstance();
        
        return p;
        
    }

}


