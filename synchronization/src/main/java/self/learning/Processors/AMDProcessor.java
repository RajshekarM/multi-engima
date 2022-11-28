package self.learning.Processors;

import java.util.LinkedList;
import java.util.Queue;
import self.learning.Task;


import self.learning.Interfaces.Processor;

public class AMDProcessor implements Processor {

    Queue<Task> tasksQueue;

    String Processor_Name;

    public AMDProcessor()
    {
        tasksQueue = new LinkedList<Task>();
      
    }
    
    @Override
    public void run() {
    
        tasksQueue.forEach(task-> process(task));
       
    }

   

    @Override
    public void process(Task task) {
        
        System.out.println("AMD Processor running....");
        
    }



    @Override
    public void setTask(Task task) {
       tasksQueue.add(task); 
       System.out.println("Task added to AMD procesor. No of Tasks = " + tasksQueue.size() ) ;
    }

    @Override
    public Task getTask() {
       
        return tasksQueue.peek();
    }


    
    
}
